<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	
	           <div class="form-group">
                    <label class="col-lg-3 control-label">channelId:</label>
	                    <div class="col-lg-9">
                           <input name="channelId" style="display:inline; width:94%;" class="form-control"  type="text"  id="channelIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">userId:</label>
	                    <div class="col-lg-9">
                           <input name="userId" style="display:inline; width:94%;" class="form-control"  type="text"  id="userIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">typeId:</label>
	                    <div class="col-lg-9">
                           <input name="typeId" style="display:inline; width:94%;" class="form-control"  type="text"  id="typeIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">modelId:</label>
	                    <div class="col-lg-9">
                           <input name="modelId" style="display:inline; width:94%;" class="form-control"  type="text"  id="modelIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">siteId:</label>
	                    <div class="col-lg-9">
                           <input name="siteId" style="display:inline; width:94%;" class="form-control"  type="text"  id="siteIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">sortDate:</label>
	                    <div class="col-lg-9">
                           <input name="sortDate" style="display:inline; width:94%;" class="form-control"  type="text"  id="sortDateID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">topLevel:</label>
	                    <div class="col-lg-9">
                           <input name="topLevel" style="display:inline; width:94%;" class="form-control"  type="text"  id="topLevelID" />
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
                    <label class="col-lg-3 control-label">isRecommend:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isRecommendID"></div>
	                       <input type="hidden" id="isRecommendID_" name="isRecommend" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">status:</label>
	                    <div class="col-lg-9">
                           <input name="status" style="display:inline; width:94%;" class="form-control"  type="text"  id="statusID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">viewsDay:</label>
	                    <div class="col-lg-9">
                           <input name="viewsDay" style="display:inline; width:94%;" class="form-control"  type="text"  id="viewsDayID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">commentsDay:</label>
	                    <div class="col-lg-9">
                           <input name="commentsDay" style="display:inline; width:94%;" class="form-control"  type="text"  id="commentsDayID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">downloadsDay:</label>
	                    <div class="col-lg-9">
                           <input name="downloadsDay" style="display:inline; width:94%;" class="form-control"  type="text"  id="downloadsDayID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">upsDay:</label>
	                    <div class="col-lg-9">
                           <input name="upsDay" style="display:inline; width:94%;" class="form-control"  type="text"  id="upsDayID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">score:</label>
	                    <div class="col-lg-9">
                           <input name="score" style="display:inline; width:94%;" class="form-control"  type="text"  id="scoreID" />
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
                selectItems['isRecommendID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                                                        </script>
</body>
</html>