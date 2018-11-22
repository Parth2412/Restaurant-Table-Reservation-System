<?php

global $pdo_conn;

error_reporting(0);

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;



if($_SERVER['HTTP_HOST']=='localhost')
{
        define('BASE_URL', 'http://localhost/ks-js/at-panel');
        
        $servername="localhost";
        $database_username = 'root';
        $database_password = '';
        $database_name = 'ksjs';
}
else
{
        define('BASE_URL', 'http://apwebtester.in/php/ks-js/at-panel');
        $servername="localhost";
        $database_username = 'apweb_ksjs';
        $database_password = 'CtWcge@;L^e^';
        $database_name = 'apweb_ksjs';	
}
 
header('Access-Control-Allow-Origin: *');

$pdo_conn = new PDO("mysql:host=$servername;dbname=$database_name", $database_username, $database_password,array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));


$project_name = "PREP";


date_default_timezone_set('Asia/Calcutta');

session_start();
//function images_path($imagename)
//{
//    return base_url()."images/2018/02/".str_replace("../", "", $imagename);
//
//}

/*project base url*/
function base_url(){
    
    return BASE_URL;

    
}

function login_page($page_url)
{
    return $_SESSION[$page_url];
}

$upload_path = "images/";

/*fetch data from table*/
function get_result($data)
{
        $query = $GLOBALS['pdo_conn']->prepare($data);
	$query->execute();
        return $result = $query->fetchAll();
}
function get_totalrow($data)
{
        $query = $GLOBALS['pdo_conn']->prepare($data);
	$query->execute();
        return $query->fetchColumn();
}
function get_results($data)
{
        $query = $GLOBALS['pdo_conn']->prepare($data);
	$query->execute();
        $result = $query->fetchAll();
        if(count($result)>0){
        foreach ($result as $details){
            
        }
        }else{
            $details = 0;
        }
        return $details;
}

function login_auth()
{
     
    if(!isset($_SESSION['userlogin_id'])){
        redirect(base_url()."login.php");
    }
    
}

function auto_signout()
{
    
}

function next_previd($tbl,$primary,$id,$condition)
{
    $min_max = $condition==">" ? "min" : "max";
    $next = get_results("select * from $tbl where $primary = (select $min_max($primary) from $tbl where $primary $condition $id)");
//    $next = get_results("SELECT * FROM `$tbl` WHERE `$primary` {$condition} $id order by $primary desc limit 0 ,1");
    return $next["$primary"];
}

function hard_delete($table_name,$where,$id)
{
    $sql = "DELETE FROM $table_name WHERE $where = ?";        
    $q = $GLOBALS['pdo_conn']->prepare($sql);
    $q->execute(array($id));
}

function role_check($page_name,$can_access)
{
    
    if($_SESSION['is_super']==0){
    
        if(isset($_SESSION['is_emp']) && $_SESSION['is_emp']==1){
            $is_admin = 0;
        }else{
            $is_admin = 1;
        }
        
        $query = $GLOBALS['pdo_conn']->prepare("SELECT * FROM `role` where emp_id='".userloginid()."' and form_id='$page_name' and $can_access=1 and is_admin='{$is_admin}'");
        $query->execute();
        $result = $query->fetchAll();
        if(count($result)>0){
            return 1;
        }
        else
        {
            return 0;
        }
    }
    else{
        return 1;   
    }
}

/*set value of form while error occurs*/
function set_value($field){
    
    return isset($_POST[$field]) ? $_POST[$field] : "";
    
}

function get_smtp_setting()
{
    $chek_admin = get_results("select * from tbl_email_smtp where `store_id`='". session_userstore()."'");
    return $chek_admin;
}


/*insert data into table*/
function insert($table_name,$data)
{
        $keys = implode(",", array_keys($data));
        $keys1 = str_replace(":", "", implode(",", array_keys($data)));
        $values = implode("','", array_values($data));
        
        $query = $GLOBALS['pdo_conn']->prepare("INSERT INTO $table_name ($keys1) VALUES ($keys)");
      //   print_r($data); die;
	    $insert = $query->execute($data);
	  
      return $insert;
        
}

