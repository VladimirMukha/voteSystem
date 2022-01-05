package repository;

import model.Restaurant;
import model.User;
import model.Vote;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import utilits.Constants;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class VoteRepositoryImpl implements VoteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Vote save(Vote vote, int userId, int restaurantId) {
        vote.setUser(manager.getReference(User.class, userId));
        vote.setRestaurant(manager.getReference(Restaurant.class, restaurantId));
        if (vote.isNew()) {
            manager.persist(vote);
            return vote;
        } else {
            return manager.merge(vote);
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return manager.createNamedQuery(Constants.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Transactional
    @Override
    public void deleteAll() {
        manager.createNamedQuery(Constants.DELETE_ALL).executeUpdate();
    }

    @Override
    public Vote get(int id) {
        return manager.find(Vote.class, id);
    }

    @Override
    public Vote getUserIdAndDate(int userId, LocalDate date) {
        List<Vote> votes = manager.createNamedQuery(Constants.GET_USER_AND_DATE, Vote.class)
                .setParameter("userId", userId)
                .setParameter("date", date)
                .getResultList();
        return DataAccessUtils.singleResult(votes);
    }

    @Override
    public List<Vote> getAll() {
        return manager.createNamedQuery(Constants.GET_ALL, Vote.class).getResultList();
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return manager.createNamedQuery(Constants.GET_ALL_DATE, Vote.class)
                .setParameter("date", date)
                .getResultList();
    }
}
