package com.in28minutes.rest.socialmedia.socialmedia.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;

}
