<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="modal fade select-role">
	<style>
		.select-role .modal-body {
			height: 560px;
		}
		.select-role .grid-table-body {
			height: 250px;
		}
		.select-role .modal-dialog {
			width: 850px;
		}
	</style>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title">分配站点资源</h4>
			</div>
			<div class="modal-body" style="padding-left:45px; padding-right:65px;">
                <!--form id=“selectPageFrom” target="_self" class="form-inline searchCondition">
                    <div class="panel">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label class="control-label">站点名称:&nbsp;</label>
                                        <input name="sitename" class="form-control" type="text"/>
                                    </div>
                                </td>
                                <td style="vertical-align: bottom; padding: 0 5px;" >
                                    <button id="selectSitesearch" type="button" class="btn btn-success"><span class="glyphicon glyphicon-search"></span>&nbsp;</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form-->
				<div id="selectSiteGrid" data-role="selectSiteGrid"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-success" id="save">保存</button>
			</div>
		</div>
	</div>
</div>