function bindinsert($table_name,$data)
{
    
        $qstnmrk = "";
        
        foreach($data as $key => $value){
           $qstnmrk .= "?, ";
        }

        $qstnmrk = rtrim($qstnmrk, ", ");

        $keys = implode(",", array_keys($data));
        $keys1 = str_replace(":", "", implode(",", array_keys($data)));
        $values = implode("','", array_values($data));
        
        $query = $GLOBALS['pdo_conn']->prepare("INSERT INTO $table_name ($keys1) VALUES ($qstnmrk)");
        $id=0;
        foreach($data as $key => $value){
            $id++;
           $query->bindValue($id, $value);
        }
        
        $insert = $query->execute();
	if($insert==TRUE){  
      return $insert;
        }else{
            echo implode(",", $query->errorInfo());
            exit();
        }
        
}


/*Get insert id*/
function insertid()
{
      return $GLOBALS['pdo_conn']->lastInsertId();
}

function today_date()
{
    return date('Y-m-d');
}

function today_datetime()
{
    return date('Y-m-d h:i:s');
}

function is_ajax_request()
{
        return ( ! empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) === 'xmlhttprequest');
}

/*check login*/
 

function userloginid()
{
    return $_SESSION['userlogin_id'];
}

function firmname()
{
    return $_SESSION['current_firm_name'];
}
function firmid()
{
    return $_SESSION['current_firm_id'];
}
function preyear()
{
    return $_SESSION['current_preyear'];
}


/*check login*/


/*update data into table*/
function update($table_name,$data,$where)
{
    
     
    
    $query = "UPDATE $table_name SET ";

        foreach($data as $key => $value){
           $query .= "`".$key."`='". $value."', ";
        }

        $query = rtrim($query, ", ");

        $query .= " where $where";

        $upq = $GLOBALS['pdo_conn']->prepare($query);
        $update = $upq->execute();
          //print_r($GLOBALS['pdo_conn']->errorInfo());
         // echo $query;
//        if($update==TRUE){
        return $update;
//        }else{
//            return $update->errorInfo();
//        }
        
}

/*update data into table*/
function bindupdate($table_name,$data,$where)
{
    
     
    
    $query = "UPDATE $table_name SET ";
        
        foreach($data as $key => $value){
           $query .= "`".$key."`=?, ";
        }

        $query = rtrim($query, ", ");

        $query .= " where $where";

        $upq = $GLOBALS['pdo_conn']->prepare($query);
        $id=0;
        foreach($data as $key => $value){
            $id++;
           $upq->bindValue($id,$value);
        }
        $update = $upq->execute();
          //print_r($GLOBALS['pdo_conn']->errorInfo());
         // echo $query;
        if($update==TRUE){
        return $update;
        }else{
            echo implode(",", $update->errorInfo()); 
            die();
            
        }
        
}

/*For Active deactive*/
function active_deactive($table_name,$value,$where)
{
    $query = "UPDATE $table_name SET is_active=$value";

        $query .= " where $where";

        $upq = $GLOBALS['pdo_conn']->prepare($query);
        $update = $upq->execute();
         
        return $update;
}
/*For delete record is_delete*/
function delete($table_name,$fieldname,$where)
{
    $query = "UPDATE $table_name SET $fieldname=1";

        $query .= " where $where";

        $upq = $GLOBALS['pdo_conn']->prepare($query);
        $update = $upq->execute();
         
        return $update;
}
/*For delete record is_delete*/
function active($table_name,$fieldname,$where)
{
    $query = "UPDATE $table_name SET $fieldname";

        $query .= " where $where";

        $upq = $GLOBALS['pdo_conn']->prepare($query);
        $update = $upq->execute();
         
        return $update;
}

/*For Password MD5*/
function password_encrypt($password)
{
    return md5($password);
}


