<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Details</title>
</head>
<body>
	<form action="input" method="post">
	<pre>
	Item ID: <input type="text" name="id"/>
  Item Name: <input type="text" name="iname"/>
 Item Price: <input type="number" name="iprice"/>
   Quantity: <input type="number" name="iqty"/>
   <input type="submit" value="Add" name="sub"/>
   <input type="submit" value="Make Bill" name="sub"/>
   
	</pre>
	</form>
</body>
</html>