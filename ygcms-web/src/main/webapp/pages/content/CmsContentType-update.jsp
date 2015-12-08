<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form class="form-horizontal">
		<input type="hidden" id="idID" name="id" /> <input type="hidden"
			id="versionID" name="version" />

		<div class="form-group">
			<label class="col-lg-3 control-label">名称:</label>
			<div class="col-lg-9">
				<input name="typename" style="display: inline; width: 94%;"
					class="form-control" type="text" id="typenameID" dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">有图片:</label>
			<div class="col-lg-9" style="padding-top: 6px;">
				<input name="hasimage" type="radio" value="1" id="hasimageID1" />&nbsp;是&nbsp;&nbsp;&nbsp;
				<input name="hasimage" type="radio" value="0" id="hasimageID2"  />&nbsp;否
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">禁用:</label>
			<div class="col-lg-9" style="padding-top: 6px;">
				<input name="isdisabled" type="radio" value="1" id="isdisabledID1" />&nbsp;是&nbsp;&nbsp;&nbsp;
				<input name="isdisabled" type="radio" value="0" id="isdisabledID2"/>&nbsp;否
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">图片宽度:</label>
			<div class="col-lg-9">
				<input name="imgwidth" style="display: inline; width: 94%;"
					class="form-control" type="text" id="imgwidthID" value="0" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">图片高度:</label>
			<div class="col-lg-9">
				<input name="imgheight" style="display: inline; width: 94%;"
					class="form-control" type="text" id="imgheightID" value="0" />
			</div>
		</div>

	</form>
	<script type="text/javascript">
		var selectItems = {};
	</script>
</body>
</html>