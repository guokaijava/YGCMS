var resource = function(){
	var baseUrl =  contextPath + '/CmsResource/';
	var dialog = null;    //对话框
	
	
	/**
	 * 生成内容模版树
	 */
	var getTree = function(id){
		$('#resTree').loader({
			opacity: 0
		});
        $.get(baseUrl + 'tree.koala').done(function(data){
        	$('#resTree').loader('hide');
            var zNodes = new Array();
            $.each(data, function(){
                var zNode = {};
                if(this.directory){
                    zNode.type = 'parent';
                }else{
                    zNode.icon = 'glyphicon glyphicon-list-alt'
                }
                this.title = '网站资源';
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
            $('#resTree').off().data('koala.tree', null).tree({
                dataSource: dataSourceTree,
                loadingHTML: '<div class="static-loader">Loading...</div>',
                multiSelect: false,
                cacheItems: true
            }).on({
                'contextmenu': function(e){
                    return false;
                },
                'selectParent': function(event, data){
                    showFolder(data);
                },
                'selectChildren': function(event, data){
                    showTpl(data);
                },
            });
        	if(id){
        		var $element = $('#resTree').find('#'+id).click();
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
                if ($('#resTree').find('.tree-folder-header:first').length != 0) {
                    $('#resTree').find('.tree-folder-header:first').click();
                } else {
                    $('#resTree').find('.tree-item:first').click();
                }

        	}
        });
	};
	
	var getChildrenData = function(nodes, items){
        $.each(items, function(){
            var zNode = {};
            if(this.directory){
                zNode.type = 'parent';
            }else{
                zNode.icon = 'glyphicon glyphicon-list-alt'
            }
            this.title = this.fileName.length>20?this.fileName.substring(0,20)+"...":this.fileName;
            zNode.menu = this;
            if(this.children && this.children.length > 0){
                zNode.children = getChildrenData(new Array(), this.children);
            }
            nodes.push(zNode);
        });
        return nodes;
    };

    var loadindex=0;
	var showFolder = function(data){
        $("#rescurDir").val(data.data.name);
        if(loadindex>0){
        	 var grid = $('#resgrid');
        	 grid.data('koala.grid').urlrefresh(baseUrl+'list.koala?path='+data.data.name);
        }
        loadindex++;
	};
	
	var showTpl = function(data){
		console.log(data);
	};
	
	/*
	 删除方法
	 */
	var refresh = function(){
		 var path = $("#rescurDir").val()
		 var id = path.substring(path.lastIndexOf('/')+1);
		 var resTree = $('#resTree');
		 resTree.html("");
		 getTree(id);
	};
	
	
	var rename = function(data){
		var dialog = $('<div class="modal fade"><div class="modal-dialog">'
		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
		        	+'<h4 class="modal-title">重命名</h4></div><div class="modal-body">'
		        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
		        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
		        	+'</div></div>');
		 $.get('/pages/content/CmsDirOrFile-rename.jsp').done(function(html){
			 dialog.modal({
				 keyboard:false
			 }).on({
				 'hidden.bs.modal': function(){
					 $(this).remove();
				 }
			 }).find('.modal-body').html(html);
			 dialog.find('#snameID').val(data);
		 });
		 dialog.find('#save').on('click',function(e){
           if(!Validator.Validate(dialog.find('form')[0],3))return;
           $.post(baseUrl+'rename.koala?opath='+$("#rescurDir").val()+'/'+dialog.find("#snameID").val()+'&npath='+$("#rescurDir").val()+'/'+dialog.find("#nnameID").val()).done(function(result){
                if(result.success){
                     dialog.modal('hide');
                     var grid = $('#resgrid');
                     grid.data('koala.grid').refresh();
                     grid.message({
                         type: 'success',
                         content: '保存成功'
                     });
                     refresh();
                 }else{
                     dialog.find('.modal-content').message({
                         type: 'error',
                         content: result.actionError
                     });
                  }
           });
       });
     	
  	}
	
	var xiugai = function(data){
		 var dialog = $('<div class="modal fade"><div class="modal-dialog">'
		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
		        	+'<h4 class="modal-title">修改文件</h4></div><div class="modal-body">'
		        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
		        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
		        	+'</div></div>');
		 $.get('/pages/content/CmsFile-add.jsp').done(function(html){
			 dialog.find('.modal-body').html(html);
			 $.get( baseUrl+'/get.koala?path='+$("#rescurDir").val()+'/'+data).done(function(json){
                   json = json.data;
                   dialog.find("#content").val(json.source);
             });
			 dialog.modal({
				 keyboard:false
			 }).on({
				 'hidden.bs.modal': function(){
					 $(this).remove();
				 }
			 })
			 dialog.find("#fname").val(data);
			 dialog.find("#fname").attr("disabled",true);
			 dialog.find("#zhui").css("display","none");
		 });
		 dialog.find('#save').on('click', function(e){
             if(!Validator.Validate(dialog.find('form')[0],3))return;
             $.post(baseUrl+'addFile.koala?path='+$("#rescurDir").val()+'/'+dialog.find("#fname").val(),dialog.find('form').serialize()).done(function(result){
                  if(result.success){
                	  dialog.modal('hide');
                      var grid = $('#resgrid');
                      grid.data('koala.grid').refresh();
                      grid.message({
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
	}
	
	var viewimage = function(data){
		var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">查看图片</h4></div><div class="modal-body">'
	        	+'<p><img id="vm"/></p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'</div></div></div></div>');
		 var path = $("#rescurDir").val().substring($("#rescurDir").val().indexOf("WEB-INF"));
		 dialog.find('#vm').attr("src",contextPath+'/'+path+'/'+data);
		 dialog.modal({
			 keyboard:false
		 }).on({
			 'hidden.bs.modal': function(){
				 $(this).remove();
			 }
		 })
	}
	
	return {
		viewimage:viewimage,
		xiugai:xiugai,
		rename:rename,
		refresh:refresh,
		getTree: getTree
	};
};