/*For clean string(Remove all space and special character from string)*/
function clean($string) {
   $string = str_replace(' ', '-', $string); // Replaces all spaces with hyphens.

   return preg_replace('/[^A-Za-z0-9\-]/', '', $string); // Removes special chars.
}

/*shor name if long description we have to view in short*/
function short_name($value){
    $val  = substr($value,0,10);
    $val_lnth = strlen($value);

    if($val_lnth>10){
    $dot = "...";
    }else { $dot = ""; } 
    
    $give_val = $val.$dot;
    
 return $give_val;
    
}

/*change date formate*/
function change_date_format($format,$date)
{
    return date($format, strtotime($date));
}

/*notification for every action on update delete insert will show in admin side.*/
function notification_message($type,$message){
    
    ?>
<style>
    .notimsg{
            position: fixed;
    margin-top: 78px;
    margin-left: 81%;
    z-index: 100;
    }
</style>
<div class="alert alert-<?php echo $type; ?> alert-rounded notimsg" id="noti_message"> 
        <?php echo $message; ?>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> 
            <span aria-hidden="true">&times;</span> 
        </button>
    </div>
<script>

setTimeout(function() {
    $('#noti_message').hide();
}, 3000); 
</script>
<?php    
}


/*for make COMPRESS images*/
function compress_image($source_url, $destination_url, $quality) {

        $info = getimagesize($source_url);

        if ($info['mime'] == 'image/jpeg')
                        $image = imagecreatefromjpeg($source_url);

        elseif ($info['mime'] == 'image/gif')
                        $image = imagecreatefromgif($source_url);

        elseif ($info['mime'] == 'image/png')
                        $image = imagecreatefrompng($source_url);

        imagejpeg($image, $destination_url, $quality);
        return $destination_url;
}
/*for make COMPRESS images*/

/*create Directory*/
function create_dir($dirname){
    
if ( !file_exists($dirname) ) {
    $oldmask = umask(0);  // helpful when used in linux server  
    mkdir ($dirname, 0755);
}

}
/*create Directory*/

/*rename file upload name*/

function rename_file($title,$file_name)
{
    $get_extension = pathinfo($file_name, PATHINFO_EXTENSION);
    
    return str_replace(" ", "_", $title)."_".date('Ymdhis').rand(01,99).".".$get_extension;    
}

/*rename file upload name*/

/*remove space from name*/
function remove_space($name){
    return str_replace(" ", "_", $name);
}
/*remove space from name*/

function getIP() 
{
        return $_SERVER['REMOTE_ADDR'];
}


function redirect($url){
    echo "<script>window.location='$url';</script>";
}


/*file upload option*/
function file_upload($upload_path,$file_name,$temp_file_name,$title_for_file)
{
    
    /*rename file name*/
    $rename_image = rename_file($title_for_file,$file_name);
    /*rename file name*/
    
    $imageurl = $upload_path.$rename_image;
    
    /*compress image*/
    compress_image($temp_file_name, $imageurl, 80);
    /*compress image*/
    
    return $imageurl;

}
/*file upload option*/
function video_upload($upload_path,$file_name,$temp_file_name,$title_for_file)
{
    /*create directory*/
    create_dir($upload_path);

    $yearpath = $upload_path.date('Y')."/";
    create_dir($yearpath);

    $monthpath = $yearpath.date('m')."/";
    create_dir($monthpath);
    /*create directory*/
    
    /*rename file name*/
    $rename_image = rename_file($title_for_file,$file_name);
    /*rename file name*/
    
    $imageurl = $monthpath.$rename_image;
    
    $get_extension = pathinfo($file_name, PATHINFO_EXTENSION);
    if(in_array($get_extension, array('avi','mp4','wmv','mov'))){
        
        move_uploaded_file($temp_file_name, $imageurl);
        
    }
    
    
    /*compress image*/
//    compress_image($temp_file_name, $imageurl, 80);
    /*compress image*/
    
    return $imageurl;

}



