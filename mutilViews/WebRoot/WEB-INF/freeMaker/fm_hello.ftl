<html>
    <head>
       <title>FreeMarker</title>
    </head>
    <body>
    <#list articles as article>
    	title:${article.title }<br>
  	content:${article.content }<br>
    </#list>
    </body>
</html>