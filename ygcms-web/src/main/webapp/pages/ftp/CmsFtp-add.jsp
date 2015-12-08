<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form class="form-horizontal">

		<div class="form-group">
			<label class="col-lg-3 control-label">名称:</label>
			<div class="col-lg-9">
				<input name="ftpname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="ftpnameID" dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">服务器地址:</label>
			<div class="col-lg-9">
				<input name="ip" style="display: inline; width: 94%;"
					class="form-control" type="text" id="ipID" dataType="IPAddr" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">端口:</label>
			<div class="col-lg-9">
				<input name="port" style="display: inline; width: 94%;"
					class="form-control" type="text" id="portID" dataType="Number" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">登陆名:</label>
			<div class="col-lg-9">
				<input name="username" style="display: inline; width: 94%;"
					class="form-control" type="text" id="usernameID" dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">密码:</label>
			<div class="col-lg-9">
				<input name="password" style="display: inline; width: 94%;"
					class="form-control" type="password" id="passwordID"
					dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">编码:</label>
			<div class="col-lg-9">
				<input name="encoding" style="display: inline; width: 94%;"
					class="form-control" type="text" id="encodingID" dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">超时时间:</label>
			<div class="col-lg-9">
				<input name="timeout" style="display: inline; width: 75%;"
					class="form-control" type="text" id="timeoutID" dataType="Number" />(单位：秒)
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">目录:</label>
			<div class="col-lg-9">
				<input name="ftppath" style="display: inline; width: 75%;"
					class="form-control" type="text" id="ftppathID" />(留空为根目录)
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">访问地址:</label>
			<div class="col-lg-9">
				<input name="url" style="display: inline; width: 75%;"
					class="form-control" type="text" id="urlID" dataType="Require" />(访问FTP的url地址)
			</div>
		</div>
	</form>
	<script type="text/javascript">
    var selectItems = {};
                                                                            </script>
</body>
</html>