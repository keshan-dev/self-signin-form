package edu.nsbm.example.controller;

import edu.nsbm.example.model.UserModel;
import edu.nsbm.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/all-users")
    public List<UserModel> showAll(){
        return userService.showAll();
    }

    @PostMapping("/save-user")
    UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user.getName(),user.getEmail(),user.getAddress());
    }

}
