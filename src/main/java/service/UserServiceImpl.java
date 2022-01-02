package service;

import model.Restaurant;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User get(Integer id) {
        assert (id > 0);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User add(User user) {
        Assert.notNull(user, "The class must not be null");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void vote(Restaurant restaurant, Integer userLogin) {
        Assert.notNull(restaurant, "Restaurant must not be null");
        User newUser = userRepository.findById(userLogin).orElse(null);
        Assert.notNull(newUser, "User не найден");
        if (!newUser.getRestaurants().isEmpty()) {
            newUser.getRestaurants().clear();
        }
        newUser.getRestaurants().add(restaurant);
    }
}
