<?php
include '../connection.php';

$user_id=isset($_GET['id']) ? $_GET['id'] : die();
$jsonObj = json_decode(file_get_contents("php://input"));
	
$old_password = $jsonObj->old_password;
$new_password = $jsonObj->new_password;
$confirm_password=$jsonObj->confirm_password;
	
//$old_password = $_POST['old_password'];
//$new_password = $_POST['new_password'];
//$confirm_password=$POST['confirm_password'];
	
$query="SELECT user_password from user where `user_id`=$user_id";
$result = mysqli_query($conn,$query);	
$check=mysqli_fetch_row($result);

    if($check[0]==$old_password)
    {
        if($new_password==$confirm_password)
        {
            if($new_password==$check[0])
            {
                $res['Message']='New password and Ols password must be different';
                $res['status']='false';
            }
            else
            {
                $query="update `user` set `user_password`='$new_password' where `user_id`=$user_id";		
		$result = mysqli_query($conn,$query);
                if($result)
                {
                    $res['Message']='Your Password is changed Successfully';
                    $res['status']='True';
                }
                else
                {
                    $res['Message']='Something went Wrong';
                    $res['status']='False';
                }
            }
        }
        else
        {
            $res['Message']="New password and confirm password not match";
            $res['status']="false";
        }
    }
    else
    {
        $res['Message']="Old password dont match";
        $res['status']="false";
    }
    echo json_encode($res);
?>
