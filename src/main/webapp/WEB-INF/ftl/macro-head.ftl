<#macro head title>
<meta charset="utf-8" />
<title>${title}</title>
<#nested>
<meta name="author" content="B3log Team" />
<meta name="generator" content="B3log" />
<meta name="copyright" content="B3log" />
<meta name="revised" content="B3log, ${year}" />
<meta http-equiv="Window-target" content="_top" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${contextPath}/bootstrap/css/bootstrap.min.css?${staticResourceVersion}" rel="stylesheet"/>
<link href="${contextPath}/bootstrap/css/bootstrap-responsive.css?${staticResourceVersion}" rel="stylesheet"/>
<link href="${contextPath}/css/style.css?${staticResourceVersion}" rel="stylesheet"/>
<link rel="shortcut icon" type="image/png" href="${contextPath}/favicon.ico" />
</#macro>