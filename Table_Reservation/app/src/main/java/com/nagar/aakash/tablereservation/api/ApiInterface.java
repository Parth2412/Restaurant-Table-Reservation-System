package com.nagar.aakash.tablereservation.api;


import com.nagar.aakash.tablereservation.result.BookingResult;
import com.nagar.aakash.tablereservation.result.DeleteBookingResult;
import com.nagar.aakash.tablereservation.result.RestaurantResult;
import com.nagar.aakash.tablereservation.result.UserResult;
import com.nagar.aakash.tablereservation.result.ViewBookingResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {


    @FormUrlEncoded
    @POST("signup.php")
    Call<UserResult> signUpUser(@Field("user_name") String user_name,
                                @Field("user_email") String user_email,
                                @Field("user_password") String user_password,
                                @Field("user_contact_no") Integer user_contact_no);

    @FormUrlEncoded
    @POST("login.php")
    Call<UserResult> loginUser(@Field("user_email") String user_email,
                               @Field("user_password") String user_password);

    @GET("get-all-restaurant.php")
    Call<RestaurantResult> getAllRestaurant(@Query("id") int id);

    @FormUrlEncoded
    @POST("booking.php")
    Call<BookingResult> bookingUser(@Field("booking_name") String booking_name,
                                    @Field("booking_date") String booking_date,
                                    @Field("booking_time") String booking_time,
                                    @Field("booking_contact_no") String booking_contact_no,
                                    @Field("no_of_person") String no_of_person,
                                    @Field("restaurant_id") Integer restaurant_id,
                                    @Field("user_id") Integer user_id);

    @GET("view-booking.php")
    Call<ViewBookingResult> viewBooking(@Query("id") Integer id);

    @GET("cancel-booking.php")
    Call<DeleteBookingResult> deleteBooking(@Query("id") Integer id);
}