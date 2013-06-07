<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form id="pagerForm" method="post" action="users/index">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>
<div class="pageHeader">
	<form  rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx }/users/index" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					编号：<y:search fieldList="id" matchType="EQ"/>
					姓名：<y:search fieldList="name" matchType="EQ"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			 
			<li><a class="add" href="${ctx }/${modelName}/create" target="dialog" ><span>添加</span></a></li>
			
			<li><a class="delete" href="${ctx }/${modelName}/delete?id={sid}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
			
			<li><a class="edit" href="${ctx }/${modelName}/update?id={sid}" target="dialog" warn="请选择一条记录"><span>修改</span></a></li>
			
			<li class="line">line</li>
			
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="${ctx }/${modelName }/deletes" class="delete"><span>批量删除</span></a></li>
			
			<li class="line">line</li>
			
			<li><a class="icon" href="${ctx }/users/xls" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li><a class="icon" href="javascript:$.printBox('w_list_print')"><span>打印</span></a></li>
			
		</ul>
	</div>
	
	<div layoutH="116" id="w_list_print">
	<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
					<th  orderField="id" <c:if test="${orderField=='id' }">class="${orderDirection }"</c:if>>编号</th>
					<th  orderField="name" <c:if test="${orderField=='name' }">class="${orderDirection }"</c:if>>姓名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list }" var="record">
			<tr target="sid" rel="${record.id }">
				<td><input name="ids" value="${record.id}" type="checkbox"></td>
				<td>${record.id }</td>
				<td>${record.name }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<%@ include file="/common/pager_dwz.jsp" %>
</div>
