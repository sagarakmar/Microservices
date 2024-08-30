package com.rating.Utils;

import com.google.gson.Gson;
import com.rating.Model.Rating;

public class CommonUtilities {

    private static final Gson gson = new Gson();

    public static Rating convertJsonStringIntoRating(String json){
        return gson.fromJson(json,Rating.class);
    }

    public static String convertObjectIntoJsonString(Object o){
        return gson.toJson(o);
    }
}