function usersidedoc_upload($upload_path,$file_name,$temp_file_name,$title_for_file)
{
    /*create directory*/
    create_dir($upload_path);

    $yearpath = $upload_path.date('Y')."/";
    create_dir($yearpath);

    $monthpath = $yearpath.date('m')."/";
    create_dir($monthpath);
    /*create directory*/
    
    /*rename file name*/
    $rename_image = rename_file($title_for_file,$file_name);
    /*rename file name*/
    
    $imageurl = $monthpath.$rename_image;
    
    $get_extension = pathinfo($file_name, PATHINFO_EXTENSION);
    if(in_array($get_extension, array('pdf','doc','docs','xls'))){
        
        
        move_uploaded_file($temp_file_name, $imageurl);
        
    }
    
    
    /*compress image*/
//    compress_image($temp_file_name, $imageurl, 80);
    /*compress image*/
    
    return str_replace("../admin/", "../", $imageurl);
//    return $imageurl;

}





/*for selected or checked value in form*/
function selected_checked($field,$value,$condition)
{
    return $field==$value ? "$condition" : "";
}

function mail_template($name,$email,$contactnumber,$traveldestination,$traveldate)
{
    $body='<table width="50%" border="1" align="center" cellpadding="5" cellspacing="0" style="font-family:arial,helvetica,sans-serif;text-align:center;">
            <tbody>
                <tr>
                    <td colspan="2" style="padding:5px;background-color:#ff4918;color:#ffffff;font-size:25px;border:1px solid #ff4918;text-align:center;">
                        Bookable Inquiry
                    </td>
                </tr>
                <tr>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;">Name</td>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;"><b>'.$name.'</b></td>
                </tr>
                <tr>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;">Email</td>
                    <td valign="top" style="border:1px solid #ff4918;white-space:nowrap;"><b>'.$email.'</b></td>
                </tr>
                <tr>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;">MobileTelephone</td>
                    <td valign="top" style="border:1px solid #ff4918;white-space:nowrap;"><b>'.$contactnumber.'</b></td>
                </tr>
               
                 

                <tr>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;">Travel Destination</td>
                    <td valign="top" style="border:1px solid #ff4918;white-space:nowrap;"><b>'.$traveldestination.'</b></td>
                </tr>
                <tr>
                    <td valign="top" style="text-align:center;border:1px solid #ff4918;white-space:nowrap;">Travel Date</td>
                    <td valign="top" style="border:1px solid #ff4918;white-space:nowrap;"><b>'.$traveldate.'</b></td>
                </tr>

            </tbody>
        </table>';
    
    return $body;
    
}



function usermail_template($pkg_inquiry_email)
{
    $body='<table width="50%" border="1" align="center" cellpadding="5" cellspacing="0" style="font-family:arial,helvetica,sans-serif;text-align:center;">
            <tbody>
                <tr>
                    <td colspan="2" style="padding:5px;background-color:#ff4918;color:#ffffff;font-size:25px;border:1px solid #ff4918;text-align:center;">
                        Thank You For Your Inquiry We Will Contacting You Soon
                    </td>
                </tr>
    

            </tbody>
        </table>';
    
   require 'mail/vendor/autoload.php';

   $smtp_setting = get_smtp_setting();
   
        $mail = new PHPMailer(true);                              // Passing `true` enables exceptions
        try {
            //Server settings
            $mail->SMTPDebug = 0;                                 // Enable verbose debug output
            $mail->isSMTP();                                      // Set mailer to use SMTP
            $mail->Host = $smtp_setting['smtp_host'];  // Specify main and backup SMTP servers
            $mail->SMTPAuth = true;                               // Enable SMTP authentication
            $mail->Username = $smtp_setting['user_name'];                 // SMTP username
            $mail->Password = $smtp_setting['password'];                           // SMTP password
            $mail->SMTPSecure = $smtp_setting['smtp_secure'];                            // Enable TLS encryption, `ssl` also accepted
            $mail->Port = $smtp_setting['smtp_port'];                                    // TCP port to connect to

            //Recipients
            $mail->setFrom($smtp_setting['user_name'], 'Bookable');
            $mail->addAddress($pkg_inquiry_email, "Bookable");     // Add a recipient


            //Content
            $mail->isHTML(true);                                  // Set email format to HTML
            $mail->Subject = 'Thank You For Inquiry In Bookable';
            $mail->Body    = $body;
            $mail->AltBody = $body;

            $mail->send();
            //echo"<script>alert('Your Inquiry Has Been Submited');</script>";
        } catch (Exception $e) {
           // echo 'Email could not be sent.';
          //  echo 'Mailer Error: ' . $mail->ErrorInfo;
          
         // echo"<script>alert('Please Try After Some Time');</script>";
          
        }
      
    
}

