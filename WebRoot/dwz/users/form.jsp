<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
   
<div class="pageContent">
	<form method="post" action="${ctx}/${modelName}/${action}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		
		<input type="hidden" name="${modelName }.id" value="${record.id}"/>
		
		<div class="pageFormContent" layoutH="56">
			 <dl>
				<dt>资姓名姓名：</dt>
				<dd><input type="text" id="name" name="${modelName }.name" class="required" value="${record.name}" /></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
