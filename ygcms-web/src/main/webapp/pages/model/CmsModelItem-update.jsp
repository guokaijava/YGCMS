<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="form-horizontal">
	<input type="hidden" id="idID" name="id" /> 
	<input type="hidden" id="versionID" name="version" /> 
	<div class="form-group">
		<label class="col-lg-2 control-label">字段:</label>
		<div class="col-lg-4">
			<input name="field" style="display: inline; width: 94%;"
				class="form-control" type="text" id="fieldID" /><span class="required">*</span>
		</div>
		<label class="col-lg-2 control-label">名称:</label>
		<div class="col-lg-4">
			<input name="itemlabel" style="display: inline; width: 94%;"
				class="form-control" type="text" id="itemlabelID" dataType="Require" /><span class="required">*</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">数据类型:</label>
		<div class="col-lg-4">
			<select name="datatype" style="display: inline; width: 94%;"
				class="form-control" id="datatypeID">
				<option value="1">字符串文本</option>
				<option value="2">整型文本</option>
				<option value="3">浮点型文本</option>
				<option value="4">文本区</option>
				<option value="5">日期</option>
				<option value="6">下拉列表</option>
				<option value="7">复选框</option>
				<option value="8">单选框</option>
				<option value="9">文本编辑区</option>
				<option value="10">单文件上传区</option>
				<option value="11">附件列表</option>
			</select>
		</div>
		<label class="col-lg-2 control-label">排序号:</label>
		<div class="col-lg-4">
			<input name="priority" style="display: inline; width: 94%;"
				class="form-control" type="text" id="priorityID" dataType="Number" /><span class="required">*</span>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">帮助信息:</label>
		<div class="col-lg-4">
			<input name="help" style="display: inline; width: 94%;"
				class="form-control" type="text" id="helpID" />
		</div>
		<label class="col-lg-2 control-label">帮助位置:</label>
		<div class="col-lg-4">
			<select name="helpposition" style="display: inline; width: 94%;"
				class="form-control" id="helppositionID">
				<option value="1">上</option>
				<option value="2">右</option>
				<option value="3">下</option>
				<option value="4">左</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">可选项:</label>
		<div class="col-lg-10">
			<input name="optvalue" style="display: inline; width: 75%;"
				class="form-control" type="text" id="optvalueID" />&nbsp;&nbsp;<small>多个值用“,”分隔</small>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">默认值:</label>
		<div class="col-lg-4">
			<input name="defvalue" style="display: inline; width: 94%;"
				class="form-control" type="text" id="defvalueID" />
		</div>
		<label class="col-lg-2 control-label">宽度:</label>
		<div class="col-lg-4">
			<input name="textsize" style="display: inline; width: 94%;"
				class="form-control" type="Number" id="textsizeID"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">行数:</label>
		<div class="col-lg-4">
			<input name="arearows" style="display: inline; width: 94%;"
				class="form-control" type="Number" id="arearowsID" />
		</div>
		<label class="col-lg-2 control-label">列数:</label>
		<div class="col-lg-4">
			<input name="areacols" style="display: inline; width: 94%;"
				class="form-control" type="Number" id="areacolsID" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">独占一行:</label>
		<div class="col-lg-4" style="padding-top:6px">
			<input name="issingle"  type="radio" id="issingleID1" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="issingle"  type="radio" id="issingleID2" value="0"/>&nbsp;否
		</div>
		<label class="col-lg-2 control-label">是否显示:</label>
		<div class="col-lg-4" style="padding-top:6px">
			<input name="isdisplay"  type="radio" id="isdisplayID1" value="1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="isdisplay"  type="radio" id="isdisplayID2" value="0"/>&nbsp;否
		</div>
	</div>
	<div class="form-group">
		<label class="col-lg-2 control-label">所属选卡:</label>
		<div class="col-lg-4">
			<select name="card" style="display: inline; width: 94%;"
				class="form-control" id="cardID" >
				<option value="1">基本信息</option>
				<option value="2">内容编辑</option>
				<option value="3">图片信息</option>
				<option value="4">附件信息</option>
				<option value="5">高级设置</option>
			</select>
		</div>
		<label class="col-lg-2 control-label" style="padding-left:0">是否自定义:</label>
		<div class="col-lg-4" style="padding-top:6px">
			<input name="iscustom"  type="radio" id="iscustomID1" value="1"/>&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="iscustom"  type="radio" id="iscustomID2" value="0"/>&nbsp;否
		</div>
	</div>
	<input name="modelid" type="hidden" id="modelidID" /> <input
		name="ischannel" type="hidden" id="ischannelID" /> 
	</form>
