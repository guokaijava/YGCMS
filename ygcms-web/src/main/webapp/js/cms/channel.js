var channelManager = function(){
	var baseUrl =  contextPath + '/CmsChannel/';
	var dialog = null;    //对话框
	/**
	 * 生成内容模版树
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
                },
                'selectChildren': function(event, data){
                	selectChildren(data.id);
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
		alert(id);
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
				        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
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
	// 渲染表单
	var renderForm = function(result,root){
		for(var i = 0;result.length>0&&i<result.length;i++){
			var ele = result[i];
			console.log(ele);
			if(ele.card == 1){ // 基本信息
				root.find("#tab_base").append(renderRow(ele));
			}else if(ele.card == 2){ // 编辑信息
				root.find("#tab_content").append(renderRow(ele));
			}else if(ele.card == 3){ // 图片信息
				root.find("#tab_image").append(renderRow(ele));
			}else if(ele.card == 4){ // 附件信息
				root.find("#tab_file").append(renderRow(ele));
			}else if(ele.card == 5){ // 高级设置
				root.find("#tab_permiss").append(renderRow(ele));
			}
		}
	};
	// 渲染行
	var renderRow = function(row){
		var rowhtml="";
		var field_name = row.iscustom == 1?"attr_"+row.field:row.field;
		if(row.datatype == 1){ // 字符串文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 2){ // 整型文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 3){ // 浮点型文本
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 4){ // 文本区
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 5){ // 日期
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 6){ // 下拉列表
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 7){ // 复选框
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}else if(row.datatype == 8){ // 单选框
			rowhtml = "<div class=\"form-group\"><label class=\"col-lg-4 control-label\">"+row.itemlabel+"</label><div class=\"col-lg-6\"><input type='text' name='"+field_name+"' class=\"form-control\"/></div>";
		}
		return rowhtml;
	}
	
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
                var h='<a href="javascript:contenttpl().rename(\''+rowdata.fileName+'\')">修改</a>';
                	 h+='&nbsp;&nbsp;<a href="javascript:.xiugai(\''+rowdata.fileName+'\')">删除</a>';
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
		initoperate:initoperate
	};
};
