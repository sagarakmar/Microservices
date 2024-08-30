package com.rating.Controller;



import com.rating.Model.Rating;
import com.rating.Model.RatingModel;
import com.rating.Service.RatingService;
import com.rating.Utils.CommonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/rating")
public class RatingController {

    private static final Logger logger = LogManager.getLogger(RatingController.class);

    @Autowired
    RatingService ratingService;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> saveRating(@RequestBody RatingModel ratingModel){
        logger.info("Rating Creation started for user {} ",ratingModel.getUserId());
        String jsonString= CommonUtilities.convertObjectIntoJsonString(ratingModel);
        Rating ratingObject=CommonUtilities.convertJsonStringIntoRating(jsonString);
        Rating rating = ratingService.saveRating(ratingObject);
        logger.info("Rating Creation done for user {} ",ratingModel.getUserId());
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){

        logger.info("Get Rating by user Id {} started",userId);
        List<Rating> ratings = ratingService.getRatingByUserId(userId);
        logger.info("Get Rating by user Id {} ended",userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping(value = "/hotels/{hotelId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> getHotelByUserId(@PathVariable("hotelId") String hotelId){

        logger.info("Get Rating by hotel Id {} started",hotelId);
        List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
        logger.info("Get Rating by hotel Id {} ended",hotelId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping(value = "/ratings",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> getRatingList(){

        logger.info("Get All Rating started");
        List<Rating> ratings = ratingService.getRatings();
        logger.info("Get All Rating ended");
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
