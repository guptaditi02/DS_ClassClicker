<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clicker App - Submission</title>
</head>
<body><h1>Distributed Systems Class Clicker</h1>
<p>Your <%=request.getParameter("option")%> has been registered</p>
<p>Submit your answer to the current question:</p>
<form action="submit" method="GET">
    <input type="radio" name="option" value="A" required>A<br>
    <input type="radio" name="option" value="B" required>B<br>
    <input type="radio" name="option" value="C" required>C<br>
    <input type="radio" name="option" value="D" required>D<br>
    <input type="submit" value="Submit">
</form>
<p><a href="index.jsp"></a></p>
<p><a href="result.jsp">View Results</a></p>
</body>
</html>
