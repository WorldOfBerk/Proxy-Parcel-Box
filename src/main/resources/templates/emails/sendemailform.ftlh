<#import "../layout.ftlh" as base>
<@base.layout>
    <form action="/emails" method="post">
        <label for="receiver">Receiver</label><br>
        <input type="email" name="receiver" id="receiver"><br>
        <label for="subject">Subject</label><br>
        <input type="text" name="subject" id="subject"><br>
        <label for="message">Message</label><br>
        <textarea name="message" id="message" cols="30" rows="10">
        </textarea><br>
        <input type="submit" value="Send">
    </form>
</@base.layout>