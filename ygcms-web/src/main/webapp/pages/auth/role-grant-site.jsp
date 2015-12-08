<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<%@include file="/commons/site-condition.jsp"%>

<div data-role="roleGrantSiteGrid"></div>
<script>
$(function() {
    var role = $('.tab-pane.active').data();
    var roleId = role ? role.pageId : null;

    var columns = [{
        title 	: "站点名称",
        name 	: "1",
        width 	: 200
    },{
        title 	: "简称",
        name 	: "2",
        width 	: 400
    },{
        title 	: "域名",
        name 	: "3",
        width 	: 200
    }];

    var getButtons = function () {
        return [
            {
                content: '<ks:hasSecurityResource identifier="roleManagerGrantSiteAccessResource"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-th-large"/>&nbsp;分配站点</button></ks:hasSecurityResource>',
                action: 'assignSite'
            }, {
                content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove" />&nbsp;撤销站点</button>',
                action: 'removeSiteFromRole'
            }, {
                content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-search" />&nbsp;高级搜索&nbsp;<span class="caret" /></button>',
                action: 'siteAccessResourceManagerQuery'
            }
        ];
    };
    

    url = contextPath + '/auth/role/pagingQueryGrantSiteResourcesByRoleId.koala' + '?roleId=' + roleId;

    $('[data-role="roleGrantSiteGrid"]').grid({
        identity : '0',
        columns : columns,
        buttons : getButtons(),
        url : url
    }).on({
        "assignSite" : function(event, data){
            var grid = $(this);
            $.get(contextPath + '/pages/auth/site-select.jsp').done(function(data){
                var dialog = $(data);

                dialog.find('#selectSitesearch').on('click', function(){
                    var params = {};
                    dialog.find('.form-control').each(function(){
                        var $this = $(this);
                        var name = $this.attr('name');
                        if(name){
                            params[name] = $this.val();
                        }
                    });
                    $('[data-role="selectSiteGrid"]').getGrid().search(params);
                });

                dialog.find('#save').click(function(){
                    var $saveBtn = $(this);
                    var items = dialog.find('#selectSiteGrid').data('koala.grid').selectedRows();
                    if(items.length == 0){
                        dialog.find('#selectSiteGrid').message({
                            type: 'warning',
                            content: '请选择要分配的站点'
                        });
                        return;
                    }

                    $saveBtn.attr('disabled', 'disabled');
                    var data = "roleId="+roleId;
                  
                    for(var i=0,j=items.length; i<j; i++){
                        data += "&siteResourceIds="+items[i][0];
                    }
                    $.post(contextPath + '/auth/role/grantSiteResourcesToRole.koala', data).done(function(data){
                        grid.message({
                            type: 'success',
                            content: '保存成功'
                        });
                        dialog.modal('hide');
                        grid.grid('refresh');
                    }).fail(function(data){
                        $saveBtn.attr('disabled', 'disabled');
                        grid.message({
                            type: 'error',
                            content: '保存失败'
                        });
                    });
                }).end().modal({
                    keyboard: false
                }).on({
                    'hidden.bs.modal': function(){
                        $(this).remove();
                    },

                    'shown.bs.modal': function(){ //弹窗初始化完毕后，初始化url选择表格
                        var columns = [{
                            title 	: "站点名称",
                            name 	: "1",
                            width 	: 200
                        },{
                            title 	: "简称",
                            name 	: "2",
                            width 	: 200
                        },{
                            title 	: "域名",
                            name 	: "3",
                            width 	: 200
                        }];

                        dialog.find('#selectSiteGrid').grid({
                            identity: '0',
                            columns: columns,
                            url: contextPath + '/auth/role/pagingQueryNotGrantSiteResourcesByRoleId.koala?roleId=' + roleId
                        });
                    },

                    'complete': function(){
                        grid.message({
                            type: 'success',
                            content: '保存成功'
                        });
                        $(this).modal('hide');
                        grid.grid('refresh');
                    }
                });
                //兼容IE8 IE9
                if(window.ActiveXObject){
                    if(parseInt(navigator.userAgent.toLowerCase().match(/msie ([\d.]+)/)[1]) < 10){
                        dialog.trigger('shown.bs.modal')
                    }
                }
            });
        },
        'siteAccessResourceManagerQuery' : function() {
            $('#'+'${formId}'+"_div").slideToggle("slow");
        },
        "removeSiteFromRole" : function(event, data){ //解除授予
            var indexs = data.data;
            var grid = $(this);
            if (indexs.length == 0) {
                grid.message({
                    type : 'warning',
                    content : '请选择要删除的记录'
                });
                return;
            }
            grid.confirm({
                content : '确定要删除所选记录吗?',
                callBack : function() {
                    var url = contextPath + '/auth/role/terminateSiteResourcesFromRole.koala';
                    var params = "roleId="+roleId;
                    for (var i = 0, j = data.item.length; i < j; i++) {
                        params += ("&siteResourceIds=" + data.item[i][0]);
                    }

                    $.post(url, params).done(function(data) {
                        grid.message({
                            type : 'success',
                            content : '删除成功'
                        });
                        grid.grid('refresh');
                    }).fail(function(data) {
                        grid.message({
                            type : 'error',
                            content : '删除失败'
                        });
                    });
                }
            });
        }
    });

    var form = $('#'+'${formId}');
    form.find('#siteManagerSearch').on('click', function(){
        var params = {};
        form.find('.form-control').each(function(){
            var $this = $(this);
            var name = $this.attr('name');
            if(name){
                params[name] = $this.val();
            }
        });
        $('[data-role="roleGrantSiteGrid"]').getGrid().search(params);
    });

});
</script>