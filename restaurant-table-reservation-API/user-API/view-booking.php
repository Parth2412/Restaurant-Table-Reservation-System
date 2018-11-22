<?php

include '../connection.php';

$id=isset($_GET['id']) ? $_GET['id'] : die();

$query="SELECT
    booking.booking_id,
    booking.booking_name
    , booking.booking_date
    , booking.booking_time
    , booking.booking_contact_no
    , booking.no_of_person
    , restaurant.restaurant_image
    , restaurant.restaurant_name
FROM
    restaurant_table_reservation.booking
    INNER JOIN restaurant_table_reservation.restaurant 
        ON (booking.restaurant_id = restaurant.restaurant_id) where user_id={$id}";

 $res=mysqli_query($conn,$query);
    
    if($res)    
    {
        $result['Message']="Booking List";
        $result['status']="True";
        $i = 0;
        if (mysqli_num_rows($res)>0) 
        {
            while($row = mysqli_fetch_assoc($res)) 
            {
                $result['data'][]=$row;
            }
        }
        else
        {
            $result['status']=false;
            $result['Message']='You have no Bookings';
        }
    }
    echo json_encode($result);
?>