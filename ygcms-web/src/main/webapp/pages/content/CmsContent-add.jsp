<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="/lib/ajaxfileupload.js"></script>
<style type="text/css">
input[type="radio"], input[type="checkbox"] {
	vertical-align: top;
}
</style>
<form class="form-horizontal" style="min-height: 560px; height: 560px"
	method="post" enctype="multipart/form-data">
	<ul class="nav nav-tabs" id="myTab">
		<li class="active" id="li_base"><a data-toggle="tab"
			href="#tab_base">基本信息</a></li>
		<li class="" id="li_content"><a data-toggle="tab"
			href="#tab_content">内容编辑<i class="icon-remove tab-close"></i></a></li>
		<li class="" id="li_image"><a data-toggle="tab" href="#tab_image">图片信息<i
				class="icon-remove tab-close"></i></a></li>
		<li class="" id="li_file" style="display: none;"><a
			data-toggle="tab" href="#tab_file">附件信息<i
				class="icon-remove tab-close"></i></a></li>
		<li class="" id="li_permiss"><a data-toggle="tab"
			href="#tab_permiss">高级设置<i class="icon-remove tab-close"></i></a></li>
	</ul>
	<div class="tab-content" id="myTabContent"
		style="padding-top: 20px; height: 540px; overflow-y: hidden; overflow-x: hidden">
		<div id="tab_base" class="tab-pane fade active in"></div>
		<div id="tab_content" class="tab-pane fade">
			<iframe src="../thirdparty/ueditor/index.html" id="txteditor"
				scrolling="no" frameborder="0"
				style="width: 100%; height: 500px; display: none"></iframe>
		</div>
		<div id="tab_image" class="tab-pane fade"></div>
		<div id="tab_file" class="tab-pane fade">
			<div class="form-group">
				<label class="col-lg-3 control-label">标题：</label>
				<div class="col-lg-6">
					<input name="fileTitle" id="file_title"
						style="display: inline; width: 94%;" class="form-control"
						type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">描述：</label>
				<div class="col-lg-6">
					<input name="fileDescription" id="file_desc"
						style="display: inline; width: 94%;" class="form-control"
						type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">附件：</label>
				<div class="col-lg-6">
					<input name="ufile" id="ufile" style="display: inline; width: 94%;"
						class="form-control" type="file" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-11" style="text-align: center">
					<input type="button" id="uploadfile" value="上传"
						class="btn btn-info" />
				</div>
			</div>
			<div class="grid-body" style="width: 100%;border: 1px solid #ddd">
				<div class="grid-table-head" style="width: 100%;">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th class="col-lg-3">附件名称</th>
								<th class="col-lg-3">附件标题</th>
								<th class="col-lg-3">附件描述</th>
								<th class="col-lg-3">操作</th>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="grid-table-body"  style="width: 100%;">
					<table class="table table-responsive table-bordered table-hover table-striped">
						<tbody id="fileList">
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="tab_permiss" class="tab-pane fade"></div>
	</div>
</form>
