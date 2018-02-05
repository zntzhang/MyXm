<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<title>登录</title>
<link rel="stylesheet" href="../stylesheets/bootstrap.min.css">
</head>
<body>
	<form action="/MyXm/user/index.do" method="post" role="form">
		<div style="text-align: center;">
		<div class="form-group">
			<label for="name"> 用户账号:</label> <input type="text" name="user_name"
				class="form-control" placeholder="请输入名称" />
		</div>
		<div class="form-group">
			<label for="name"> 用户密码: </label><input type="password"
				class="form-control" name="password" placeholder="请输入密码" />
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
		</div>
	</form>
</body>
</html>
