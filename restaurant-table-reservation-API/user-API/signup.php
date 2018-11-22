<?php
include '../connection.php';

//$jsonObj=  json_decode(file_get_contents("php://input"));
//$user_name=$jsonObj->user_name;
//$user_email=$jsonObj->user_email;
//$user_password=$jsonObj->user_password;
//$user_contact_no=$jsonObj->user_contact_no;

$user_name = $_POST['user_name'];
$user_email = $_POST['user_email'];
$user_password = $_POST['user_password'];
$user_contact_no = $_POST['user_contact_no'];
        
$query="INSERT INTO `user`(`user_name`, `user_email` , `user_password` , `user_contact_no`) VALUES ('$user_name', '$user_email', '$user_password', '$user_contact_no')";

$result = mysqli_query($conn,$query);
if($result) 
{	
    $res['Message']='User Registered Successfully';
    $res['status']='True';		
    $query="SELECT * from user where `user_email`='$user_email' and `user_password`='$user_password'";
    $result = mysqli_query($conn,$query);
    while($row = mysqli_fetch_assoc($result))
    {
        $res['data']=$row;
    }
}
else
{
    $res['Message']='User Not Registered Successfully';
    $res['status']='False';
}	
echo json_encode($res);

?>