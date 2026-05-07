package CuponCodes.CuponCodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CuponCodes.CuponCodes.entity.User;
import CuponCodes.CuponCodes.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User register(User user) {
        return repository.save(user);
    }

    public String login(String username, String password) {

        User user = repository.findByUsername(username);

        if (user == null) {
            return "User not found";
        }

        if (user.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Invalid password";
        }
    }

    // ✅ ADD THIS METHOD
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User loginUser(String username, String password) {

        User user = repository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}