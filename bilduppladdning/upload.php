<?php
ob_start();
$target_path = "photos/";

$target_path = $target_path . basename( $_FILES['uploadedfile']['name']); 

if(move_uploaded_file($_FILES['uploadedfile']['tmp_name'], $target_path)) {
	header("Location: https://pvt.dsv.su.se/Group2/web/allinone.html");
	die();
	
} else{
    echo "There was an error uploading the file, please try again!";
}

function getNextNumber() {
    $count = (int)file_get_contents('yourFile.txt');
    $count+=1;
    file_put_contents('yourFile.txt',$count);
    return $count;
}

?>