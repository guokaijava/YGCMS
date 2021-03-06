var channelManager = function(){
	var baseUrl =  contextPath + '/CmsChannel/';
	var dialog = null;    //对话框
	/**
	 * 生成内容模版
	 */
	var getTree = function(id){
		$('#channelTree').loader({
			opacity: 0
		});
		$.get(baseUrl + 'getSitelist.koala').done(function(data){
			var firstsite = 0;
			$.each(data.sitelist, function(index){
			  if(index==0){
				  firstsite=this.id;
			  }
			  $("#sitelist").append("<option value="+this.id+">"+this.sitename+"</option>");
		    });
			$("#sitelist").change(function(){
				getTreeData(this.value);
			});
			getTreeData(firstsite);
		});
	};
	var getTreeData = function(siteId){
		$('#channelTree').html("");
		$("#channelpage").find("#siteid").val(siteId);
		var firstchild =0;
		var rootcid = null;
        $.get(baseUrl + 'tree.koala?siteid='+siteId).done(function(data){
        	$('#channelTree').loader('hide');
            var zNodes = new Array();
            $.each(data, function(){
                 var zNode = {};
                 if(this.children.length > 0){
                    zNode.type = 'parent';
                 }else{
                    zNode.icon = 'glyphicon glyphicon-list-alt'
                 }
                 if(this.title == ""){
                	 this.title = '根节点';
                 }
                 rootcid = this;
                 zNode.menu = this;
                 if(this.children && this.children.length > 0){
                    zNode.children = getChildrenData(new Array(), this.children);
                 }
                 zNodes.push(zNode);
            });
            var dataSourceTree = {
                data: zNodes,
                delay: 400
            };
            $('#channelTree').off().data('koala.tree', null).tree({
                dataSource: dataSourceTree,
                loadingHTML: '<div class="static-loader">Loading...</div>',
                multiSelect: false,
                cacheItems: true
            }).on({
                'contextmenu': function(e){
                    return false;
                },
                'selectParent': function(event, data){
                	selectParent(data.data.id);
                	$("#channelpage").find("#pid").val(data.data.id);
                	$("#channelpage").find("#pname").val(data.data.title);
                },
                'selectChildren': function(event, data){
                	selectChildren(data.id);
                	$("#channelpage").find("#pid").val(data.id);
                	$("#channelpage").find("#pname").val(data.title);
                }
            });
        	if(rootcid.id){
        		var $element = $('#channelTree').find('#'+rootcid.id).click();
        		if($element.hasClass('tree-folder')){
        			$element.find('.tree-folder-header:first').click();
        		}
        		$element.parents().filter('.tree-folder-content').each(function(){
        			var $this = $(this);
					$this.show()
						 .prev('.tree-folder-header')
						 .find('.glyphicon-folder-close')
						 .removeClass('glyphicon-folder-close')
						 .addClass('glyphicon-folder-open');
        		});
        	}else{
                if ($('#channelTree').find('.tree-folder-header:first').length != 0) {
                    $('#channelTree').find('.tree-folder-header:first').click();
                } else {
                    $('#channelTree').find('.tree-item:first').click();
                }

        	}
        	datainit(rootcid);
        });
	}
	
	var selectParent = function(id){
		if(loaddataindex>0){
			$('#channelgrid').getGrid().urlrefresh(baseUrl+"getChildChannel/"+id+".koala");
		}
	};
	
	var selectChildren = function(id){
	};
	
	
	var getChildrenData = function(nodes, items){
        $.each(items, function(){
            var zNode = {};
            if(this.children.length > 0){
                zNode.type = 'parent';
            }else{
                zNode.icon = 'glyphicon glyphicon-list-alt'
            }
            zNode.menu = this;
            if(this.children && this.children.length > 0){
                zNode.children = getChildrenData(new Array(), this.children);
            }
            nodes.push(zNode);
        });
        return nodes;
    };
	var initoperate = function(){
		var url = contextPath + '/CmsModel/pageJson.koala?page=0&pagesize=20';
		 $.get(url).done(function(data){
			 var operateul = $("#createmenu");
			 $.each(data.data, function(){
				 operateul.append("<li id=\""+this.id+"\"><a>"+this.modelname+"</a></li>")  
             });
			 operateul.find("li").each(function(data){
				 $(this).click(function(){
					    var type = $(this).attr("id");
					    $("#channelpage").find("#modelid").val(type);
				        var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg">'
				        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
				        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
				        	+'<h4 class="modal-title">新增栏目</h4></div><div class="modal-body">'
				        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
				        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
				        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
				        	+'</div></div>');
				        $.get('pages/channel/CmsChannel-add.jsp').done(function(html){
				            dialog.modal({
				                keyboard:false
				            }).on({
				                'hidden.bs.modal': function(){
				                    $(this).remove();
				                },
				                'shown.bs.modal':function(){
				                	 $.get(contextPath + '/CmsModelItem/getItemsByPid/'+type+'.koala').done(function(result){
				                		 renderForm(result,dialog);
				                	 });
				                }
				            }).find('.modal-body').html(html);
				        });
				 });
			 });
		 });
	};
	// 修改栏目信息
	var modifyInfoSort = function(id){
		   var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">修改栏目</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('pages/channel/CmsChannel-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                },
	                'shown.bs.modal':function(){
	                	 $.get(baseUrl + 'getChannel.koala?id='+id).done(function(result){
	                		 $("#channelpage").find("#modelid").val(result.cmsChannel.modelId);
	                		 renderForm(result,dialog);
	                	 });
	                }
	            }).find('.modal-body').html(html);
	        });
	        
	};
	// 渲染表单
	var renderForm = function(result,root){
		// 增加上级栏目名称
		root.find("#tab_base").append("<div class=\"form-group\"><label class=\"col-lg-3 control-label\">上级栏目</label><div class=\"col-lg-7\" style=\"line-height:33px\"><input type='hidden' readonly name='parentId' class=\"form-control\" value=\""+$("#channelpage").find("#pid").val()+"\"/>"+$("#channelpage").find("#pname").val()+"</div>");
		// 增加站点元素
		root.find("#tab_base").append("<input type=\"hidden\" name=\"siteId\" value=\""+$("#channelpage").find("#siteid").val()+"\"/>");
		// 增加模板元素
		root.find("#tab_base").append("<input type=\"hidden\" name=\"modelId\" value=\""+$("#channelpage").find("#modelid").val()+"\"/>");
		// 增加栏目ID
		if(result.cmsChannel !=null ){
			root.find("#tab_base").append("<input type=\"hidden\" name=\"id\" value=\""+result.cmsChannelExt["id"]+"\"/>");
            root.find("#tab_base").append("<input type=\"hidden\" name=\"version\" value=\""+result.cmsChannelExt["version"]+"\"/>");
		}
		// 渲染栏目模型元素
		for(var i = 0;result.tplList.length>0&&i<result.tplList.length;i++){
			var ele = result.tplList[i];
			if(ele.card == 1){ // 基本信息
				root.find("#tab_base").append(renderRow(result,ele,root));
			}else if(ele.card == 2){ // 编辑信息
				root.find("#tab_content").append(renderRow(result,ele,root));
			}else if(ele.card == 3){ // 图片信息
				root.find("#tab_image").append(renderRow(result,ele,root));
			}else if(ele.card == 4){ // 附件信息
				root.find("#tab_file").append(renderRow(result,ele,root));
			}else if(ele.card == 5){ // 高级设置
				root.find("#tab_permiss").append(renderRow(result,ele,root));
			}
		}
		// 绑定文件上传事件
		root.find("input[type=file]").each(function(){
			$(this).change(function(){
				if($(this).val()!=""){
					 var imgPath = $(this).val();
			         //判断上传文件的后缀名
			         var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
			         if (strExtension != 'jpg' && strExtension != 'gif'
			            && strExtension != 'png' && strExtension != 'bmp') {
			                alert("请选择图片文件");
			                return;
			            }
			         var dataEle = root.find("#"+$(this).attr("id").split("_")[0]);
			         var imgivewEle = root.find("#"+$(this).attr("id").split("_")[0]+"_view");
					$.ajaxFileUpload ({
		                    url: contextPath +"/CmsUpload/upload.koala", //用于文件上传的服务器端请求地址
		                    secureuri: false, //是否需要安全协议，一般设置为false
		                    fileElementId: $(this).attr("id"), //文件上传域的ID
		                    dataType: 'json', //返回值类型 一般设置为json
		                    success: function (data, status){
		                    	dataEle.val(data[0].localpath+"/"+data[0].fileName);
		                    	imgivewEle.attr("src",data[0].localpath+"/"+data[0].fileName);
		                    },
		                    error: function (data, status, e){
		                        alert(e);
		                    }
		            });
				}
			});
		});
		// 绑定保存事件
		root.find("#save").click(function(){
			var txtcontent = root.find("#txteditor")[0].contentWindow.getContent();
			root.find("#txt").val(txtcontent);
			if(!Validator.Validate(root.find('form')[0],3))return;
			var posturl = baseUrl+'addChannel.koala';
			if(result.cmsChannel!=undefined){
				posturl = baseUrl+'update.koala';
			}
            $.post(posturl,root.find('form').serialize()).done(function(result){
                 if(result.success ){
                	  root.modal('hide');
                	  getTreeData($("#sitelist").val());
                	  $('#channelgrid').getGrid().refresh();
                  }else{
                	  root.find('.modal-content').message({
                          type: 'error',
                          content: result.actionError
                      });
                   }
            });
		});
	};
	// 渲染行
	var renderRow = function(result,row,root){
		var rowhtml="";
		var field_name = row.iscustom == 1?"attr_"+row.field:row.field;
		var field_value="";
		if(result.cmsChannel != undefined){
			if(row.iscustom == 1){
				for(var i=0;result.cmsChannelAttr.length>0&&i<result.cmsChannelAttr.length;i++){
					if(result.cmsChannelAttr[i].attrName == row.field){
						field_value = result.cmsChannelAttr[i].attrValue;
						break;
					}
				}
			}
			if(result.cmsChannelExt[field_name]!=undefined){
				field_value = result.cmsChannelExt[field_name];
			}
			if(result.cmsChannel[field_name]!=undefined){
				field_value = result.cmsChannel[field_name];
			}
		}
		if(row.isdisplay == 0){ // 不显示
			rowhtml = "<input type=\"hidden\" name='"+field_name+"' value='"+field_value+"'/>";
		}else{
			if(row.datatype == 1){ // 字符串文本
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' value='"+field_value+"' class=\"form-control\"/></div>";
			}else if(row.datatype == 2){ // 整型文本
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' value='"+field_value+"' class=\"form-control\"/></div>";
			}else if(row.datatype == 3){ // 浮点型文本
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' value='"+field_value+"' class=\"form-control\"/></div>";
			}else if(row.datatype == 4){ // 文本区
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><textarea name='"+field_name+"' class=\"form-control\">"+field_value+"</textarea></div>";
			}else if(row.datatype == 5){ // 日期
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='date' name='"+field_name+"' value='"+field_value+"' class=\"form-control\"/></div>";
			}else if(row.datatype == 6){ // 下拉列表
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\" value='"+field_value+"'></select></div>";
			}else if(row.datatype == 7){ // 复选框
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\" style=\"padding-top:6px\"><label><input type='checkbox' name='"+field_name+"' value=\"1\"/>&nbsp;&nbsp;有</label></div>";
			}else if(row.datatype == 8){ // 单选框
				var firstVal = "是";
				var secVal="否";
				if(row.field == "commentControl"){ // 评论
					var fhtml="",shtml="",thtml="";
					if(field_value=="0"){
						fhtml="checked";
					}else if(field_value=="1"){
						shtml="checked";
					}else if(field_value=="2"){
						thtml="checked";
					}
					if(field_value==""){
						fhtml="checked";
					}
					rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\" style=\"padding-top:6px\"><label><input type='radio' name='"+field_name+"' value=\"0\" "+fhtml+"/>&nbsp;游客评论&nbsp;&nbsp;&nbsp;&nbsp;</label><label><input type='radio' name='"+field_name+"'  value=\"1\" "+shtml+"/>&nbsp;登录评论&nbsp;&nbsp;&nbsp;&nbsp;</label><label><input type='radio' name='"+field_name+"'  value=\"2\" "+thtml+"/>&nbsp;关闭评论</label></div>";
				}else{
					if(row.optvalue!=""){
						firstVal = row.optvalue.split(",")[0];
						secVal = row.optvalue.split(",")[1];
					}
					var yeshtml="";
					var nohtml="";
					if(field_value=="1"||field_value=="true"){
						yeshtml="checked";
					}else if(field_value=="0"||field_value=="false"){
						nohtml="checked";
					}
					if(field_value==""){
						yeshtml="checked";
					}
					rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\" style=\"padding-top:6px;\"><label><input type='radio' name='"+field_name+"' value=\"1\" "+yeshtml+"/>&nbsp;"+firstVal+"</lable>&nbsp;&nbsp;&nbsp;&nbsp;<label><input type='radio' name='"+field_name+"'  value=\"0\" "+nohtml+"/>&nbsp;"+secVal+"</label></div>";
				}
			}else if(row.datatype == 9){ // 文本编辑
				if(row.field == "txt"){
					root.find("#txteditor").css("display","block");
					field_value = result.cmsChannelTxt!=undefined?result.cmsChannelTxt[field_name]:field_value;
					root.find("#txteditor")[0].contentWindow.setContent(field_value);
					rowhtml = "<input type=\"hidden\" name='"+field_name+"' id='"+field_name+"' value='"+field_value+"'/>";
				}
			}else if(row.datatype == 10){ 
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><div class=\"fileinput\"><button class=\"btn btn-success\"><i class=\"glyphicon glyphicon-picture\"></i>&nbsp;选择文件</button><input type='file' id='"+field_name+"_file' name=\"myfiles\"/><input type=\"hidden\" name='"+field_name+"' id='"+field_name+"' value='"+field_value+"'/><img id='"+field_name+"_view' alt='请上传"+row.itemlabel+"' src='"+field_value+"'/><div></div>";
			}
		}
		return rowhtml;
	}
	
	var delInfoSort = function(id){
		  var dialog = $('<div class="modal fade"><div class="modal-dialog modal-sm">'
		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
		        	+'<h4 class="modal-title">删除栏目</h4></div><div class="modal-body">'
		        	+'<h5>您确定要删除该栏目？</h5></div><div class="modal-footer">'
		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
		        	+'<button type="button" class="btn btn-success" id="delChannel">确定</button></div></div>'
		        	+'</div></div>');
		  dialog.modal({
              keyboard:false
          }).on({
              'hidden.bs.modal': function(){
                  $(this).remove();
              },
              'shown.bs.modal':function(){
              	 
              }
          })
          dialog.find("#delChannel").click(function(){
      		$.get(baseUrl+'delChannel.koala?id='+id).done(function(result){
            		if(result.success ){
            			dialog.modal('hide');
            			getTreeData($("#sitelist").val());
            			$('#channelgrid').getGrid().refresh();
             		}else{
            			$('#channelgrid').getGrid().message({
                     		type: 'error',
                     		content: result.actionError
                		});
             		}
       	    });
          });
	};
	
	var loaddataindex=0;
	var datainit = function(rootcid){
		
		var grid = $('#channelgrid');
		var cols = [{
            title: '栏目名称',
            name: 'channelName',
            width: 200
        }, {
            title: '访问路径',
            name: 'channelPath',
            width: 130,
            sortable: false
        },{
            title: '是否显示',
            name: 'isDisplay',
            width: 150,
            sortable: false,
            sortName: 'isDisplay',render:function(rowdata,name,index){
            	if(rowdata.isDisplay==1){
            		return "显示"
            	}else{
            		return "不显示"
            	}
            }
        },{
            title: '操作',
            width: 80,
            render:function(rowdata,name,index){
                var h='<a href="javascript:channelManager().modifyInfoSort(\''+rowdata.id+'\')">修改</a>';
                	 h+='&nbsp;&nbsp;<a href="javascript:channelManager().delInfoSort(\''+rowdata.id+'\')">删除</a>';
         	   return h;
            }
        }];
		if(rootcid!=null){
				if(loaddataindex>0){
					grid.getGrid().urlrefresh(baseUrl+"getChildChannel/"+rootcid.id+".koala");
				}else{
					grid.grid({
			            identity: 'id',
			            columns: cols,
			            isShowPages:false,
			            url:baseUrl+"getChildChannel/"+rootcid.id+".koala"
			        });
				}
				loaddataindex++;
				grid.find(".grid-table-body").css("height","462px");
				
		}
	}
	return {
		getTree: getTree,
		initoperate:initoperate,
		modifyInfoSort:modifyInfoSort,
		delInfoSort:delInfoSort
	};
};
