package edu.nsbm.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserModel {

    private Integer id;
    private String name;
    private String email;
}
