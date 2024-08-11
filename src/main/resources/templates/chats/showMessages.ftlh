<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Show Messages</title>
</head>
<#import "../layout.ftlh" as layout>
<@layout.layout>
    <body>
    <div class="chatAbo">
        <h2 class="stringTrackingnumber" id="id">Chat Sendungsnummer: ${chat.id}</h2>
        <button><a href="/emails/subscribe/${chat.id}">Chat abonnieren</a></button>
    </div>
    <div class="chat-container">
        <div id="messages-container"></div>
        <#list messages as message>
            <#if message.sender == "User">
                <div class="sent">
                    <p>${message.text}</p>
                    <span class="timestamp">${message.createdAt}</span>
                </div>
            <#else>
                <div class="received">
                    <p class="sender">${message.text}</p>
                    <span class="timestamp">${message.createdAt}</span>
                </div>
            </#if>
        </#list>
    </div>
    <div class="chatBoxFooter">
        <div class="messageInput">
            <input type="text" name="message" placeholder="Message Here">
            <input type="email" name="userEmail" placeholder="Email">
        </div>
        <button class="message" type="button" onclick="sendMessage()">
            <img src="/images/sendIcon.png" alt="Send" style="width: 25px;">
        </button>
    </div>
    </body>


</@layout.layout>
</html>