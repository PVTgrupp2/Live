<html>
<head>
	<style>
	.custom-file-upload {
    border: 1px solid #e7c0bb;
    display: inline-block;
    /*padding: 7px 15px;*/
    padding: 7px 0px;
    cursor: pointer;
    color: #b03120;
    font-size: 45px;
    width: 300px;
    
	}
	input[type="file"] {
    display: none;

	}

	.style{
	text-align: center;
	top: 35%;
	position: relative;
	}
	input.substyle{	
    width: 300px;
    height: 50px;
    font-size: 30px;
    color: #b03120;
    border: 1px solid #e7c0bb;
    background-color: #fff;
	}
	</style>
</head>

<div class="style">
<form enctype="multipart/form-data" method="post" action="upload.php">
<label for="picture" class="custom-file-upload">
    Välj bild
</label>
<input type="file" capture="camera" accept="image/*" id="picture" name="uploadedfile" >
<br /><br />
<input type="submit" class="substyle" value="Ladda upp bilden"/>
</form>
</div>
</html>