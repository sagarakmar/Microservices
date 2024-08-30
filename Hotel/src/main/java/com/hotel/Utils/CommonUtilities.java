package com.hotel.Utils;

import com.google.gson.Gson;
import com.hotel.Model.Hotel;

public class CommonUtilities {

    public static final Gson gson = new Gson();

    public static String convertObjectIntoJsonString(Object o){
        return gson.toJson(o);
    }

    public static Hotel convertJsonStringIntoHotel(String json){

        return gson.fromJson(json,Hotel.class);
    }
}
