package com.user.User.Service;


import com.user.User.ExceptionHandeler.CustomException;
import com.user.User.Model.Hotel;
import com.user.User.Model.HotelUser;
import com.user.User.Model.Rating;
import com.user.User.Repository.IUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger logger= LogManager.getLogger(UserService.class);

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private RestTemplate restTemplate;

    public HotelUser saveUser(HotelUser user){
        return iUserRepository.save(user);
    }

    public List<HotelUser> getUsers(){
        return iUserRepository.findAll();
    }

    public HotelUser getUserById(String id){
        Optional<HotelUser> user=iUserRepository.findById(id);
        if (user.isPresent()){
            HotelUser userObject = user.get();
            Rating[] arrayList = restTemplate.getForObject("http://RATING/rating/users/402881859195362201919536872a0000", Rating[].class);
            List<Rating> ratingList = Arrays.asList(arrayList);
            List<Rating> ratingWithHotelObject=ratingList.stream().map(rating -> {
                   rating.getHotelId();
                ResponseEntity<Hotel> hotel=restTemplate.getForEntity("http://HOTEL/hotel/"+rating.getHotelId(), Hotel.class);
                rating.setHotel(hotel.getBody());
                return rating;
            }).collect(Collectors.toList());
            logger.info("{}",ratingWithHotelObject);
            userObject.setRatings(ratingWithHotelObject);
            return userObject;
        }
        throw new CustomException("No Record found for given id "+id);
    }
}
