<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<div class="department-detail" id="departmentDetail">
    <div>
    <div style="margin:8px 8px 4px">站点选择：<select id="sitelist" class="form-control" style="display:inline-block;width:215px;"></select></div>
	<ul class="u-tree tree" id="channelTree"
		oncontextmenu="return false" style="width: 28%"></ul>
    </div>
	<div class="right-content" style="width: 70%;padding-top:5px;padding-right:0px;height:540px">
	    <div class="dropdown" style="margin:3px 0 7px">
  			<button id="dLabel" type="button" class="btn btn-success"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    			<span class="glyphicon glyphicon-plus"></span> 添加子栏目
    			<span class="caret"></span>
  			</button>
  			<ul class="dropdown-menu" aria-labelledby="dLabel" id="createmenu">
  			</ul>
		</div>
		<div id="channelgrid" style="hight:540px">
			
		</div>
	</div>
	<div style="clear: both;"></div>
</div>
<script type="text/javascript"
	src="<c:url value='/js/cms/channel.js' />"></script>
<script type="text/javascript">
$(function(){
	 channelManager().getTree();
	 channelManager().initoperate();
});
</script>