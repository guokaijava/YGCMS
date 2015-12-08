<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-lg-3 control-label">站点名称:</label>
			<div class="col-lg-9">
				<input name="sitename" style="display: inline; width: 94%;"
					class="form-control" type="text" id="sitenameID" value="" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">简称:</label>
			<div class="col-lg-9">
				<input name="shortname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="shortnameID" value="" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">域名:</label>
			<div class="col-lg-9">
				<input name="domain" style="display: inline; width: 94%;"
					class="form-control" type="text" id="domainID" value="" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">资源路径:</label>
			<div class="col-lg-9">
				<input name="sitepath" style="display: inline; width: 94%;"
					class="form-control" type="text" id="sitepathID" value="" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">附件路径:</label>
			<div class="col-lg-9">
				<select name="ftpuploadid" style="display: inline; width: 94%;"
					class="form-control"  id="ftpuploadidID" >
					<option value="">---选择附件上传路径---</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">开启静态首页:</label>
			<div class="col-lg-9" style="padding-top:5px;">
				<input name="isstaticindex"  type="radio" value="1"/>是&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="isstaticindex"  type="radio" value="0" checked/>否
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">开启回收站:</label>
			<div class="col-lg-9" style="padding-top:5px;">
				<input name="isrecycleon"  type="radio" value="1"/>是&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="isrecycleon"  type="radio" value="0" checked/>否
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">首页模版:</label>
			<div class="col-lg-9">
				<select name="tplsolution" id="tplsolutionID" class="form-control" >
					<option value="">---请选择模版---</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">描述:</label>
			<div class="col-lg-9">
				<input name="description" style="display: inline; width: 94%;"
					class="form-control" type="text" id="descriptionID" value=""/>
			</div>
		</div>
		<input name="configid"  type="hidden" id="configidID" value="1"/> 
        <input name="protocol"  type="hidden" id="protocolID"  value="http://"/>
		<input name="dynamicsuffix" type="hidden" id="dynamicsuffixID"  value=".html"/>
		<input name="staticsuffix" type="hidden" id="staticsuffixID" value=".html"/>
		<input name="staticdir"  type="hidden" id="staticdirID" value=""/>
		<input name="isindextoroot"  type="hidden" id="isindextorootID" value="0"/>
		<input name="localeadmin"  type="hidden" id="localeadminID" value="zh_CN"/>
		<input name="localefront"  type="hidden" id="localefrontID" value="zh_CN"/>
		<input name="tplindex"  type="hidden" id="tplindexID" value=""/>
		<input name="finalstep"  type="hidden" id="finalstepID" value=""/>
		<input name="aftercheck" type="hidden" id="aftercheckID" value=""/>
		<input name="isrelativepath"  type="hidden" id="isrelativepathID" value="0"/>
		<input name="domainAlias"  type="hidden" id="domainAliasID" value=""/>
		<input name="domainredirect"  type="hidden" id="domainredirectID" value=""/>
		<input name="keywords"  type="hidden" id="keywordsID" value=""/>
	</form>
	<script type="text/javascript">
    var selectItems = {};
    </script>                                                                                                                                                                                         
</body>
</html>