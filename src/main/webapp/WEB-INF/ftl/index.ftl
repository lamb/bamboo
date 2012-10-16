<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${webTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content="<#list articles as article>${article.articleTitle}<#if article_has_next>,</#if></#list>"/>
</@head>
</head>
<body>
	<#include "header.ftl">
	<#include "content.ftl">
	<#include "footer.ftl">
</body>
</html>