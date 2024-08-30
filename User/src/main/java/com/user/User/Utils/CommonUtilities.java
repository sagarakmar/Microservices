package com.user.User.Utils;

import com.google.gson.Gson;
import com.user.User.Model.HotelUser;


public class CommonUtilities{

    private static Gson gson=new Gson();

    public static HotelUser convertUserModelIntoUserObject(String jsonString){
        return gson.fromJson(jsonString, HotelUser.class);
    }

    public static String convertUserModelIntoJsonString(Object object){
        return gson.toJson(object);
    }
}
