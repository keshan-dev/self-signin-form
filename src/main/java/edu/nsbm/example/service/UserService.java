package edu.nsbm.example.service;

import edu.nsbm.example.entity.UserEntity;
import edu.nsbm.example.model.UserModel;
import edu.nsbm.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<UserModel> showAllByPage(int page,int size,String sortfield,String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortfield).ascending() : Sort.by(sortfield).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return userRepository.findAll(pageable).map(userEntity -> {
            UserModel userModel = new UserModel();
            userModel.setId(userEntity.getId());
            userModel.setName(userEntity.getName());
            userModel.setEmail(userEntity.getEmail());
            return userModel;
        });
    }

//        List<UserEntity> userEntities = userRepository.findAll();
//        List<UserModel> userModels = new ArrayList<>();
//
////        for (UserEntity userEntity: userEntities){
////            UserModel userModel = new UserModel();
////            userModel.setId(userEntity.getId());
////            userModel.setName(userEntity.getName());
////            userModel.setEmail(userEntity.getEmail());
////            userModel.setAddress(userEntity.getAddress());
////
////            userModels.add(userModel);
////
////        }
////        return userModels;


    public UserModel saveUser(String name,String email,String address){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        userEntity.setAddress(address);

        UserEntity savedUser = userRepository.save(userEntity);

        UserModel userModel = new UserModel();
        userModel.setId(savedUser.getId());
        userModel.setName(savedUser.getName());
        userModel.setEmail(savedUser.getEmail());
        userModel.setAddress(savedUser.getAddress());

        return userModel;

    }
}
