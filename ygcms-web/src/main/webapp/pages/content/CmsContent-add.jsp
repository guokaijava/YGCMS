<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/lib/ajaxfileupload.js"></script>
<style type="text/css">
input[type="radio"],input[type="checkbox"]{
	vertical-align: top;
}
</style>
<form class="form-horizontal" style="min-height:560px;height:560px" enctype="multipart/form-data" >
      <ul class="nav nav-tabs" id="myTab">
        <li class="active"><a data-toggle="tab" href="#tab_base">基本信息</a></li>
        <li class=""><a data-toggle="tab" href="#tab_content">内容编辑<i class="icon-remove tab-close"></i></a></li>
        <li class=""><a data-toggle="tab" href="#tab_image">图片信息<i class="icon-remove tab-close"></i></a></li>
        <!--
        <li class=""><a data-toggle="tab" href="#tab_file">附件信息<i class="icon-remove tab-close"></i></a></li>
          -->
        <li class=""><a data-toggle="tab" href="#tab_permiss">高级设置<i class="icon-remove tab-close"></i></a></li>
      </ul>
      <div class="tab-content" id="myTabContent" style="padding-top:20px;height:540px;overflow-y:auto;overflow-x:hidden">
        <div id="tab_base" class="tab-pane fade active in">
        </div>
         <div id="tab_content" class="tab-pane fade">
            <iframe src="../thirdparty/ueditor/index.html" name="txteditor" id="txteditor" scrolling="no" frameborder="0" style="width:100%;height:500px;display:none"></iframe>
        </div>
        <div id="tab_image" class="tab-pane fade">
          
        </div>
        <!--
         <div id="tab_file" class="tab-pane fade">
          
        </div>
        -->
        <div id="tab_permiss" class="tab-pane fade">
          
        </div>
      </div>
</form>
