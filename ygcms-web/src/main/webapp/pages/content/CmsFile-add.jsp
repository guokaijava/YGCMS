<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="form-horizontal">
	<div class="form-group">
		<label class="col-lg-2 control-label">文件名称:</label>
		<div class="col-lg-10">
			<input name="fname" style="display: inline; width: 90%;"
				class="form-control" type="text" id="fname" dataType="Require" />&nbsp;<span
				id='zhui'>.html</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">文件内容:</label>
		<div class="col-lg-10">
			<textarea name="content" id="content" wrap="off" rows="20"
				style="display: inline; width: 90%;resize:none" class="form-control"></textarea>
		</div>
	</div>
</form>
