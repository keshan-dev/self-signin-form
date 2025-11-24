package edu.nsbm.example.controller;

import edu.nsbm.example.model.UserModel;
import edu.nsbm.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/all-users")
    public Page<UserModel> showAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir){

        return userService.showAllByPage(page,size,sortField,sortDir);
    }


    @PostMapping("/save-user")
    UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user.getName(),user.getEmail(),user.getAddress());
    }

}
