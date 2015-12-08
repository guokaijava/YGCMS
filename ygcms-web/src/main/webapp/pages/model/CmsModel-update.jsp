<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	<input type="hidden" id="idID" name="id" /> 
	<input type="hidden" id="versionID" name="version" /> 
	
	  	<div class="form-group">
			<label class="col-lg-3 control-label">模型名称:</label>
			<div class="col-lg-9">
				<input name="modelname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="modelnameID"
					dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">模型路径:</label>
			<div class="col-lg-9">
				<input name="modelpath" style="display: inline; width: 94%;"
					class="form-control" type="text" id="modelpathID"
					dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">栏目模版前缀:</label>
			<div class="col-lg-9">
				<input name="tplchannelprefix" style="display: inline; width: 94%;"
					class="form-control" type="text" id="tplchannelprefixID"
					dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">内容模版前缀:</label>
			<div class="col-lg-9">
				<input name="tplcontentprefix" style="display: inline; width: 94%;"
					class="form-control" type="text" id="tplcontentprefixID"
					dataType="Require" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">栏目标题图:</label>
			<div class="col-lg-9">
				宽&nbsp;&nbsp;<input name="titleimgwidth"
					style="display: inline; width: 42%;" class="form-control"
					type="text" id="titleimgwidthID" dataType="Number" />
				高&nbsp;&nbsp;<input name="titleimgheight"
					style="display: inline; width: 42%;" class="form-control"
					type="text" id="titleimgheightID" dataType="Number" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">栏目内容图:</label>
			<div class="col-lg-9">
				宽&nbsp;&nbsp;<input name="contentimgwidth"
					style="display: inline; width: 42%;" class="form-control"
					type="text" id="contentimgwidthID" dataType="Number" />
				高&nbsp;&nbsp;<input name="contentimgheight"
					style="display: inline; width: 42%;" class="form-control"
					type="text" id="contentimgheightID" dataType="Number" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">排序号:</label>
			<div class="col-lg-9">
				<input name="priority" style="display: inline; width: 94%;"
					class="form-control" type="text" id="priorityID" dataType="Number" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">是否有内容:</label>
			<div class="col-lg-9" style="padding-top:5px;">
				<input name="hascontent" type="radio" value="1" id="hascontentID1"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input
					name="hascontent" type="radio" value="0" id="hascontentID2"/>否
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">是否启用:</label>
			<div class="col-lg-9" style="padding-top:5px;">
				<input name="isdisabled" type="radio" value="1" id="isdisabledID1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
					name="isdisabled" type="radio" value="0" id="isdisabledID2"/>否
			</div>
		</div>

		<input name="isdef" style="display: inline; width: 94%;"
			class="form-control" type="hidden" id="isdefID"/>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                    </script>
</body>
</html>