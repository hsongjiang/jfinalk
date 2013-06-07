package com.cnksi.core.jfinal.creator.jdbc.meta;

import com.jfinal.kit.StringKit;

public class TypeConvert
{

	private static final String STRING_CONSTANT = "char,varchar,longtext,longblob,mediumblob,mediumtext,text,tinytext";

	private static final String INTETER_CONSTANT = "int,bit,bool,boolean,smallint,tinyint";

	private static final String LONG_CONSTANT = "bigint,mediumint";

	private static final String FLOAT_CONSTANT = "decimal,float";

	private static final String DOUBLE_CONSTANT = "double,numeric";

	private static final String DATE_CONSTANT = "date,datetime,timestamp";

	/**
	 * 从数据库类型中获取Java类属性字段
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static String getJavaTypeFromJdbcType(String jdbcType)
	{

		if (jdbcType != null)
		{
			jdbcType = jdbcType.indexOf("(") > 0 ? jdbcType.substring(0, jdbcType.indexOf("(")) : jdbcType;

			if (STRING_CONSTANT.contains(jdbcType))
			{
				return "String";

			} else if (INTETER_CONSTANT.contains(jdbcType))
			{
				return "Integer";
			} else if (LONG_CONSTANT.contains(jdbcType))
			{
				return "Long";
			} else if (FLOAT_CONSTANT.contains(jdbcType))
			{
				return "Float";
			} else if (DOUBLE_CONSTANT.contains(jdbcType))
			{
				return "Double";
			} else if (DATE_CONSTANT.contains(jdbcType))
			{
				return "Date";
			}

		}

		return "";

	}

	/**
	 * 从数据库类型中获取字段长度
	 * 
	 * @param jdbcType
	 * @return
	 */
	public static Integer getJavaFieldLengthFromJdbcType(String jdbcType)
	{

		Integer length = 0;

		if (jdbcType != null)
		{
			jdbcType = jdbcType.indexOf("(") > 0 ? jdbcType.substring(jdbcType.indexOf("("), jdbcType.indexOf(")")) : jdbcType;
		}

		try
		{
			length = Integer.parseInt(jdbcType);

		} catch (Exception ex)
		{
			length = 0;
		}

		return length;

	}

	/**
	 * 处理Java类中的默认值
	 * 
	 * @param defaultValue数据库中的默认值
	 * 
	 * @return
	 */
	public static String getJavaFieldDefaultValue(String defaultValue)
	{

		if (("CURRENT_TIMESTAMP").equals(defaultValue))
		{
			return "new Date()";
		} else if (defaultValue != null)
		{
			try
			{
				Integer.parseInt(defaultValue);

				return defaultValue;

			} catch (NumberFormatException ex)
			{
				return "\"" + defaultValue + "\"";
			}
		}

		return defaultValue;
	}

	/**
	 * 处理jdbc TableName 获取Java类名称， 去除前缀，按照单词首字母大写命名
	 * 
	 * @param prefix
	 *            表前缀
	 * @param jdbcTableName
	 *            表名
	 * @return
	 */
	public static String getJavaClassNameFromJdbcTableName(String prefix, String jdbcTableName)
	{

		String javaClassName = "";
		String[] _prefixs = prefix.split(",");

		for (String _prefix : _prefixs)
		{
			// 去掉前缀
			jdbcTableName = jdbcTableName.startsWith(prefix) ? jdbcTableName.replaceFirst(_prefix, "") : jdbcTableName;

		}
		String[] nameblocks = jdbcTableName.split("_");

		for (String nameblock : nameblocks)
		{
			javaClassName += StringKit.firstCharToUpperCase(nameblock);
		}

		return javaClassName;
	}
}
