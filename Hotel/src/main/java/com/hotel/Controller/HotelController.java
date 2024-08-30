package com.hotel.Controller;

import com.hotel.Model.Hotel;
import com.hotel.Model.HotelModel;
import com.hotel.Service.HotelService;
import com.hotel.Utils.CommonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    public static final Logger logger= LogManager.getLogger(HotelController.class);

    @Autowired
    HotelService hotelService;

    @PostMapping(value = "/hotel/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> saveHotel(@RequestBody HotelModel hotelModel){
        String jsonString = CommonUtilities.convertObjectIntoJsonString(hotelModel);
        Hotel hotel = CommonUtilities.convertJsonStringIntoHotel(jsonString);
        return new ResponseEntity<>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping(value = "/hotel/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/hotel/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
    }
}
