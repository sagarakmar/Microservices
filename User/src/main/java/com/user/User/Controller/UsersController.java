package com.user.User.Controller;


import com.user.User.Model.HotelUser;
import com.user.User.Model.HotelUserModel;
import com.user.User.Service.UserService;
import com.user.User.Utils.CommonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsersController {

    private Logger logger= LogManager.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value ="/createUser",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelUser> saveUser(@RequestBody HotelUserModel user){
        logger.info("User Creation started for user {} ",user.getFirstName());
        String jsonString=CommonUtilities.convertUserModelIntoJsonString(user);
        HotelUser userObject=CommonUtilities.convertUserModelIntoUserObject(jsonString);
        HotelUser savedUser=userService.saveUser(userObject);
        logger.info("User Creation done for user {} ",user.getFirstName());
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping(value ="/all_users")
    public ResponseEntity<List<HotelUser>> getUsers(){
        logger.info("User All users started");
        List<HotelUser> users=userService.getUsers();
        logger.info("User All users ended");
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping(value ="/user_by_id/{id}")
    public ResponseEntity<HotelUser> getUserByID(@PathVariable("id") String id){
        logger.info("User All users started");
        HotelUser user=userService.getUserById(id);
        logger.info("User All users ended");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
