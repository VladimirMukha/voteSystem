package service;

import model.Restaurant;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void delete(Integer id) {
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void vote(Restaurant restaurant, Integer loggingUserId) {
    }
}
