package com.izana.OCMS.Service;

import com.izana.OCMS.DTO.LoginRequest;
import com.izana.OCMS.Entity.User;
import com.izana.OCMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User RegisterUser(User user){
        boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if(emailExists){
            throw new RuntimeException("Email already exists");
        }
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User LoginUser(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if(user == null){
            throw new RuntimeException("User not found");
        }
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String userRole = user.getRole();
        String requestRole = request.getRole();
        if(!userRole.equals(requestRole)){
            throw new RuntimeException("Invalid role");
        }
        return user;
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
