<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	
	           <div class="form-group">
                    <label class="col-lg-3 control-label">commentUserId:</label>
	                    <div class="col-lg-9">
                           <input name="commentUserId" style="display:inline; width:94%;" class="form-control"  type="text"  id="commentUserIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">replyUserId:</label>
	                    <div class="col-lg-9">
                           <input name="replyUserId" style="display:inline; width:94%;" class="form-control"  type="text"  id="replyUserIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">contentId:</label>
	                    <div class="col-lg-9">
                           <input name="contentId" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">siteId:</label>
	                    <div class="col-lg-9">
                           <input name="siteId" style="display:inline; width:94%;" class="form-control"  type="text"  id="siteIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">createTime:</label>
	                    <div class="col-lg-9">
                           <input name="createTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="createTimeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">replyTime:</label>
	                    <div class="col-lg-9">
                           <input name="replyTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="replyTimeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">ups:</label>
	                    <div class="col-lg-9">
                           <input name="ups" style="display:inline; width:94%;" class="form-control"  type="text"  id="upsID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">downs:</label>
	                    <div class="col-lg-9">
                           <input name="downs" style="display:inline; width:94%;" class="form-control"  type="text"  id="downsID" />
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
                    <label class="col-lg-3 control-label">isChecked:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isCheckedID"></div>
	                       <input type="hidden" id="isCheckedID_" name="isChecked" />
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
                                                                            selectItems['isRecommendID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                selectItems['isCheckedID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                </script>
</body>
</html>