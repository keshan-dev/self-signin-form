package edu.nsbm.example.service;

import edu.nsbm.example.entity.UserEntity;
import edu.nsbm.example.model.UserModel;
import edu.nsbm.example.repository.UserRepository;
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

    public UserModel saveUser(String name,String email){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);

        UserEntity savedUser = userRepository.save(userEntity);

        UserModel userModel = new UserModel();
        userModel.setId(savedUser.getId());
        userModel.setName(savedUser.getName());
        userModel.setEmail(savedUser.getEmail());

        return userModel;

    }
}
