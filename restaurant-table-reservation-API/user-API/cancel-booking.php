<?php

include '../connection.php';

$id=isset($_GET['id']) ? $_GET['id'] : die();

$query="delete from booking where booking_id=$id";

 $res=mysqli_query($conn,$query);
    
    if($res)    
    {
        $result['Message']="Booking List";
        $result['status']="True";
        
    }
    else
    {
        $result['Message']="Your booking has been successfully canceled";
        $result['status']="False";
    }
    echo json_encode($result);
?>