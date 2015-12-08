<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form class="form-horizontal">

		<div class="form-group">
			<label class="col-lg-2 control-label">文件名称:</label>
			<div class="col-lg-10">
				<input name="fname" style="display: inline; width: 67%;"
					class="form-control" type="text" id="fname"
					dataType="Require" />&nbsp;<select id='zhui' style="display: inline; width: 10%;" class="form-control">
						<option value=".html">.html</option>
						<option value=".htm">.htm</option>
						<option value=".css">.css</option>
						<option value=".js">.js</option>
					</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-2 control-label">文件内容:</label>
			<div class="col-lg-10">
				<textarea name="content" id="content"  wrap="off"  rows="20" style="display: inline; width: 90%;" class="form-control" ></textarea> 
			</div>
		</div>
	</form>
</body>
</html>