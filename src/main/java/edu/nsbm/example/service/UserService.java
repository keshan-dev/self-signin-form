package edu.nsbm.example.service;

import edu.nsbm.example.entity.UserEntity;
import edu.nsbm.example.model.UserModel;
import edu.nsbm.example.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> showAll(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();

        for (UserEntity userEntity: userEntities){
            UserModel userModel = new UserModel();
            userModel.setId(userEntity.getId());
            userModel.setName(userEntity.getName());
            userModel.setEmail(userEntity.getEmail());

            userModels.add(userModel);

        }
        return userModels;
    }

    public UserEntity saveUser(String name,String email){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);

    }
}
