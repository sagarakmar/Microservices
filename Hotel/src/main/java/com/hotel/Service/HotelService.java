package com.hotel.Service;

import com.hotel.Model.Hotel;
import com.hotel.Repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    IHotelRepository hotelRepository;
    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel findById(String id){
        return hotelRepository.findById(id).orElseThrow();
    }

    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }
}
