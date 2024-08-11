<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<#import "../layout.ftlh" as layout>
<@layout.layout>
    <body>
    <div class="login">
        <h2>Login</h2>
        <form action="/login" method="post">
            <input type="text" name="name" placeholder="Username">
            <input type="email" name="email" placeholder="Email-Adresse">
            <button type="submit">Login</button>
        </form>
    </div>
    </body>
</@layout.layout>
</html>