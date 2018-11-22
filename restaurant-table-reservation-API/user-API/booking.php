<?php
include '../connection.php';

//$jsonObj=  json_decode(file_get_contents("php://input"));
//$booking_name=$jsonObj->booking_name; 
//$booking_date_time=$jsonObj->booking_date_time;
//$booking_date=date('Y-m-d',strtotime($booking_date_time));
//$booking_time=date('H:i:s',strtotime($booking_date_time));
//$booking_contact_no=$jsonObj->booking_contact_no;  
//$no_of_person=$jsonObj->no_of_person;  
//$restaurant_id=$jsonObj->restaurant_id; 

$booking_name=$_POST['booking_name']; 
$booking_date=$_POST['booking_date'];  
$booking_time=$_POST['booking_time'];  
$booking_contact_no=$_POST['booking_contact_no'];  
$no_of_person=$_POST['no_of_person'];  
$restaurant_id=$_POST['restaurant_id']; 
$user_id=$_POST['user_id'];
        
        $query ="insert into booking (`booking_name`,`booking_date`,`booking_time`,`booking_contact_no`,`no_of_person`,`restaurant_id`,`user_id`) values ('$booking_name','$booking_date','$booking_time','$booking_contact_no','$no_of_person','$restaurant_id','$user_id')";

	$result = mysqli_query($conn,$query);
        
	if($result) {	
		$res['Message']='Your table is reserved successfully';
                
		$res['status']='True';
		
		
	}
	else{
		$res['Message']='Something went wrong...Please try again after sometime';
		$res['status']='False';
	}	
        $res['Message'] = $query;
	echo json_encode($res);

?>