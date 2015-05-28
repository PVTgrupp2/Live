<html>
<head>
	<style>
	.custom-file-upload {
    border: 1px solid #ccc;
    display: inline-block;
    padding: 6px 12px;
    cursor: pointer;
	}
	input[type="file"] {
    display: none;
	}
	</style>
</head>

<form enctype="multipart/form-data" method="post" action="upload.php">
<label for="picture" class="custom-file-upload">
    Välj bild
</label>
<input type="file" capture="camera" accept="image/*" id="picture" name="uploadedfile">
<br /><br />
<input type="submit" value="Ladda upp bild"/>
</form>
</html>