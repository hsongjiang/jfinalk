<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<form id="pagerForm" method="post" action="${className?lower_case}/index">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="<#noparse>$</#noparse>{page.pageSize}" />
	<input type="hidden" name="orderField" value="<#noparse>$</#noparse>{orderField}" />
	<input type="hidden" name="orderDirection" value="<#noparse>$</#noparse>{orderDirection}" />
</form>
<div class="pageHeader">
	<form  rel="pagerForm" onsubmit="return navTabSearch(this);" action="<#noparse>$</#noparse>{ctx }/${className?lower_case}/index" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
				<#list records as rec>
					${rec.comment}：<y:search fieldList="${rec.field}" matchType="EQ"/>
				</#list>
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
			 
			<li><a class="add" href="<#noparse>$</#noparse>{ctx }/<#noparse>$</#noparse>{modelName}/create" target="dialog" ><span>添加</span></a></li>
			
			<li><a class="delete" href="<#noparse>$</#noparse>{ctx }/<#noparse>$</#noparse>{modelName}/delete?id={sid}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
			
			<li><a class="edit" href="<#noparse>$</#noparse>{ctx }/<#noparse>$</#noparse>{modelName}/update?id={sid}" target="dialog" warn="请选择一条记录"><span>修改</span></a></li>
			
			<li class="line">line</li>
			
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="<#noparse>$</#noparse>{ctx }/<#noparse>$</#noparse>{modelName }/deletes" class="delete"><span>批量删除</span></a></li>
			
			<li class="line">line</li>
			
			<li><a class="icon" href="<#noparse>$</#noparse>{ctx }/${className?lower_case}/export/xls" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li><a class="icon" href="javascript:$.printBox('w_list_print')"><span>打印</span></a></li>
			
		</ul>
	</div>
	
	<div layoutH="116" id="w_list_print">
	<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<#list records as rec>
					<th  orderField="${rec.field}" <c:if test="<#noparse>$</#noparse>{orderField=='${rec.field}' }">class="<#noparse>$</#noparse>{orderDirection }"</c:if>>${rec.comment}</th>
				</#list>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="<#noparse>$</#noparse>{page.list }" var="record">
			<tr target="sid" rel="<#noparse>$</#noparse>{record.${pkFieldInfo.field} }">
				<td><input name="ids" value="<#noparse>$</#noparse>{record.${pkFieldInfo.field}}" type="checkbox"></td>
				<#list records as rec>
				<td><#noparse>$</#noparse>{record.${rec.field} }</td>
				</#list>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<%@ include file="/common/pager_dwz.jsp" %>
</div>
