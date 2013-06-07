package com.cnksi.core.jfinal.creator.jdbc.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cnksi.core.jfinal.creator.config.Config;

/**
 * 記錄数据库中表信息
 * 
 * @author dell
 * 
 */
public class TableInfo
{

	// 表名
	private String tableName;

	// 数据库对应的Java类名
	private String className;

	// 表备注信息
	private String comment;

	// 记录表中的所有字段信息
	private List<Object> fields;

	//主键字段
	private FieldInfo pkFieldInfo;

	private Config config = null;

	public TableInfo()
	{

	}

	public Map<String, Object> getMaps()
	{

		config = new Config();

		Map<String, Object> modelMap = new HashMap<String, Object>();

		modelMap.put("tableName", tableName);

		modelMap.put("className", TypeConvert.getJavaClassNameFromJdbcTableName(config.getTablePrefix(), tableName));

		modelMap.put("comment", comment);

		modelMap.put("records", fields);

		if (pkFieldInfo != null)
		{
			modelMap.put("pkFieldInfo", pkFieldInfo.getMaps());
		}

		return modelMap;
	}

	public TableInfo(String tableName, String comment, List<Object> fields)
	{

		this.tableName = tableName;

		this.comment = comment;

		this.fields = fields;
	}

	public TableInfo(String tableName, String comment)
	{

		this.tableName = tableName;

		this.comment = comment;
	}

	public String getTableName()
	{

		return tableName;
	}

	public void setTableName(String tableName)
	{

		this.tableName = tableName;
	}

	public String getClassName()
	{

		className = TypeConvert.getJavaClassNameFromJdbcTableName("tbl_", tableName);

		return className;
	}

	public void setClassName(String className)
	{

		this.className = className;
	}

	public String getComment()
	{

		return comment;
	}

	public void setComment(String comment)
	{

		this.comment = comment;
	}

	public List<Object> getFields()
	{

		return fields;
	}

	public void setFields(List<Object> fields)
	{

		this.fields = fields;
	}

	public FieldInfo getPkFieldInfo()
	{

		return pkFieldInfo;
	}

	public void setPkFieldInfo(FieldInfo pkFieldInfo)
	{

		this.pkFieldInfo = pkFieldInfo;
	}

}
