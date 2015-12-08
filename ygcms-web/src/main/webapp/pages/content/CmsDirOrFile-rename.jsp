<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-lg-3 control-label">原名称:</label>
			<div class="col-lg-9">
				<input name="oname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="snameID"
					readonly />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">新名称:</label>
			<div class="col-lg-9">
				<input name="nname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="nnameID"
					dataType="Require" />
			</div>
		</div>
	</form>
</body>
</html>