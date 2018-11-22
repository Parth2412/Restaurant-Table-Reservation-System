package com.nagar.aakash.tablereservation.Utilities;

import com.nagar.aakash.tablereservation.pojos.UserPOJO;

public class MyConstants {
    public static final String BASE_IMAGE_URL = "http://192.168.137.1:8080/restaurant-table-reservation/uploads/";
    private static UserPOJO USER_DETAIL;

    public static UserPOJO getUserPOJO(){
        if(USER_DETAIL == null){
            USER_DETAIL = new UserPOJO();
        }
        return USER_DETAIL;
    }
}
