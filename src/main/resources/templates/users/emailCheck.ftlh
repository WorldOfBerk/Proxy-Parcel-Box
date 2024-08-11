<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Email Check</title>
</head>
<#import "../layout.ftlh" as layout>
<@layout.layout>
    <body>
    <div class="register">
        <h2>Registrierung</h2>
        <form action="/emailCheck" method="post">
            <input type="text" name="email" placeholder="Email-Adresse">
            <button type="submit">Abschicken</button>
        </form>
    </div>
    </body>
</@layout.layout>
</html>