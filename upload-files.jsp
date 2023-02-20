<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Files</title>
</head>
<body>
    <form action="./FilesUpload" method="post" enctype="multipart/form-data">
    <input type="text" placeholder="Comman Name" name="com_name" required />
    <input type="text" placeholder="Scientific Name" name="sci_name" required />
    <input type="text" placeholder="Family" name="family" reuired />
    <input type="file" placeholder="Upload Image" accept="image/*" name="img_file" />
    <input type="file" accept=".pdf" required name="pdf_file" />
    <input type="submit" value="submit" />
    </form>
</body>
</html>