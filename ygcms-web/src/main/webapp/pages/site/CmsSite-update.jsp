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
			<label class="col-lg-3 control-label">站点名称:</label>
			<div class="col-lg-9">
				<input name="sitename" style="display: inline; width: 94%;"
					class="form-control" type="text" id="sitenameID"  dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">简称:</label>
			<div class="col-lg-9">
				<input name="shortname" style="display: inline; width: 94%;"
					class="form-control" type="text" id="shortnameID" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">域名:</label>
			<div class="col-lg-9">
				<input name="domain" style="display: inline; width: 94%;"
					class="form-control" type="text" id="domainID" dataType="require"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">资源路径:</label>
			<div class="col-lg-9">
				<input name="sitepath" style="display: inline; width: 94%;"
					class="form-control" type="text" id="sitepathID" dataType="require"/>
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
				<input name="isstaticindex"  type="radio" value="1" id="isstaticindexID1"/>是&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="isstaticindex"  type="radio" value="0" id="isstaticindexID2"/>否&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">开启回收站:</label>
			<div class="col-lg-9" style="padding-top:5px;">
				<input name="isrecycleon"  type="radio" value="1" id="isrecycleonID1"/>是&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="isrecycleon"  type="radio" value="0" id="isrecycleonID2"/>否&nbsp;&nbsp;&nbsp;&nbsp;
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
					class="form-control" type="text" id="descriptionID" />
			</div>
		</div>
		<input name="configid"  type="hidden" id="configidID"/> 
        <input name="protocol"  type="hidden" id="protocolID" />
		<input name="dynamicsuffix" type="hidden" id="dynamicsuffixID" />
		<input name="staticsuffix" type="hidden" id="staticsuffixID" />
		<input name="staticdir"  type="hidden" id="staticdirID" />
		<input name="isindextoroot"  type="hidden" id="isindextorootID" />
		<input name="localeadmin"  type="hidden" id="localeadminID" />
		<input name="localefront"  type="hidden" id="localefrontID" />
		<input name="tplindex"  type="hidden" id="tplindexID" />
		<input name="finalstep"  type="hidden" id="finalstepID" />
		<input name="aftercheck" type="hidden" id="aftercheckID" />
		<input name="isrelativepath"  type="hidden" id="isrelativepathID" />
		<input name="domainAlias"  type="hidden" id="domainAliasID" />
		<input name="domainredirect"  type="hidden" id="domainredirectID" />
		<input name="keywords"  type="hidden" id="keywordsID" />
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                                                                                    </script>
</body>
</html>