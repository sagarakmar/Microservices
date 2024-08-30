package com.rating.Service;

import com.rating.Model.Rating;
import com.rating.Repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    IRatingRepository ratingRepository;

    public Rating saveRating(Rating rating){
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatings(){
        return ratingRepository.findAll();
    }

    public Rating getRatingById(String id){
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isPresent()){
            return rating.get();
        }
       return new Rating();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }
}
