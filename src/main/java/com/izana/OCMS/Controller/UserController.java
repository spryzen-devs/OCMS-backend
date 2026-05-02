package com.izana.OCMS.Controller;

import com.izana.OCMS.DTO.LoginRequest;
import com.izana.OCMS.Entity.User;
import com.izana.OCMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.RegisterUser(user);
    }

    @PostMapping("/login")
    public User Login(@RequestBody LoginRequest request){
        return userService.LoginUser(request);
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
