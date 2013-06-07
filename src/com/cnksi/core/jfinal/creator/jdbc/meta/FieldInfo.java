
package com.cnksi.core.jfinal.creator.jdbc.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * 記錄数据表的字段信息
 * 
 * @author dell
 * 
 */
public class FieldInfo
{

	// 字段名称
	private String field;

	// 字段类型
	private String type;

	// 是否允许空
	private String nul;

	// 字段备注
	private String comment;

	// 字段默认值
	private String defaultValue;

	// 主键
	private String pk;

	public FieldInfo()
	{

	}

	public FieldInfo(String field, String type, String nul, String comment, String defaultValue, String pk)
	{

		this.field = field;
		this.type = type;
		this.nul = nul;
		this.comment = comment;
		this.defaultValue = defaultValue;
		this.pk = pk;
	}

	public Map<String, Object> getMaps()
	{

		Map<String, Object> modelMap = new HashMap<String,Object>();

		modelMap.put("field", field.toLowerCase());

		modelMap.put("type", TypeConvert.getJavaTypeFromJdbcType(type));

		modelMap.put("length", TypeConvert.getJavaFieldLengthFromJdbcType(type));

		modelMap.put("comment", comment);

		modelMap.put("nul", nul);

		modelMap.put("defaultValue", TypeConvert.getJavaFieldDefaultValue(defaultValue));

		modelMap.put("pk", pk);

		return modelMap;
	}

	public String getField()
	{

		return field;
	}

	public void setField(String field)
	{

		this.field = field;
	}

	public String getType()
	{

		return type;
	}

	public void setType(String type)
	{

		this.type = type;
	}

	public String getNul()
	{

		return nul;
	}

	public void setNul(String nul)
	{

		this.nul = nul;
	}

	public String getComment()
	{

		return comment;
	}

	public void setComment(String comment)
	{

		this.comment = comment;
	}

	public String getDefaultValue()
	{

		return defaultValue;
	}

	public void setDefaultValue(String defaultValue)
	{

		this.defaultValue = defaultValue;
	}

	public String getPk()
	{

		return pk;
	}

	public void setPk(String pk)
	{

		this.pk = pk;
	}

}
