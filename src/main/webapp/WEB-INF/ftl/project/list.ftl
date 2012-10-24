<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<body>
<table class="table table-hover">
  <thead>
	<tr>
	  <th>#</th>
	  <th>项目名称</th>
	  <th>英文缩写</th>
	</tr>
  </thead>
  <tbody>
  	<#list projects as project>
		<tr>
		  <td>${project.id}</td>
		  <td>${project.name}</td>
		  <td>${project.abbr}</td>
		</tr>
	</#list>
  </tbody>
</table>
	<#include "footer.ftl">
</body>
</html>