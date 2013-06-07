
package com.cnksi.core.jfinal.creator.utils;

import java.io.StringWriter;

import freemarker.template.Template;

public class FreeMarkers
{
	/**
	 * 渲染Template文件.
	 */
	public static String renderTemplate(Template template, Object model)
	{

		try
		{
			StringWriter result = new StringWriter();
			template.process(model, result);
			return result.toString();
		} catch (Exception e)
		{
			return e.getMessage();
		}
	}
}
