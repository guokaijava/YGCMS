<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<div class="department-detail" id="departmentDetail">
	<ul class="u-tree tree" id="departmentTree"
		oncontextmenu="return false" style="width: 28%"></ul>
	<div class="right-content" style="width: 70%;padding-top:5px;padding-right:0px;height:540px">
		<div id="filegrid" style="hight:540px">
			
		</div>
	</div>
	<div style="clear: both;"></div>
	<input id="curDir" type="hidden"/>
</div>
<script type="text/javascript"
	src="<c:url value='/js/cms/contenttpl.js' />"></script>
<script type="text/javascript">

$(function(){
	 contenttpl().getTree();
     var baseUrl =  contextPath + '/CmsTplManager/';
     var datainit = function(){
    	 var grid = $('#filegrid');
    	 var cols = [{
               title: '文件名称',
               name: 'fileName',
               width: 200,
               sortable: false,
               sortName: 'fileName',render:function(rowdata,name,index){
               	var h='<span class="glyphicon glyphicon-folder-close" aria-hidden="true"><span>&nbsp;'+rowdata.fileName+'</span></span>';
               	if(!rowdata.directory){
               		h='<span class="glyphicon glyphicon-file" aria-hidden="true"><span>&nbsp;'+rowdata.fileName+'</span></span>'; 
               	}
               	return h;
               }
           }, {
               title: '大小',
               name: 'size',
               width: 130,
               sortable: false,
               sortName: 'size',render:function(rowdata,name,index){
               	return rowdata[name]+"KB";
               }
           },{
               title: '最后修改时间',
               name: 'lastModified',
               width: 150,
               sortable: false,
               sortName: 'lastModified',render:function(rowdata,name,index){
               	return new Date(rowdata[name]).Format('yyyy-MM-dd hh:mm:ss');
               }
           },{
               title: '操作',
               width: 80,
               render:function(rowdata,name,index){
                   var h='<a href="javascript:contenttpl().rename(\''+rowdata.fileName+'\')">重命名</a>';
               	   if(!rowdata.directory){
                   	 h+='&nbsp;&nbsp;<a href="javascript:contenttpl().xiugai(\''+rowdata.fileName+'\')">修改</a>';
               	   }
            	   return h;
               }
           }];
           var buttons = [{
               content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-folder-close">新建目录</span></button>',
               action: 'addDir'
           }, {
               content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-file">新建文件</span></button>',
               action: 'addFile'
           },{
               content: '<button class="btn btn-info" type="button"><span class="glyphicon glyphicon-arrow-up">上传文件</span></button>',
               action: 'upFile'
           }, {
               content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove">删除</span></button>',
               action: 'delete'
           }];
           grid.grid({
               identity: 'id',
               columns: cols,
               buttons: buttons,
               url:baseUrl+"list.koala?path=",
               isShowPages:false
           }).on({	
           	'addDir':function(){
           		addDir($(this));
           	},
           	'addFile':function(){
           		addFile($(this));
           	},
           	'upFile':function(){
           		
           	},
           	'delete':function(event,data){
           		 var indexs = data.item;
                    var $this = $(this);
                    if(indexs.length == 0){
                        $this.message({
                               type: 'warning',
                               content: '请选择要删除的记录'
                        });
                        return;
                    }
                    var remove = function(){
                        delDirOrFile(indexs, $this);
                    };
                    $this.confirm({
                        content: '确定要删除所选记录吗?',
                        callBack: remove
                    });
           	}
           });
           grid.find(".grid-table-body").css("height","462px")
     }
     datainit();
     
     var addDir = function(grid){
  		 var dialog = $('<div class="modal fade"><div class="modal-dialog">'
  		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
  		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
  		        	+'<h4 class="modal-title">新增目录</h4></div><div class="modal-body">'
  		        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
  		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
  		        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
  		        	+'</div></div>');
  		 $.get('/pages/content/CmsDir-add.jsp').done(function(html){
  			 dialog.modal({
  				 keyboard:false
  			 }).on({
  				 'hidden.bs.modal': function(){
  					 $(this).remove();
  				 }
  			 }).find('.modal-body').html(html);
  		 });
  		 dialog.find('#save').on('click',{grid: grid}, function(e){
               if(!Validator.Validate(dialog.find('form')[0],3))return;
               $.post(baseUrl+'addDir.koala?path='+$("#curDir").val()+'/'+dialog.find("#dirnameID").val()).done(function(result){
                    if(result.success){
                         dialog.modal('hide');
                         e.data.grid.data('koala.grid').refresh();
                         e.data.grid.message({
                             type: 'success',
                             content: '保存成功'
                          });
                         contenttpl().refresh();
                     }else{
                         dialog.find('.modal-content').message({
                             type: 'error',
                             content: result.actionError
                         });
                      }
               });
           });
  	  }
       
      var delDirOrFile = function(ids, grid){
        	var names = '';
        	for(var i=0;i<ids.length;i++){
        		names+=ids[i].name+(i==ids.length-1?'':',');
        	}
        	var data = [{ name: 'ids', value: names }];
	    	$.post(baseUrl+'delDirOrFile.koala', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                            contenttpl().refresh();
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.result
	                            });
	                        }
	    	});
        }
      
      var addFile = function(grid){
   		 var dialog = $('<div class="modal fade"><div class="modal-dialog">'
   		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
   		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
   		        	+'<h4 class="modal-title">新增文件</h4></div><div class="modal-body">'
   		        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
   		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
   		        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
   		        	+'</div></div>');
   		 $.get('/pages/content/CmsFile-add.jsp').done(function(html){
   			 dialog.modal({
   				 keyboard:false
   			 }).on({
   				 'hidden.bs.modal': function(){
   					 $(this).remove();
   				 }
   			 }).find('.modal-body').html(html);
   		 });
   		 dialog.find('#save').on('click',{grid: grid}, function(e){
                if(!Validator.Validate(dialog.find('form')[0],3))return;
                $.post(baseUrl+'addFile.koala?path='+$("#curDir").val()+'/'+dialog.find("#fname").val()+'.html',dialog.find('form').serialize()).done(function(result){
                     if(result.success){
                          dialog.modal('hide');
                          e.data.grid.data('koala.grid').refresh();
                          e.data.grid.message({
                              type: 'success',
                              content: '保存成功'
                           });
                          contenttpl().refresh();
                      }else{
                          dialog.find('.modal-content').message({
                              type: 'error',
                              content: result.actionError
                          });
                       }
                });
            });
   	  }
        
});

</script>