function doc_upload($upload_path,$file_name,$temp_file_name,$title_for_file)
{
    /*create directory*/
    create_dir($upload_path);

    $yearpath = $upload_path.date('Y')."/";
    create_dir($yearpath);

    $monthpath = $yearpath.date('m')."/";
    create_dir($monthpath);
    /*create directory*/
    
    /*rename file name*/
    $rename_image = rename_file($title_for_file,$file_name);
    /*rename file name*/
    
    $imageurl = $monthpath.$rename_image;
    
    $get_extension = pathinfo($file_name, PATHINFO_EXTENSION);
    if(in_array($get_extension, array('pdf','doc','docs','xls'))){
        
        
        move_uploaded_file($temp_file_name, $imageurl);
        
    }
    
    
    /*compress image*/
//    compress_image($temp_file_name, $imageurl, 80);
    /*compress image*/
    
    return $imageurl;

}

function send_email($email_sendto,$subject,$message){
 
    
$headers = "From:Bookable<noreply@wwsptech.com>";
$headers .= "MIME-Version: 1.0\r\n";
$headers .= "Content-type: text/html; charset=iso-8859-1\r\n";

if(mail($email_sendto, $subject, $message, $headers)){
    
    return TRUE;
    
}
else
{
    return FALSE;
}



    
}
function form_val()
{
    echo '<span style="color: red">*</span>';
}

function pagination($count, $href,$limit) {
$output = '';
if(!isset($_REQUEST["page"])) $_REQUEST["page"] = 1;
 
$pages  = ceil($count/$limit);

//if pages exists after loop's lower limit
if($pages>1) {
if(($_REQUEST["page"]-3)>0) {
$output = $output . '<li><a href="' . $href . 'page=1" class="page">1</a></li>';
}
if(($_REQUEST["page"]-3)>1) {
$output = $output . '<li><span>...</span></li>';
}

//Loop for provides links for 2 pages before and after current page
for($i=($_REQUEST["page"]-2); $i<=($_REQUEST["page"]+2); $i++)	{
if($i<1) continue;
if($i>$pages) break;
if($_REQUEST["page"] == $i)
$output = $output . '<li><span class="pgnation_active" id='.$i.' >'.$i.'</span></li>';
else				
$output = $output . '<li><a href="' . $href . "page=".$i . '" class="page">'.$i.'</a></li>';
}

//if pages exists after loop's upper limit
if(($pages-($_REQUEST["page"]+2))>1) {
$output = $output . '<li><span>...</span></li>';
}
if(($pages-($_REQUEST["page"]+2))>0) {
if($_REQUEST["page"] == $pages)
$output = $output . '<li><span class="pgnation_active" id=' . ($pages) .' class="">' . ($pages) .'</span></li>';
else				
$output = $output . '<li><a href="' . $href .  "page=" .($pages) .'" class="page">' . ($pages) .'</a></li>';
}

}
return $output;
}


function date_formt($date)
{
    return date('d/M/Y', strtotime($date));
}

/*insert login log*/

function insert_login_log($login_id,$user_type,$is_login)
{
    $data = array(
        "login_id" => $login_id,
        "user_type" => $user_type,
        "date_time" => date('Y-m-d h:i:sa'),
        "is_login" => $is_login,
        "ip_address" => getIP(),
    );
    bindinsert("login_log", $data);
}

