<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp -->
<%@ page import="java.util.Date"%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript">
var grid;
var form;
var _dialog;
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	        	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	                   form.find('#hasTitleImg_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#hasTitleImgID_').val($(this).getValue());
	                   });
	                	            	                	                   form.find('#hasContentImg_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#hasContentImgID_').val($(this).getValue());
	                   });
	                	            	                	            	                	            	                	            	                	            	                	            	                	                   form.find('#allowUpdown_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#allowUpdownID_').val($(this).getValue());
	                   });
	                	            	                	                   form.find('#isBlank_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#isBlankID_').val($(this).getValue());
	                   });
	                	            	                	            	                	            	                	            	                	                   form.find('#allowShare_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#allowShareID_').val($(this).getValue());
	                   });
	                	            	                	                   form.find('#allowScore_SELECT').select({
	                        title: '请选择',
	                        contents: [
	                            {title: '请选择', value: ''},
	                            {title: '是', value: '1'},
	                            {title: '否', value: '0'}
	                        ]
	                   }).on('change',function(){
	                        form.find('#allowScoreID_').val($(this).getValue());
	                   });
	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 180;
	         return grid.grid({
	                identity:"id",
	                buttons: [
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
	                    ],
	                url:"${pageContext.request.contextPath}/CmsChannelExt/pageJson.koala",
	                columns: [
	                     	                         	                         { title: 'channelId', name: 'channelId', width: width},
	                         	                         	                         	                         { title: 'channelName', name: 'channelName', width: width},
	                         	                         	                         	                         { title: 'finalStep', name: 'finalStep', width: width},
	                         	                         	                         	                         { title: 'afterCheck', name: 'afterCheck', width: width},
	                         	                         	                         	                         { title: 'isStaticChannel', name: 'isStaticChannel', width: width},
	                         	                         	                         	                         { title: 'isStaticContent', name: 'isStaticContent', width: width},
	                         	                         	                         	                         { title: 'isAccessByDir', name: 'isAccessByDir', width: width},
	                         	                         	                         	                         { title: 'isListChild', name: 'isListChild', width: width},
	                         	                         	                         	                         { title: 'pageSize', name: 'pageSize', width: width},
	                         	                         	                         	                         { title: 'channelRule', name: 'channelRule', width: width},
	                         	                         	                         	                         { title: 'contentRule', name: 'contentRule', width: width},
	                         	                         	                         	                         { title: 'link', name: 'link', width: width},
	                         	                         	                         	                         { title: 'tplChannel', name: 'tplChannel', width: width},
	                         	                         	                         	                         { title: 'tplContent', name: 'tplContent', width: width},
	                         	                         	                         	                         { title: 'titleImg', name: 'titleImg', width: width},
	                         	                         	                         	                         { title: 'contentImg', name: 'contentImg', width: width},
	                         	                         	                         	                         { title: 'hasTitleImg', name: 'hasTitleImg', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.hasTitleImg ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                         	                         { title: 'hasContentImg', name: 'hasContentImg', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.hasContentImg ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                         	                         { title: 'titleImgWidth', name: 'titleImgWidth', width: width},
	                         	                         	                         	                         { title: 'titleImgHeight', name: 'titleImgHeight', width: width},
	                         	                         	                         	                         { title: 'contentImgWidth', name: 'contentImgWidth', width: width},
	                         	                         	                         	                         { title: 'contentImgHeight', name: 'contentImgHeight', width: width},
	                         	                         	                         	                         { title: 'commentControl', name: 'commentControl', width: width},
	                         	                         	                         	                         { title: 'allowUpdown', name: 'allowUpdown', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.allowUpdown ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                         	                         { title: 'isBlank', name: 'isBlank', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.isBlank ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                         	                         { title: 'title', name: 'title', width: width},
	                         	                         	                         	                         { title: 'keywords', name: 'keywords', width: width},
	                         	                         	                         	                         { title: 'description', name: 'description', width: width},
	                         	                         	                         	                         { title: 'allowShare', name: 'allowShare', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.allowShare ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                         	                         { title: 'allowScore', name: 'allowScore', width: 120, render:function(rowdata, rowindex, value){
	                             return rowdata.allowScore ? "<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>" : "<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>";
	                         }},
	                         	                         	                             { title: '操作', width: 120, render: function (rowdata, name, index)
	                                 {
	                                     var param = '"' + rowdata.id + '"';
	                                     var h = "<a href='javascript:openDetailsPage(" + param + ")'>查看</a> ";
	                                     return h;
	                                 }
	                             }
	                ]
	         }).on({
	                   'add': function(){
	                       self.add($(this));
	                   },
	                   'modify': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                       self.modify(indexs[0], $this);
	                    },
	                   'delete': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '请选择要删除的记录'
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: '确定要删除所选记录吗?',
	                            callBack: remove
	                        });
	                   }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/CmsChannelExt-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'));
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/CmsChannelExt/add.koala', dialog.find('form').serialize()).done(function(result){
	                   if(result.success ){
	                        dialog.modal('hide');
	                        e.data.grid.data('koala.grid').refresh();
	                        e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                         });
	                    }else{
	                        dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                        });
	                     }
	              });
	        });
	    },
	    modify: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/CmsChannelExt-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/CmsChannelExt/get/' + id + '.koala').done(function(json){
	                       json = json.data;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(elm.hasClass('select')){
	                                elm.setValue(json[index]);
	                            }else{
	                                elm.val(json[index]);
	                            }
	                        }
	                });
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/CmsChannelExt/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                            });
	                        }else{
	                            dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                            });
	                        }
	                    });
	                });
	        });
	    },
	    initPage: function(form){
	              form.find('.form_datetime').datetimepicker({
	                   language: 'zh-CN',
	                   format: "yyyy-mm-dd",
	                   autoclose: true,
	                   todayBtn: true,
	                   minView: 2,
	                   pickerPosition: 'bottom-left'
	               }).datetimepicker('setDate', new Date());//加载日期选择器
	               form.find('.select').each(function(){
	                    var select = $(this);
	                    var idAttr = select.attr('id');
	                    select.select({
	                        title: '请选择',
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                    });
	               });
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/CmsChannelExt/delete.koala', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.result
	                            });
	                        }
	    	});
	    }
	}
	PageLoader.initSearchPanel();
	PageLoader.initGridPanel();
	form.find('#search').on('click', function(){
            if(!Validator.Validate(document.getElementById("<%=formId%>"),3))return;
            var params = {};
            form.find('input').each(function(){
                var $this = $(this);
                var name = $this.attr('name');
                if(name){
                    params[name] = $this.val();
                }
            });
            grid.getGrid().search(params);
        });
});

