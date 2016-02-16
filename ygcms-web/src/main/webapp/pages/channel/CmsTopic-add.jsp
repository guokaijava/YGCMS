<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/lib/ajaxfileupload.js"></script>
</head>
<body>
	<form class="form-horizontal">

		<div class="form-group">
			<label class="col-lg-3 control-label">专题名称:</label>
			<div class="col-lg-9">
				<input name="topicname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="topicnameID" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">简称:</label>
			<div class="col-lg-9">
				<input name="shortname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="shortnameID" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">关键字:</label>
			<div class="col-lg-9">
				<input name="keywords" style="display: inline; width: 94%;"
					class="form-control" type="text" id="keywordsID" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">描述:</label>
			<div class="col-lg-9">
				<input name="description" style="display: inline; width: 94%;"
					class="form-control" type="text" id="descriptionID" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">标题图:</label>
			<div class="col-lg-9">
					<div class="fileinput">
						<button class="btn btn-success"><i class="glyphicon glyphicon-picture"></i>&nbsp;选择文件</button>
						<input type='file' id='titleimg_file' name="myfiles"/>
						<input type="hidden" name='titleimg' id='contentimgID'/>
						<img id='titleimg_view' alt='请上传内容图' src=''/>
					</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">内容图:</label>
			<div class="col-lg-9">
					<div class="fileinput">
						<button class="btn btn-success"><i class="glyphicon glyphicon-picture"></i>&nbsp;选择文件</button>
						<input type='file' id='contentimg_file' name="myfiles"/>
						<input type="hidden" name='contentimg' id='contentimgID'/>
						<img id='contentimg_view' alt='请上传内容图' src=''/>
					</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">优先级:</label>
			<div class="col-lg-9">
				<input name="priority" style="display: inline; width: 94%;"
					class="form-control" type="text" id="priorityID" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">是否推荐:</label>
			<div class="col-lg-9" style="padding-top:6px">
				<input type="radio" name="isrecommend" id="isrecommendID1" value="0" checked/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="isrecommend" id="isrecommendID2" value="1"/>&nbsp;否
			</div>
		</div>
		<input name="channelid" style="display: inline; width: 94%;"
			class="form-control" type="hidden" id="channelidID" />
			<input name="tplcontent" style="display: inline; width: 94%;"
					class="form-control" type="hidden" id="tplcontentID" />
	</form>
	<script type="text/javascript">
    var selectItems = {};
                                                                                    </script>
</body>
</html>