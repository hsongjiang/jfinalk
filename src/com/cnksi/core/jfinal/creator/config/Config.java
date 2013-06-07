package com.cnksi.core.jfinal.creator.config;

import java.util.Arrays;
import java.util.List;

public class Config
{

	public String projectName = "web";

	// 当前工程目录
	public String genFolder = "D:/gen";

	public String groupid = "com.cnksi";

	//是否自动生成Excel注解@Description
	public boolean xlsAnnotation = true;

	//是否在Controller上生成@RequiresPermissions
	public boolean shiroControllerAnnotation = true;

	//是否在页面中生成Shiro权限控制【<shiro:hasPermission>】
	public boolean shiroPageAnnotation = true;

	//忽略生成
	String[] ignoreTableName = new String[]{"enumeration", "enumerationvalue", "shiro_authority", "shiro_authority_menu", "shiro_authority_operation", "shiro_menu", "shiro_operation", "shiro_role", "shiro_role_authority", "shiro_user", "shiro_user_role"};
	public List<String> ignoreTable = Arrays.asList(ignoreTableName);

	public String ignoreFields = "createtime,lastmodifytime,creater,valid,version";

	public String tablePrefix = "shiro_";

	public Config()
	{

	}

	public Config(String projectName)
	{
		this.projectName = projectName;
	}

	/**
	 * 
	 * 如果不需要生成权限相关的SQL代码，请传入要忽略掉的tableName
	 * 
	 * @param tableName tableName
	 */
	public void addIngnorTable(String tableName)
	{

		ignoreTable.add(tableName.toLowerCase());
	}

	/**
	 * 要生成的项目名称
	 * 
	 * @return
	 */
	public String getProjectName()
	{

		return projectName;
	}

	/**
	 * 项目生成的目标路径
	 *
	 * @return
	 */
	public String getGenFolder()
	{

		return genFolder;
	}

	/**
	 * 项目GroupID,如 com.cnksi
	 * 
	 * @return
	 */
	public String getGroupid()
	{

		return groupid;
	}

	/**
	 * 是否在Entity上生成@Description注解,用于描述Excel表头
	 * 
	 * @return
	 */
	public boolean isXlsAnnotation()
	{

		return xlsAnnotation;
	}

	/**
	 * 是否在Controller层Action中生成@RequirePressiom注解
	 * @return
	 */
	public boolean isShiroControllerAnnotation()
	{

		return shiroControllerAnnotation;
	}

	/**
	 * 是否在jsp页面生成<shiro:> 标签 
	 * @return
	 */
	public boolean isShiroPageAnnotation()
	{

		return shiroPageAnnotation;
	}

	/**
	 * 设置工具当前生成的项目名称 
	 * @param projectName 如：quickstart
	 */
	public void setProjectName(String projectName)
	{

		this.projectName = projectName;
	}

	/**
	 * 设定生成的文件路径
	 * @param genFolder 如:d:/gen
	 */
	public void setGenFolder(String genFolder)
	{

		this.genFolder = genFolder;
	}

	/**
	 * 是否在Entity上生成@Description注解,用于描述Excel表头
	 * 
	 * @param xlsAnnotation
	 */
	public void setXlsAnnotation(boolean xlsAnnotation)
	{

		this.xlsAnnotation = xlsAnnotation;
	}

	/**
	 * 是否在Controller层Action中生成@RequirePressiom注解
	 * 
	 * @param shiroControllerAnnotation
	 */
	public void setShiroControllerAnnotation(boolean shiroControllerAnnotation)
	{

		this.shiroControllerAnnotation = shiroControllerAnnotation;
	}

	/**
	 *  是否在jsp页面生成<shiro:> 标签 
	 * @param shiroPageAnnotation
	 */
	public void setShiroPageAnnotation(boolean shiroPageAnnotation)
	{

		this.shiroPageAnnotation = shiroPageAnnotation;
	}

	public String getIgnoreFields()
	{
		return ignoreFields;
	}

	public void setIgnoreFields(String ignoreFields)
	{
		this.ignoreFields += ignoreFields;
	}

	public String getTablePrefix()
	{
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix)
	{
		this.tablePrefix = tablePrefix;
	}

}
