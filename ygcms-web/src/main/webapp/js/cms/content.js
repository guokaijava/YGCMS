var contentManager = function(){
	var baseUrl =  contextPath + '/CmsContent/';
	var dialog = null;    //对话框
	/**
	 * 生成内容模版树
	 */
	var getTree = function(id){
		$('#contentTree').loader({
			opacity: 0
		});
		
		$.get(contextPath + '/CmsChannel/getSitelist.koala').done(function(data){
			var firstsite = 0;
			$.each(data.sitelist, function(index){
			  if(index==0){
				  firstsite=this.id;
			  }
			  $("#contentSitelist").append("<option value="+this.id+">"+this.sitename+"</option>");
		    });
			$("#contentSitelist").change(function(){
				getTreeData(this.value);
			});
			getTreeData(firstsite);
		});
	};
	var getTreeData = function(siteId){
		$('#contentTree').html("");
		var firstchild =0;
		var rootcid = null;
        $.get(contextPath + '/CmsChannel/tree.koala?siteid='+siteId).done(function(data){
        	$('#contentTree').loader('hide');
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
            $('#contentTree').off().data('koala.tree', null).tree({
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
                	$("#contentDetail").find("#pid").val(data.data.id);
                	$("#contentDetail").find("#pname").val(data.data.title);
                },
                'selectChildren': function(event, data){
                	selectChildren(data.id);
                	$("#contentDetail").find("#pid").val(data.id);
                	$("#contentDetail").find("#pname").val(data.title);
                }
            });
        	if(rootcid.id){
        		var $element = $('#contentTree').find('#'+rootcid.id).click();
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
                if ($('#contentTree').find('.tree-folder-header:first').length != 0) {
                    $('#contentTree').find('.tree-folder-header:first').click();
                } else {
                    $('#contentTree').find('.tree-item:first').click();
                }

        	}
        	datainit(rootcid);
        });
	}
	
	//获取专题数据
	var topicList = null;
	var getTopicData = function(){
		$.get(contextPath + '/CmsTopic/allList.koala').done(function(data){
			topicList = data;
		});
	}
	//获取内容类型数据
	var typeList = null;
	var getTypeData = function(){
		$.get(contextPath + '/CmsContentType/allList.koala').done(function(data){
			typeList = data;
		});
	}
	
	var selectParent = function(id){
		datainit(id);
		//$('#contentgrid').getGrid().urlrefresh(baseUrl+"pageJson/"+id+".koala");
	};
	
	var selectChildren = function(id){
		datainit(id);
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
    
    //初始化 发布模型 列表
    var initoperate = function(){
		var url = contextPath + '/CmsModel/pageJson.koala?page=0&pagesize=20';
		 $.get(url).done(function(data){
			 var operateul = $("#content_createmenu");
			 $.each(data.data, function(){
				 operateul.append("<li id=\""+this.id+"\"><a>"+this.modelname+"</a></li>")  
             });
			 operateul.find("li").each(function(data){
				 $(this).click(function(){
					    var type = $(this).attr("id");
					    $("#contentDetail").find("#modelid").val(type);
					    //获取专题数据
					    getTopicData();
					    //获取类型数据
					    getTypeData();
				        var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg">'
				        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
				        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
				        	+'<h4 class="modal-title">添加信息</h4></div><div class="modal-body">'
				        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
				        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
				        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
				        	+'</div></div>');
				        $.get('pages/content/CmsContent-add.jsp').done(function(html){
				            dialog.modal({
				                keyboard:false
				            }).on({
				                'hidden.bs.modal': function(){
				                    $(this).remove();
				                },
				                'shown.bs.modal':function(){
				                	 $.get(contextPath + '/CmsModelItem/contentGetItemsByPrarentId/'+type+'.koala').done(function(result){
				                		 console.log(result);
				                		 renderForm(result,dialog);
				                	 });
				                }
				            }).find('.modal-body').html(html);
				        });
				 });
			 });
		 });
	};
	
	// 渲染表单
	var renderForm = function(result,root){
		
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
		
		// 绑定保存事件
		root.find("#save").click(function(){
			var txtcontent = root.find("#txteditor")[0].contentWindow.getContent();
			root.find("#txt").val(txtcontent);
			if(!Validator.Validate(root.find('form')[0],3))return;
            $.post(baseUrl+'add.koala', root.find('form').serialize()).done(function(result){
                 if(result.success ){
                	  root.modal('hide');
                      e.data.grid.data('koala.grid').refresh();
                      e.data.grid.message({
                          type: 'success',
                          content: '保存成功'
                       });
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
		if(row.datatype == 1){ // 字符串文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 2){ // 整型文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 3){ // 浮点型文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 4){ // 文本区
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><textarea name='"+field_name+"' class=\"form-control\"></textarea></div>";
		}else if(row.datatype == 5){ // 日期
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><input type='date' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 6){ // 下拉列表
			if(row.field == "channelId"){
				//栏目
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\">";
				rowhtml += "<option value='"+$("#contentDetail").find("#pid").val()+"'>"+$("#contentDetail").find("#pname").val()+"</option>";
				rowhtml += "</select></div>";
			}else if(row.field == "topicId"){
				//专题
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\">";
				for(var i=0;i<topicList.length;i++){
					var topic= topicList[i];
					rowhtml += "<option value='"+topic.id+"'>"+topic.topicname+"</option>";
				}
				rowhtml += "</select></div>";
			}else if(row.field == "typeId"){
				//内容类型
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\">";
				for(var i=0;i<typeList.length;i++){
					var type= typeList[i];
					rowhtml += "<option value='"+type.id+"'>"+type.typename+"</option>";
				}
				rowhtml += "</select></div>";
			}else{
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\" value='"+field_value+"'></select></div>";
			}
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
				//field_value = result.cmsChannelTxt!=undefined?result.cmsChannelTxt[field_name]:field_value;
				//root.find("#txteditor")[0].contentWindow.setContent(field_value);
				rowhtml = "<input type=\"hidden\" name='"+field_name+"' id='"+field_name+"' value='"+field_value+"'/>";
			}
		}else if(row.datatype == 10){ 
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><div class=\"fileinput\"><button class=\"btn btn-success\"><i class=\"glyphicon glyphicon-picture\"></i>&nbsp;选择文件</button><input type='file' id='"+field_name+"_file' name=\"myfiles\"/><input type=\"hidden\" name='"+field_name+"' id='"+field_name+"'/><img id='"+field_name+"_view' alt='请上传"+row.itemlabel+"' src='"+field_value+"'/><div></div>";
		}
		return rowhtml;
	}
	
	var loaddataindex=0;
	var datainit = function(rootcid){
		
		var grid = $('#contentgrid');
		var cols = [{
            title: 'ID',
            name: 'id',
            width: 30
        }, {
            title: '标题',
            name: 'channelPath',
            width: 200,
            sortable: false
        },{
        	title: '类型',
        	name: 'type',
        	width: 60
        },{
        	title: '发布者',
        	name: 'type',
        	width: 100
        },{
        	title: '点击',
        	name: 'type',
        	width: 40
        },{
        	title: '发布时间',
        	name: 'type',
        	width: 100
        },{
        	title: '状态',
        	name: 'type',
        	width: 60
        }];
		
		if(rootcid!=null){
				if(loaddataindex>0){
					grid.getGrid().urlrefresh(baseUrl+"pageJson.koala");
				}else{
					grid.grid({
			            identity: 'id',
			            columns: cols,
			            isShowPages:false,
			            url:baseUrl+"pageJson.koala"
			        });
				}
				loaddataindex++;
				grid.find(".grid-table-body").css("height","462px");
				
		}
	}
	
	return {
		getTree: getTree,
		initoperate:initoperate
	};
};
