// 删除附件
	var delfile = function(id){
		$.get(contextPath + '/CmsContent/removefile/'+id+'.koala').done(function(result){
			$("#"+id).remove();
		});
	};
	// 打开附件
	var openfile = function(path){
		window.open(contextPath+path);
	};
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
				$("#contentDetail").find("#siteid").val(this.value);
			});
			getTreeData(firstsite);
			$("#contentDetail").find("#siteid").val(firstsite);
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
		});
	}

	var selectParent = function(id){
		datainit(id);
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
			$("#content_createmenu").html("");
			$.each(data.data, function(){
				operateul.append("<li id=\""+this.id+"\"><a>"+this.modelname+"</a></li>")  
			});
			operateul.find("li").each(function(data){
				$(this).click(function(){
					var type = $(this).attr("id");
					$("#contentDetail").find("#modelid").val(type);
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
								$.get(baseUrl + 'toAdd.koala?modelId='+type).done(function(result){
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
		// 增加站点元素
		root.find("#tab_base").append("<input type=\"hidden\" name=\"siteId\" value=\""+$("#contentDetail").find("#siteid").val()+"\"/>");
		// 增加模板元素
		root.find("#tab_base").append("<input type=\"hidden\" name=\"modelId\" value=\""+$("#contentDetail").find("#modelid").val()+"\"/>");
		// 增加内容ID
		if(result.cmsContent !=null ){
			root.find("#tab_base").append("<input type=\"hidden\" name=\"contentId\" id=\"contentId\" value=\""+result.cmsContent["id"]+"\"/>");
			root.find("#tab_base").append("<input type=\"hidden\" name=\"version\" value=\""+result.cmsContentExt["version"]+"\"/>");
			root.find("#tab_base").append("<input type=\"hidden\" name=\"id\" value=\""+result.cmsContentExt["id"]+"\"/>");
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
				if(result.cmsContent!=null ){
					root.find("#li_file").css("display","block");
				}else{
					root.find("#li_file").css("display","none");
				}
				root.find("#tab_file").append(renderRow(result,ele,root));
			}else if(ele.card == 5){ // 高级设置
				root.find("#tab_permiss").append(renderRow(result,ele,root));
			}
		}
		// 附件列表赋值
		if(result.cmsContentAttachment!=undefined && result.cmsContentAttachment.length > 0){
			for(var i=0;i<result.cmsContentAttachment.length;i++){
				var obj = result.cmsContentAttachment[i];
				root.find("#fileList").append("<tr id=\""+obj.id+"\">"+
						"<td class=\"col-lg-3\">"+obj.filename+"</th>"+
						"<td class=\"col-lg-3\">"+obj.fileTitle+"</th>"+
						"<td class=\"col-lg-3\">"+obj.fileDescription+"</th>"+
						"<td class=\"col-lg-3\"><div class='btn btn-danger' onclick=\"delfile('"+obj.id+"');\">删除</div>&nbsp;&nbsp;<div class='btn btn-info' onclick=\"openfile('"+obj.attachmentPath+"');\">打开或下载</div></th>"+
					"</tr>");
			}
		}
        // 附件列表文件上传
		root.find("#uploadfile").click(function(){
			$.ajaxFileUpload ({
				url: contextPath +"/CmsContent/upload.koala?fileTitle="+root.find("#file_title").val()+"&fileDescription="+root.find("#file_desc").val()+"&contentId="+root.find("#contentId").val(), //用于文件上传的服务器端请求地址
				secureuri: false, //是否需要安全协议，一般设置为false
				fileElementId:'ufile', //文件上传域的ID
				dataType: 'json', //返回值类型 一般设置为json
				success: function (data, status){
					console.log(encodeURI(data[0].filename));
					root.find("#fileList").append("<tr id=\""+data[0].id+"\">"+
								"<td class=\"col-lg-3\">"+data[0].filename+"</th>"+
								"<td class=\"col-lg-3\">"+data[0].fileTitle+"</th>"+
								"<td class=\"col-lg-3\">"+data[0].fileDescription+"</th>"+
								"<td class=\"col-lg-3\"><div class='btn btn-danger' onclick=\"delfile('"+data[0].id+"');\">删除</div>&nbsp;&nbsp;<div class='btn btn-info' onclick=\"openfile('"+data[0].attachmentPath+"');\">打开或下载</div></th>"+
							"</tr>");
				}
			});
		});
		
		// 绑定文件上传事件
		root.find("#tab_image input[type=file]").each(function(){
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
			var posturl = baseUrl+'add.koala';
			if(result.cmsContent!=undefined){
				posturl = baseUrl+'update.koala';
			}
			$.post(posturl, root.find('form').serialize()).done(function(result){
				if(result.success ){
					root.modal('hide');
					$('#contentgrid').getGrid().refresh();
					$('#contentgrid').message({
						type: 'success',
						content: '保存成功'
					});
				}else{
					$('#contentgrid').message({
						type: 'error',
						content: result.actionError
					});
				}
			});
		});
	};
	
	// 修改栏目信息
	var modifyInfoSort = function(id){
		var dialog = $('<div class="modal fade"><div class="modal-dialog modal-lg">'
				+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
				+'data-dismiss="modal" aria-hidden="true">&times;</button>'
				+'<h4 class="modal-title">修改信息</h4></div><div class="modal-body">'
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
					$.get(baseUrl + 'get/'+id+'.koala').done(function(result){
						$("#contentDetail").find("#pid").val(result.cmsContent.channelId);
						$("#contentDetail").find("#pname").val(result.channelName);
						$("#contentDetail").find("#modelid").val(result.cmsContent.modelId);
						$("#contentDetail").find("#siteid").val(result.cmsContent.siteId);
						renderForm(result,dialog);
					});
				}
			}).find('.modal-body').html(html);
		});
	};
	
	var delInfoSort = function(id){
		var data = [{ name: 'ids', value: id.join(',') }];
    	$.post(baseUrl+'delete.koala', data).done(function(result){
            if(result.success){
                $('#contentgrid').getGrid().refresh();
                $('#contentgrid').message({
                    type: 'success',
                    content: '删除成功'
                });
            }else{
            	$('#contentgrid').message({
                    type: 'error',
                    content: result.result
                });
            }
    	});
	};
	
	// 渲染行
	var renderRow = function(result,row,root){
		var rowhtml="";
		var field_name = row.iscustom == 1?"attr_"+row.field:row.field;
		var field_value="";
		if(result.cmsContent != undefined){
			if(row.iscustom == 1){
				for(var i=0;result.cmsContentAttr.length>0&&i<result.cmsContentAttr.length;i++){
					if(result.cmsContentAttr[i].attrName == row.field){
						field_value = result.cmsContentAttr[i].attrValue;
						break;
					}
				}
			}
			
			if(result.cmsContentTopic!=null && result.cmsContentTopic[field_name]!=undefined){
				field_value = result.cmsContentTopic[field_name];
			}
			if(result.cmsContentExt[field_name]!=undefined){
				field_value = result.cmsContentExt[field_name];
			}
			if(result.cmsContent[field_name]!=undefined){
				field_value = result.cmsContent[field_name];
			}
		}
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
			if(row.field == "channelId"){
				//栏目
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\" value='"+field_value+"'>";
				rowhtml += "<option value='"+$("#contentDetail").find("#pid").val()+"'>"+$("#contentDetail").find("#pname").val()+"</option>";
				rowhtml += "</select></div>";
			}else if(row.field == "topicId"){
				//专题
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\" value='"+field_value+"'>";
				rowhtml += "<option value=''>选择专题</option>";
				for(var i=0;i<result.topicList.length;i++){
					var topic= result.topicList[i];
					if(field_value==topic.id){
						rowhtml += "<option value='"+topic.id+"' selected='selected'>"+topic.topicname+"</option>";
					}else{
						rowhtml += "<option value='"+topic.id+"'>"+topic.topicname+"</option>";
					}
				}
				rowhtml += "</select></div>";
			}else if(row.field == "typeId"){
				//内容类型
				rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><select name='"+field_name+"' class=\"form-control\" value='"+field_value+"'>";
				for(var i=0;i<result.typeList.length;i++){
					var type= result.typeList[i];
					if(field_value==type.id){
						rowhtml += "<option value='"+type.id+"' selected='selected'>"+type.typename+"</option>";
					}else{
						rowhtml += "<option value='"+type.id+"'>"+type.typename+"</option>";
					}
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
				field_value = result.cmsContentTxt!=undefined?result.cmsContentTxt[field_name]:field_value;
				root.find("#txteditor")[0].contentWindow.setContent(field_value);
				rowhtml = "<input type=\"hidden\" name='"+field_name+"' id='"+field_name+"' value='"+field_value+"'/>";
			}
		}else if(row.datatype == 10){ //
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-3 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-7\"><div class=\"fileinput\"><button class=\"btn btn-success\"><i class=\"glyphicon glyphicon-picture\"></i>&nbsp;选择文件</button><input type='file' id='"+field_name+"_file' name=\"myfiles\"/><input type=\"hidden\" name='"+field_name+"' id='"+field_name+"' value='"+field_value+"'/><img id='"+field_name+"_view' alt='请上传"+row.itemlabel+"' src='"+field_value+"'/><div></div>";
		}else if(row.datatype == 11){ //
			rowhtml = "";
		}
		return rowhtml;
	}

	var loaddataindex=0;
	var datainit = function(rootcid){
		
		var grid = $('#contentgrid');
		var cols = [{
			title: '标题',
			name: 'title',
			width: 140,
			sortable: false
		},{
			title: '栏目',
			name: 'channelName',
			width: 80
		},{
			title: '类型',
			name: 'typeName',
			width: 60
		},{
			title: '发布者',
			name: 'author',
			width: 80
		},{
			title: '点击',
			name: 'viewsDay',
			width: 60
		},{
			title: '发布时间',
			name: 'releaseDate',
			width: 140
		},{
			title: '状态',
			name: 'status',
			width: 60
		}];

		var btns = [
		            {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
		            {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'},
		            ];
		if(rootcid!=null){
			if(loaddataindex>0){
				grid.getGrid().urlrefresh(baseUrl+"pageJson.koala?channelId="+rootcid);
			}else{
				grid.grid({
					identity: 'id',
					columns: cols,
					buttons: btns,
					isShowPages:true,
					url:baseUrl+"pageJson.koala?channelId="+rootcid
				}).on({
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
						modifyInfoSort(indexs[0]);
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
							delInfoSort(indexs);
						};
						$this.confirm({
							content: '确定要删除所选记录吗?',
							callBack: remove
						});
					},
					'newContent':function(event,data){
					}
				});
				grid.find(".btn-group").eq(0).prepend('<div class="btn-group"><button id="dLabel" type="button" class="btn btn-primary" style="border-top-right-radius: 0;border-bottom-right-radius: 0;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-plus"></span> 发布<span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dLabel" id="content_createmenu"></ul></div>');
			}
			loaddataindex++;
			initoperate();
		}
	}

	return {
		getTree: getTree,
		initoperate:initoperate
	};
};
