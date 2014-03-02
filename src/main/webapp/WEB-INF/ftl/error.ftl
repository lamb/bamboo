<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
${exception?replace("\n","<br/>")}<br/>
<#list exception.stackTrace as trace >
  at ${trace}<br/>
</#list>
<#if exception.cause??>
	Caused by: ${exception.cause?replace("\n","<br/>")}<br/>
	<#list exception.cause.stackTrace as trace >
	  at ${trace}<br/>
	</#list>
</#if>
<#include "js.ftl">
</body>
</html>