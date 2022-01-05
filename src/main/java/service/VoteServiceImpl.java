package service;

import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import repository.VoteRepository;
import utilits.Validation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VoteServiceImpl implements VoteService {
    private VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return voteRepository.getAllByDate(date);
    }

    @Override
    public Vote get(int id) {
        return Validation.checkNotFoundWithId(voteRepository.get(id), id);
    }

    @Override
    public Vote getUserIdAndDate(int userId, LocalDate date) {
        return Validation.checkNotFound(voteRepository.getUserIdAndDate(userId, date),
                "user id=" + userId + ", date=" + date);
    }

    @Override
    public void delete(int id) {
        Validation.checkNotFoundWithId(voteRepository.delete(id), id);
    }

    @Override
    public void deleteAll() {
        voteRepository.deleteAll();
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    @Override
    public Vote create(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        Vote voteNew = voteRepository.getUserIdAndDate(userId, vote.getDate());
        if (voteNew == null) {
            return voteRepository.save(vote, userId, restaurantId);
        }
        if (LocalTime.now().isBefore(LocalTime.of(11, 0))) {
            return voteRepository.save(voteNew, userId, restaurantId);
        } else {
            throw new IllegalStateException("Too late for changed mind");
        }
    }
}