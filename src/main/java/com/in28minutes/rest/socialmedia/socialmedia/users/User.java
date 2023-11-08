package com.in28minutes.rest.socialmedia.socialmedia.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min=4,message = "Minimum length should be 4 characters")
    private String name;
    @Past(message = "Date should be of past")
    private LocalDate dateOfBirth;
}
