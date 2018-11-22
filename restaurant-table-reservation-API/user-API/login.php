<?php
include '../connection.php';
	
//$jsonObj = json_decode(file_get_contents("php://input"));
//$user_email = $jsonObj->user_email;
//$user_password = $jsonObj->user_password;
//	

$user_email = $_POST['user_email'];
$user_password = $_POST['user_password'];
	
$query="SELECT * from user where `user_email`='$user_email' and `user_password`='$user_password'";
$result = mysqli_query($conn,$query);	
if (mysqli_num_rows($result)>0) 
{
    $res['Message']='User Logged in Successfully';
    $res['status']='True';
    while($row = mysqli_fetch_assoc($result))
    {
        $res['data']=$row;
    }
}	
else
{	
    $res['Message']='User ID or Password is Wrong';
    $res['status']='False';
}	
echo json_encode($res);
?>