<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Delete/Change Mailing List</title>
<link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action = "ADC_List_Servlet">
<table class = "table w3-table-all">
<tr class="w3-light-grey w3-hover-red">
Add/Delete/Change Mailing Lists
</tr>
<tr class="w3-light-grey w3-hover-red">
<td>ID</td>
<td>Name</td>
<td>Description</td>
<td>Users</td>
</tr>
<tr class="w3-light-grey w3-hover-red">
<td><input type = "text" name="ADDID"></td>
<td><input type = "text" name="ADDName"></td>
<td><input type = "text" name="ADDDescription"></td>
<td><input type = "text" name="ADDUsers"></td>
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
<tr></tr>
<tr class="w3-light-grey w3-hover-red">
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