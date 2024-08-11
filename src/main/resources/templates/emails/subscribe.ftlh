<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chat abonnieren</title>
</head>
<#import "../layout.ftlh" as layout>
<@layout.layout>
    <body>
        <h2>Chat abonnieren: ${chat.id}</h2>
        <form action="/emails/subscribe/${chat.id}" method="post">
            <input type="email" name="receiver" placeholder="Email-Adresse">
            <button type="submit">Abonnieren</button>
        </form>
    </body>
</@layout.layout>
</html>