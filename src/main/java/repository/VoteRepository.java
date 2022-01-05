package repository;

import model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    boolean delete(int id);

    List<Vote> getAllByDate(LocalDate date);

    void deleteAll();

    Vote get(int id);

    List<Vote> getAll();

    Vote getUserIdAndDate(int userId, LocalDate date);

    Vote save(Vote vote, int userId, int restaurantId);
}
