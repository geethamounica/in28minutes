package com.in28minutes.rest.socialmedia.socialmedia.services;

import com.in28minutes.rest.socialmedia.socialmedia.users.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private final static List<User>  users = new ArrayList<>();
    private static int userCount=0;

    static{
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(20)));
    }
    public User findId(Integer id){
        return  users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteId(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
