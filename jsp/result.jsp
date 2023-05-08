<%@page import="model.MusicBean"%>
<%@page import="model.ResultContent" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<%
ResultContent content = (ResultContent)request.getAttribute("content");
%>
<p><%=content.getPage() %>
<%
for(MusicBean musicBean : content.getViewMusicBeans()){
%>
	<p><%=musicBean.toString() %>
<%
}
%>
<form action="<%=request.getContextPath()%>/page" method="post">
	<input type="hidden" name="content" value="<%=util.Serializer.toString(content)%>">
	<button type="submit" name="trans" value="prev">前へ</button>
	<button type="submit" name="trans" value="next">次へ</button>
</form>
</body>
</html>