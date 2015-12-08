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
                    <label class="col-lg-3 control-label">configId:</label>
	                    <div class="col-lg-9">
                           <input name="configId" style="display:inline; width:94%;" class="form-control"  type="text"  id="configIdID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">field:</label>
	                    <div class="col-lg-9">
                           <input name="field" style="display:inline; width:94%;" class="form-control"  type="text"  id="fieldID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">itemLabel:</label>
	                    <div class="col-lg-9">
                           <input name="itemLabel" style="display:inline; width:94%;" class="form-control"  type="text"  id="itemLabelID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">priority:</label>
	                    <div class="col-lg-9">
                           <input name="priority" style="display:inline; width:94%;" class="form-control"  type="text"  id="priorityID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">defValue:</label>
	                    <div class="col-lg-9">
                           <input name="defValue" style="display:inline; width:94%;" class="form-control"  type="text"  id="defValueID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">optValue:</label>
	                    <div class="col-lg-9">
                           <input name="optValue" style="display:inline; width:94%;" class="form-control"  type="text"  id="optValueID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">textSize:</label>
	                    <div class="col-lg-9">
                           <input name="textSize" style="display:inline; width:94%;" class="form-control"  type="text"  id="textSizeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">areaRows:</label>
	                    <div class="col-lg-9">
                           <input name="areaRows" style="display:inline; width:94%;" class="form-control"  type="text"  id="areaRowsID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">areaCols:</label>
	                    <div class="col-lg-9">
                           <input name="areaCols" style="display:inline; width:94%;" class="form-control"  type="text"  id="areaColsID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">help:</label>
	                    <div class="col-lg-9">
                           <input name="help" style="display:inline; width:94%;" class="form-control"  type="text"  id="helpID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">helpPosition:</label>
	                    <div class="col-lg-9">
                           <input name="helpPosition" style="display:inline; width:94%;" class="form-control"  type="text"  id="helpPositionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">dataType:</label>
	                    <div class="col-lg-9">
                           <input name="dataType" style="display:inline; width:94%;" class="form-control"  type="text"  id="dataTypeID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">isRequired:</label>
	                    <div class="col-lg-9">
                           <div class="btn-group select" id="isRequiredID"></div>
	                       <input type="hidden" id="isRequiredID_" name="isRequired" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">category:</label>
	                    <div class="col-lg-9">
                           <input name="category" style="display:inline; width:94%;" class="form-control"  type="text"  id="categoryID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                            selectItems['isRequiredID'] = [
                   {title: '请选择', value: ''},
                   {title: '是', value: 'true'},
                   {title: '否', value: 'false'}
                ];
                </script>
</body>
</html>