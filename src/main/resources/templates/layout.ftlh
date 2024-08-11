<#macro layout>
    <!DOCTYPE html>
    <html lang="de">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Senguel</title>
        <link rel="stylesheet" href="/css/reset.css">
        <link rel="stylesheet" href="/css/base.css">
        <link rel="stylesheet" href="/css/variables.css">
        <link rel="stylesheet" href="/css/components.css">
    </head>

    <body>
    <header>
        <div class="navigation">
            <ul>
                <li><a href="/"><img src="/images/LogoProxyParcelBox.png" alt="Send" style="height: 50px;"></a></li>
                <li><a href="/support">Support</a></li>
                <li><a href="/aboutUs">Über Uns</a></li>
            </ul>
            <ul>
                <li><button><a href="/login">Login</a></button></li>
                <li><button><a href="/register">Registrierung</a></button></li>
            </ul>
        </div>
    </header>

    <main>
        <#nested>
    </main>

    <footer>
        <p>Sengül</p>
    </footer>

    </body>
    <script src="/javascript/sendMessage.js"></script>
    </html>
</#macro>