/*insert login log*/

function firm_selecthtml($firmid)
{
     if($_SESSION['is_super']==1){
     $where = "";
    }else{
        $where = "`emp_firm_role`.`emp_id`='". userloginid()."' and";
    }
    if($_SESSION['is_super']==1){
    $get_emp_preyear = get_result("select * from mst_our_firm where `firm_id`='{$firmid}'");
    }else{
        $get_emp_preyear = get_result("SELECT
    `emp_firm_role`.`preyear`
        , `emp_firm_role`.`firm_id`
        , `mst_our_firm`.`firm_name`
    FROM
        `emp_firm_role`
        INNER JOIN `mst_our_firm` 
            ON (`emp_firm_role`.`firm_id` = `mst_our_firm`.`firm_id`) where $where `emp_firm_role`.`preyear`!='' and `emp_firm_role`.`firm_id`='{$firmid}';");
    }
    foreach ($get_emp_preyear as $preyear_details){
        
        $current_month = date('m');
        if($current_month>3){
            $crnt_yearcaps = date('Y');
            $crnt_yearsmall = date('y');
        }else{
            $crnt_yearcaps = date('Y', strtotime("-1 year"));
            $crnt_yearsmall = date('y', strtotime("-1 year"));
        }
    //    echo $crnt_yearsmall;
        if(strtolower($preyear_details['preyear'])== "all" || $_SESSION['is_super']==1){
            $get_firm_details = get_results("select * from mst_our_firm where firm_id='{$firmid}'");
            $preyear = $get_firm_details['preyear'];
            $p = explode("20", $preyear)[1];
//            echo $p;
            $crntyrrr = $crnt_yearcaps+1;
            $selected_mnth = $_SESSION['current_preyear']==$start_year."-".$end_year ? "selected" : "";
            ?>
            <option value="<?php echo $crnt_yearcaps."-".$crntyrrr; ?>" <?php echo $selected_mnth; ?>><?php echo $crnt_yearcaps." - ".$crntyrrr; ?></option>
            <?php
            $id=0;
            for($i=$p;$i<=$crnt_yearsmall;$i++){
                $id++;
    //            $start_year = $i;
    //            $end_year = $start_year+1;
                $start_year = date('Y', strtotime("-$id year", strtotime("$crnt_yearcaps-01-01")));
                $end_year = $start_year+1;
                
                $selected_mnth = $_SESSION['current_preyear']==$start_year."-".$end_year ? "selected" : "";
        ?>
        <option value="<?php echo $start_year."-".$end_year; ?>" <?php echo $selected_mnth; ?>><?php echo $start_year." - ".$end_year; ?></option>
        <?php 
            }
            ?>

            <?php
        }else{
        $pry = explode("-", $preyear_details['preyear'])[1];
        for($i=0;$i<=$pry;$i++){
        $start_year = date('Y', strtotime("-$i year", strtotime("$crnt_yearcaps-01-01")));
        $end_year = $start_year+1;
        $selected_mnth = $_SESSION['current_preyear']==$start_year."-".$end_year ? "selected" : "";
        ?>
        <option value="<?php echo $start_year."-".$end_year; ?>" <?php echo $selected_mnth; ?>><?php echo $start_year." - ".$end_year; ?></option>
        <?php
        }
        ?>

        <?php
        }
    }
}

function ngapp($name)
{
    ?>
    <a ng-click="sort_by('<?php echo $name; ?>');"><i class="fa fa-sort"></i></a>
    <?php 
}
function next_autoincrymnt($table_name)
{        
   $result = get_results("show table status like '$table_name'");
   return $result['Auto_increment']; 
   
}

/*add activity log*/
function add_activity($activity_title,$activity_desc)
{
    $login_id = $_SESSION['userlogin_id'];
    $authoriselog = array(
        "activity_title" => $activity_title,
        "activity_desc" => $activity_desc,
        "activity_datetime" => today_datetime(),
        "activity_by" => $login_id,
    );
    bindinsert("activity_log", $authoriselog);
}
