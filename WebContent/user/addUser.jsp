<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>添加管理员</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>
<body>
	<div class="row-fluid" style="margin-top: 200px;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/admin/adminServlet?method=update&updateId=${user.id}" method="post" id="checkForm">
				<div class="form-group">
					<label class="col-md-3 control-label" for="username">用户名</label>
					<div class="col-md-9">
						<input class="form-control" name="username" type="text"
							id="username" placeholder="Username"
							value="${user.username}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="inputPassword">密码</label>
					<div class="col-md-9">
						<input type="password" name="password" class="form-control"
							id="password" placeholder="Password"
							value="${user.password }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="password2">确认密码</label>
					<div class="col-md-9">
						<input type="password" name="password2" class="form-control"
							id="password2" placeholder="conformPassword">
					</div>
				</div>
				<div class="form-group"></div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-primary btn-block">
							提交</button>
					</div>
				</div>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert">修改成功</div>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-danger" role="alert">该用户已存在</div>
				</c:if>
				<c:if test="${param.status.equals('3')}">
					<div class="alert alert-danger" role="alert">成功</div>
				</c:if>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.validate.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/myValidate.js"
		type="text/javascript"></script>
</body>
</html>