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
                    <label class="col-lg-3 control-label">contentId:</label>
	                    <div class="col-lg-9">
                           <input name="contentId" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">title:</label>
	                    <div class="col-lg-9">
                           <input name="title" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">shortTitle:</label>
	                    <div class="col-lg-9">
                           <input name="shortTitle" style="display:inline; width:94%;" class="form-control"  type="text"  id="shortTitleID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">author:</label>
	                    <div class="col-lg-9">
                           <input name="author" style="display:inline; width:94%;" class="form-control"  type="text"  id="authorID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">origin:</label>
	                    <div class="col-lg-9">
                           <input name="origin" style="display:inline; width:94%;" class="form-control"  type="text"  id="originID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">originUrl:</label>
	                    <div class="col-lg-9">
                           <input name="originUrl" style="display:inline; width:94%;" class="form-control"  type="text"  id="originUrlID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">description:</label>
	                    <div class="col-lg-9">
                           <input name="description" style="display:inline; width:94%;" class="form-control"  type="text"  id="descriptionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">releaseDate:</label>
	                    <div class="col-lg-9">
                           <input name="releaseDate" style="display:inline; width:94%;" class="form-control"  type="text"  id="releaseDateID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">mediaPath:</label>
	                    <div class="col-lg-9">
                           <input name="mediaPath" style="display:inline; width:94%;" class="form-control"  type="text"  id="mediaPathID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">mediaType:</label>
	                    <div class="col-lg-9">
                           <input name="mediaType" style="display:inline; width:94%;" class="form-control"  type="text"  id="mediaTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">titleColor:</label>
	                    <div class="col-lg-9">
                           <input name="titleColor" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleColorID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isBold:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isBoldID"></div>
	                       <input type="hidden" id="isBoldID_" name="isBold" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">titleImg:</label>
	                    <div class="col-lg-9">
                           <input name="titleImg" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleImgID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">contentImg:</label>
	                    <div class="col-lg-9">
                           <input name="contentImg" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentImgID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">typeImg:</label>
	                    <div class="col-lg-9">
                           <input name="typeImg" style="display:inline; width:94%;" class="form-control"  type="text"  id="typeImgID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">link:</label>
	                    <div class="col-lg-9">
                           <input name="link" style="display:inline; width:94%;" class="form-control"  type="text"  id="linkID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">tplContent:</label>
	                    <div class="col-lg-9">
                           <input name="tplContent" style="display:inline; width:94%;" class="form-control"  type="text"  id="tplContentID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">needRegenerate:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="needRegenerateID"></div>
	                       <input type="hidden" id="needRegenerateID_" name="needRegenerate" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                    selectItems['isBoldID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                                                        selectItems['needRegenerateID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
        </script>
</body>
</html>