<?php
$servername="localhost";
$mysql_user="root";
$mysql_pass="";
$dbname="JPWP";
if($_SERVER['REQUEST_METHOD']=='POST'){
    $conn=mysqli_connect($servername, $mysql_user, $mysql_pass, $dbname);
    $email=$_POST['email'];
    $password=$_POST['password'];
    $query="SELECT `name` FROM `registration` WHERE email='$email' AND password='$password'";
    $result=mysqli_query($conn, $query);
    $row=mysqli_fetch_array($result, MYSQLI_ASSOC);
    if($row){
    echo 'Hello ' . $row['name'];
    }else{
    echo("login failed");
    }
    
} else {
    echo("error in request method");
}
?>