package com.cnksi.core.utils;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import com.jfinal.kit.StringKit;

public class WebUtils
{
	/**
	 * 取得带相同前缀的Request Parameters
	 * 
	 *  返回的结果的Parameter名已去除前缀.
	 *  
	 * @param request
	 * 
	 * @param prefix 
	 *  
	 * @return
	 */
	public static List<SearchFilter> getParametersStartingWith(ServletRequest request)
	{
		return SearchFilter.parse(getParametersStartingWith(request, "search_"));
	}

	public static Map<String, String> getParametersStartingWith(ServletRequest request, String prefix)
	{
		Enumeration<String> paramNames = request.getParameterNames();
		Map<String, String> params = new HashMap<String, String>();
		if (prefix == null)
		{
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements())
		{
			String paramName = (String) paramNames.nextElement();
			if (paramName.startsWith(prefix))
			{
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0)
				{
				} else
				{
					params.put(unprefixed, iso2utf(values[0]));
				}
				request.setAttribute(paramName.replace(".", ""), iso2utf(values[0]));
			}
		}

		return params;
	}

	/**
	 * iso8859-1转化为utf-8编码
	 * 
	 * @param str
	 * @return
	 */
	public static String iso2utf(String str)
	{

		String result = StringKit.stripToEmpty(str);
		try
		{
			result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
