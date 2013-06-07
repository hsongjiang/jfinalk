package com.cnksi.core.taglibs;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cnksi.core.utils.SearchFilter;
import com.cnksi.core.utils.SearchFilter.Operator;
import com.jfinal.kit.StringKit;

public class SearchTag extends TagSupport
{
	private static final long serialVersionUID = 1L;

	private String idName;
	private String className;
	private String styleText;
	private String matchType;
	private String fieldList;

	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			Enum.valueOf(Operator.class, matchType);
		} catch (Exception e)
		{
			throw new IllegalArgumentException("filter名称" + matchType + "没有按规则编写,无法得到属性比较类型.", e);
		}

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException
	{

		ServletRequest request = pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		try
		{
			//filter_LIKES_name_OR_email
			String name = "search_" + matchType + "_" + fieldList.replaceAll(",", SearchFilter.OR);
			String value = StringKit.iso2utf(request.getParameter(name));
			String idCode = (idName != null && !"".equals(idName)) ? "id=\"" + idName + "\"" : "";
			String classCode = (className != null && !"".equals(className)) ? "class=\"" + className + "\"" : "";
			String styleCode = (styleText != null && !"".equals(styleText)) ? "style=\"" + styleText + "\"" : "";
			String html = "<input type=\"text\" " + idCode + " name=\"" + name + "\" value=\"" + value + "\" " + classCode + " " + styleCode + "/>";
			out.write(html);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getMatchType()
	{
		return matchType;
	}

	public void setMatchType(String matchType)
	{
		this.matchType = matchType.toUpperCase();
	}

	public String getFieldList()
	{
		return fieldList;
	}

	public void setFieldList(String fieldList)
	{
		this.fieldList = fieldList;
	}

	public String getIdName()
	{
		return idName;
	}

	public void setIdName(String idName)
	{
		this.idName = idName;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getStyleText()
	{
		return styleText;
	}

	public void setStyleText(String styleText)
	{
		this.styleText = styleText;
	}

}
