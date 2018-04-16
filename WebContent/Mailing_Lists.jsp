<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DB</title>
<link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<table class = "table w3-table-all"><tr class="w3-light-grey w3-hover-red"><td>
<form action = "Servlet">
Press this button to open the mailing list database.</td><td>
<input type = "submit" value = "ShowMailingListsDB">
</form></td></tr>
<tr class="w3-light-grey w3-hover-red"><td>
<form action = "UsersServlet">
Press this button to open user database.</td><td>
<Input type="submit" value="ShowUsersDB">
</form></td></tr>
<tr class="w3-light-grey w3-hover-red"><td>
<form action = "ADC_List_Servlet">
Press this button to add/delete/change mailing list.</td><td>
<input type = "submit" value = "AddDeleteChangeMailingLists">
</form></td></tr>
<tr class="w3-light-grey w3-hover-red"><td>
<form action = "ADC_Users_Servlet">
Press this button to add/delete/change users.</td><td>
<input type = "submit" value = "AddDeleteChangeUsers">
</form></td></tr>
<tr class="w3-light-grey w3-hover-red"><td>
<form action = "CandidatesServlet">
Press this button to get candidate lists for removal.</td><td>
<input type = "submit" value = "Candidates">
</form></td></tr>
<tr class="w3-light-grey w3-hover-red"><td>
<form action = "SubscribersServlet">
Press this button to check list's subscribes</td><td>
<input type = "submit" value = "Subscribes">
</form></td></tr>
</table>
</body>
</html>