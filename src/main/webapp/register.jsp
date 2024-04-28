<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form>
    <!-- Text Input -->
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" required><br>

    <!-- Password Input -->
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required minlength="8"><br>

    <!-- Email Input -->
    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br>

    <!-- Date Input -->
    <label for="birthdate">Birthdate:</label><br>
    <input type="date" id="birthdate" name="birthdate" required><br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>
</body>
</html>
