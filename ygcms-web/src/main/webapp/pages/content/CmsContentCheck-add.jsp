<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	
	           <div class="form-group">
                    <label class="col-lg-3 control-label">contentId:</label>
	                    <div class="col-lg-9">
                           <input name="contentId" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">checkStep:</label>
	                    <div class="col-lg-9">
                           <input name="checkStep" style="display:inline; width:94%;" class="form-control"  type="text"  id="checkStepID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">checkOpinion:</label>
	                    <div class="col-lg-9">
                           <input name="checkOpinion" style="display:inline; width:94%;" class="form-control"  type="text"  id="checkOpinionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isRejected:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isRejectedID"></div>
	                       <input type="hidden" id="isRejectedID_" name="isRejected" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">reviewer:</label>
	                    <div class="col-lg-9">
                           <input name="reviewer" style="display:inline; width:94%;" class="form-control"  type="text"  id="reviewerID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">checkDate:</label>
	                    <div class="col-lg-9">
                           <input name="checkDate" style="display:inline; width:94%;" class="form-control"  type="text"  id="checkDateID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                    selectItems['isRejectedID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                        </script>
</body>
</html>