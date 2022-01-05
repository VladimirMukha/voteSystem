package service;

import model.Vote;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    Vote create(Vote vote, int userId, int restaurantId);

    Vote getUserIdAndDate(int userId, LocalDate date);

    void delete(int id) throws ChangeSetPersister.NotFoundException;

    void deleteAll();

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate date);

    Vote get(int id) throws ChangeSetPersister.NotFoundException;
}