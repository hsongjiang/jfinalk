<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
   
<div class="pageContent">
	<form method="post" action="<#noparse>$</#noparse>{ctx}/<#noparse>$</#noparse>{modelName}/<#noparse>$</#noparse>{action}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		
		<input type="hidden" name="<#noparse>$</#noparse>{modelName }.${pkFieldInfo.field}" value="<#noparse>$</#noparse>{record.${pkFieldInfo.field}}"/>
		
		<div class="pageFormContent" layoutH="56">
			<#list records as rec>
			<#if !(config.ignoreFields?contains(rec.field) || rec.pk =='PRI')>
			<p>
				<label>${rec.comment}：</label>
				<input type="text" id="${rec.field}" name="<#noparse>$</#noparse>{modelName }.${rec.field}" value="<#noparse>$</#noparse>{record.${rec.field}}"/>
			</p>
			</#if>
			</#list>
			 
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
