<%@ page contentType="text/html;charset=UTF-8" %>
<div class="panelBar" >
	<div class="pages">
		<span>显示</span>
		<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<option value="20" >20</option>
			<option value="50" <c:if test="${page.pageSize == 50 }">selected</c:if>>50</option>
			<option value="100" <c:if test="${page.pageSize == 100 }">selected</c:if>>100</option>
			<option value="200" <c:if test="${page.pageSize == 200 }">selected</c:if>>200</option>
			<option value="500" <c:if test="${page.pageSize == 500 }">selected</c:if>>500</option>
			<option value="1000" <c:if test="${page.pageSize == 1000 }">selected</c:if>>1000</option>
		</select>
		<span>条，共${page.totalRow }条</span>
	</div>
	<div class="pagination" targetType="navTab" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="10" currentPage="${page.pageNumber}"></div>
</div>