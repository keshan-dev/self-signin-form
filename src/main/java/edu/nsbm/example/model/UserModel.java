package edu.nsbm.example.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Integer id;
    private String name;
    private String email;
}
