<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Delete/Change Users</title>
<link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action = "ADC_Users_Servlet">
<table class = "table w3-table-all">
<tr>
Add/Delete/Change Users
</tr>
<tr>
<td>ID</td>
<td>Login</td>
<td>Name</td>
</tr>
<tr class="w3-light-grey w3-hover-red">
<td><input type = "text" name="ADDID"></td>
<td><input type = "text" name="ADDLogin"></td>
<td><input type = "text" name="ADDName"></td>
<td><input type = "submit" value = "ADD" name="ADDButton"></td>
</tr>
<tr class="w3-light-grey w3-hover-red"></tr>
<tr class="w3-light-grey w3-hover-red">
<td>ID</td>
</tr>
<tr class="w3-light-grey w3-hover-red">
<td><input type = "text" name="DELETEID"></td>
<td><input type = "submit" value = "DELETE" name="DELETEButton"></td>
</tr>
<tr class="w3-light-grey w3-hover-red"></tr>
<tr>
<td>ID</td>
<td>Name</td>
<td>Description</td>
<td>Users</td>
</tr>
<tr class="w3-light-grey w3-hover-red">
<td><input type = "text" name="CHANGEID"></td>
<td><input type = "text" name="CHANGEName"></td>
<td><input type = "text" name="CHANGEDescription"></td>
<td><input type = "text" name="CHANGEUsers"></td>
<td><input type = "submit" value = "CHANGE" name="CHANGEButton"></td>
</tr>
</table>
</form>
</body>
</html>