<%@ page import="com.example.project1task2.ClickerServlet" %>
<%@ page import="com.example.project1task2.ClickerModel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Radio Buttons with Map</title>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>

<form action="submit" method="GET">
    <%!
        ClickerModel clickerModel = new ClickerModel();
    %><%
        java.util.Map<String, Integer> optionsMap = clickerModel.optionMap;

        if (optionsMap == null || optionsMap.isEmpty()) {
    %>
    <p>There are currently no results</p>
    <%
    } else {
        for (java.util.Map.Entry<String, Integer> entry : optionsMap.entrySet()) {
    %>
    <input type="radio" name="option" value="<%= entry.getKey() %>"><%= entry.getKey() %> - <%= entry.getValue() %><br>
    <%
            }
        }
    %>
</form>
<!-- Button to refresh the map and go to a new question -->
<form action="index.jsp" method="GET">
    <input type="submit" value="New question">
    <%
        optionsMap.clear();
    %>
</form>
</body>
</html>
