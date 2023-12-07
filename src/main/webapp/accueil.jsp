<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.User"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<%
	if (session.getAttribute("user") != null)

	{

		User u = (User) session.getAttribute("user");
	%>
	<h3 style="color: white; text-align: right; background-color: green;">
		Bonjour
		<%=u.getNom() + " " + u.getPrenom()%>
		| <a href="login" style="color: orange; padding: 5px">Fermer
			Session</a>
	</h3>

	<%
	} else
	request.getRequestDispatcher("index.jsp").forward(request, response);
	%>

	<h1
		style="text-align: center; vertical-align: middle; margin-top: 300px">Accueil
	</h1>



</body>
</html>