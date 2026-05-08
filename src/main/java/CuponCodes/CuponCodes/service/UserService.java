package CuponCodes.CuponCodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CuponCodes.CuponCodes.entity.User;
import CuponCodes.CuponCodes.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String register(User user) {

        User existing = repository.findByUsername(user.getUsername());

        if(existing != null) {
            return "Username already exists";
        }

        repository.save(user);

        return "Registration Successful";
    }

    public User login(String username, String password) {

        User user = repository.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}