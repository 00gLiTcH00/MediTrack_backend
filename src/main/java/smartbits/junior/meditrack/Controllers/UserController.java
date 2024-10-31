package smartbits.junior.meditrack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartbits.junior.meditrack.Entities.UserEntity;
import smartbits.junior.meditrack.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get_all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get_by_id/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get_by_username/{username}")
    public UserEntity getByUsername(String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody RegisterUser user) {
        return userService.createUser(user.username());
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        user.setUser_ID(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/test_req")
    public String TestRequest() {
        return "TEST REQUEST USER";
    }

    public record RegisterUser(String username){

    }
}