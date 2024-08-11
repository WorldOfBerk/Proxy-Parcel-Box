<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Show Chats</title>
</head>
<#import "../layout.ftlh" as layout>
<@layout.layout>
    <body>
    <div class="qrInfo">
        <h3>Link to Chat:</h3>
        <p>Sendungsnummer: ${chat.trackingnumber}</p>
        <p>Email: ${chat.email}</p>
        <a href="http://localhost:8080/chats/${chat.id}">
            <img src="https://api.qrserver.com/v1/create-qr-code/?size=150x150&data={localhost:8080/chats/${chat.id}"
                class="qrImg" alt="QR Code" width="200" height="200">
        </a>
        <p>Local Connect:</p>
        <a href="http://localhost:8080/messages/${chat.id}">http://localhost:8080/messages/${chat.id}</a>
    </div>
    </body>
</@layout.layout>
</html>