var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/CmsChannelExt-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/CmsChannelExt/get/' + id + '.koala').done(function(json){
                       json = json.data;
                        var elm;
                        for(var index in json){
                        if(json[index]+"" == "false"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>");
                        	}else if(json[index]+"" == "true"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>");
                        	}else{
                          		 dialog.find('#'+ index + 'ID').html(json[index]+"");
                        	}
                        }
               });
                dialog.modal({
                    keyboard:false
                }).on({
                    'hidden.bs.modal': function(){
                        $(this).remove();
                    }
                });
        });
}
</script>
</head>
<body>
<div style="width:98%;margin-right:auto; margin-left:auto; padding-top: 15px;">
<!-- search form -->
<form name=<%=formId%> id=<%=formId%> target="_self" class="form-horizontal">
<input type="hidden" name="page" value="0">
<input type="hidden" name="pagesize" value="10">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
          <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">channelId:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="channelId" class="form-control" type="text" style="width:180px;" id="channelIdID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">channelName:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="channelName" class="form-control" type="text" style="width:180px;" id="channelNameID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">finalStep:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="finalStep" class="form-control" type="text" style="width:180px;" id="finalStepID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">afterCheck:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="afterCheck" class="form-control" type="text" style="width:180px;" id="afterCheckID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">isStaticChannel:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="isStaticChannel" class="form-control" type="text" style="width:180px;" id="isStaticChannelID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">isStaticContent:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="isStaticContent" class="form-control" type="text" style="width:180px;" id="isStaticContentID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">isAccessByDir:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="isAccessByDir" class="form-control" type="text" style="width:180px;" id="isAccessByDirID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">isListChild:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="isListChild" class="form-control" type="text" style="width:180px;" id="isListChildID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">pageSize:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="pageSize" class="form-control" type="text" style="width:180px;" id="pageSizeID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">channelRule:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="channelRule" class="form-control" type="text" style="width:180px;" id="channelRuleID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">contentRule:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="contentRule" class="form-control" type="text" style="width:180px;" id="contentRuleID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">link:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="link" class="form-control" type="text" style="width:180px;" id="linkID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">tplChannel:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="tplChannel" class="form-control" type="text" style="width:180px;" id="tplChannelID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">tplContent:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="tplContent" class="form-control" type="text" style="width:180px;" id="tplContentID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">titleImg:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="titleImg" class="form-control" type="text" style="width:180px;" id="titleImgID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">contentImg:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="contentImg" class="form-control" type="text" style="width:180px;" id="contentImgID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">hasTitleImg:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="hasTitleImg_SELECT"></div>
	      <input type="hidden" id="hasTitleImgID_" name="hasTitleImg" />
	  </div>
                      <label class="control-label" style="width:100px;float:left;">hasContentImg:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="hasContentImg_SELECT"></div>
	      <input type="hidden" id="hasContentImgID_" name="hasContentImg" />
	  </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">titleImgWidth:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="titleImgWidth" class="form-control" type="text" style="width:180px;" id="titleImgWidthID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">titleImgHeight:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="titleImgHeight" class="form-control" type="text" style="width:180px;" id="titleImgHeightID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">contentImgWidth:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="contentImgWidth" class="form-control" type="text" style="width:180px;" id="contentImgWidthID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">contentImgHeight:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="contentImgHeight" class="form-control" type="text" style="width:180px;" id="contentImgHeightID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">commentControl:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="commentControl" class="form-control" type="text" style="width:180px;" id="commentControlID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">allowUpdown:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="allowUpdown_SELECT"></div>
	      <input type="hidden" id="allowUpdownID_" name="allowUpdown" />
	  </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">isBlank:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="isBlank_SELECT"></div>
	      <input type="hidden" id="isBlankID_" name="isBlank" />
	  </div>
                      <label class="control-label" style="width:100px;float:left;">title:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="title" class="form-control" type="text" style="width:180px;" id="titleID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">keywords:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="keywords" class="form-control" type="text" style="width:180px;" id="keywordsID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">description:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="description" class="form-control" type="text" style="width:180px;" id="descriptionID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">allowShare:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="allowShare_SELECT"></div>
	      <input type="hidden" id="allowShareID_" name="allowShare" />
	  </div>
                      <label class="control-label" style="width:100px;float:left;">allowScore:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="allowScore_SELECT"></div>
	      <input type="hidden" id="allowScoreID_" name="allowScore" />
	  </div>
            </div>
            </td>
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
