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
                    <label class="col-lg-3 control-label">channelId:</label>
	                    <div class="col-lg-9">
                           <input name="channelId" style="display:inline; width:94%;" class="form-control"  type="text"  id="channelIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">channelName:</label>
	                    <div class="col-lg-9">
                           <input name="channelName" style="display:inline; width:94%;" class="form-control"  type="text"  id="channelNameID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">finalStep:</label>
	                    <div class="col-lg-9">
                           <input name="finalStep" style="display:inline; width:94%;" class="form-control"  type="text"  id="finalStepID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">afterCheck:</label>
	                    <div class="col-lg-9">
                           <input name="afterCheck" style="display:inline; width:94%;" class="form-control"  type="text"  id="afterCheckID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isStaticChannel:</label>
	                    <div class="col-lg-9">
                           <input name="isStaticChannel" style="display:inline; width:94%;" class="form-control"  type="text"  id="isStaticChannelID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isStaticContent:</label>
	                    <div class="col-lg-9">
                           <input name="isStaticContent" style="display:inline; width:94%;" class="form-control"  type="text"  id="isStaticContentID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isAccessByDir:</label>
	                    <div class="col-lg-9">
                           <input name="isAccessByDir" style="display:inline; width:94%;" class="form-control"  type="text"  id="isAccessByDirID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isListChild:</label>
	                    <div class="col-lg-9">
                           <input name="isListChild" style="display:inline; width:94%;" class="form-control"  type="text"  id="isListChildID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">pageSize:</label>
	                    <div class="col-lg-9">
                           <input name="pageSize" style="display:inline; width:94%;" class="form-control"  type="text"  id="pageSizeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">channelRule:</label>
	                    <div class="col-lg-9">
                           <input name="channelRule" style="display:inline; width:94%;" class="form-control"  type="text"  id="channelRuleID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">contentRule:</label>
	                    <div class="col-lg-9">
                           <input name="contentRule" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentRuleID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">link:</label>
	                    <div class="col-lg-9">
                           <input name="link" style="display:inline; width:94%;" class="form-control"  type="text"  id="linkID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">tplChannel:</label>
	                    <div class="col-lg-9">
                           <input name="tplChannel" style="display:inline; width:94%;" class="form-control"  type="text"  id="tplChannelID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">tplContent:</label>
	                    <div class="col-lg-9">
                           <input name="tplContent" style="display:inline; width:94%;" class="form-control"  type="text"  id="tplContentID" />
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
                    <label class="col-lg-3 control-label">hasTitleImg:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="hasTitleImgID"></div>
	                       <input type="hidden" id="hasTitleImgID_" name="hasTitleImg" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">hasContentImg:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="hasContentImgID"></div>
	                       <input type="hidden" id="hasContentImgID_" name="hasContentImg" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">titleImgWidth:</label>
	                    <div class="col-lg-9">
                           <input name="titleImgWidth" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleImgWidthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">titleImgHeight:</label>
	                    <div class="col-lg-9">
                           <input name="titleImgHeight" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleImgHeightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">contentImgWidth:</label>
	                    <div class="col-lg-9">
                           <input name="contentImgWidth" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentImgWidthID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">contentImgHeight:</label>
	                    <div class="col-lg-9">
                           <input name="contentImgHeight" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentImgHeightID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">commentControl:</label>
	                    <div class="col-lg-9">
                           <input name="commentControl" style="display:inline; width:94%;" class="form-control"  type="text"  id="commentControlID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">allowUpdown:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="allowUpdownID"></div>
	                       <input type="hidden" id="allowUpdownID_" name="allowUpdown" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isBlank:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isBlankID"></div>
	                       <input type="hidden" id="isBlankID_" name="isBlank" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">title:</label>
	                    <div class="col-lg-9">
                           <input name="title" style="display:inline; width:94%;" class="form-control"  type="text"  id="titleID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">keywords:</label>
	                    <div class="col-lg-9">
                           <input name="keywords" style="display:inline; width:94%;" class="form-control"  type="text"  id="keywordsID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">description:</label>
	                    <div class="col-lg-9">
                           <input name="description" style="display:inline; width:94%;" class="form-control"  type="text"  id="descriptionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">allowShare:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="allowShareID"></div>
	                       <input type="hidden" id="allowShareID_" name="allowShare" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">allowScore:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="allowScoreID"></div>
	                       <input type="hidden" id="allowScoreID_" name="allowScore" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                            selectItems['hasTitleImgID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                selectItems['hasContentImgID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                                                        selectItems['allowUpdownID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                selectItems['isBlankID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                                        selectItems['allowShareID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                selectItems['allowScoreID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
        </script>
</body>
</html>