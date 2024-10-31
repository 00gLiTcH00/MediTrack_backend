package smartbits.junior.meditrack.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartbits.junior.meditrack.Entities.UserEntity;
import smartbits.junior.meditrack.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity createUser(String user) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user);
        newUser.setUser_recipes(new ArrayList<>());
        return userRepository.saveAndFlush(newUser);
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}