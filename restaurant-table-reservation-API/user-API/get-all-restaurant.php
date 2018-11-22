<?php
    include '../connection.php';
    
    $restaurant_id=isset($_GET['id']) ? $_GET['id'] : 0;
    
    $query="SELECT
    restaurant.restaurant_id
    , restaurant.restaurant_2s_table
    , restaurant.restaurant_4s_table
    , restaurant.restaurant_6s_table
    , restaurant.restaurant_8s_table
    , restaurant.restaurant_address
    , restaurant.restaurant_detail
    , restaurant.restaurant_image
    , restaurant.restaurant_name
    , restaurant.restaurant_total_table
    , city.city_name
FROM
    restaurant_table_reservation.restaurant
    INNER JOIN restaurant_table_reservation.city 
    where restaurant.cityObj_city_id=city.city_id";
    
    if($restaurant_id!=0){
        $query .= " and restaurant.cityObj_city_id=$restaurant_id";
    }
    
    $res=mysqli_query($conn,$query);
    
    if($res)    
    {
        $result['Message']="Restaurant List";
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
            $result['Message']='Records not found';
        }
    }
    echo json_encode($result);

?>