package com.cnksi.core.jfinal.creator.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnksi.core.jfinal.creator.config.Config;
import com.cnksi.core.jfinal.creator.jdbc.meta.FieldInfo;
import com.cnksi.core.jfinal.creator.jdbc.meta.TableInfo;

/**
 * JDBC类，用于获取指定数据库中，表的metadata信息，工具，自动生成Entity
 * 
 * @author dell
 * 
 */
public class Jdbc
{

	private static Jdbc jdbc = null;

	private static Logger logger = LoggerFactory.getLogger(Jdbc.class);

	// 获取MYSQL数据库表信息
	private static final String MYSQL_SETELCT_SCHEMA = "SHOW TABLE STATUS";

	// 获取MYSQL具体表的字段信息
	private static final String MYSQL_SELECT_TABLE_INFO = "SHOW FULL FIELDS FROM ";

	// 数据库名称
	private static String driver = "com.mysql.jdbc.Driver";

	// 用户名称
	private String username = "root";

	// 用户密码
	private String userpwd = "root";

	// 数据库连接URL
	private String driverUrl = "";

	static
	{
		try
		{
			Class.forName(driver);
		} catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

	}

	public static Jdbc newInstance()
	{

		if (jdbc == null)
		{
			jdbc = new Jdbc();
		}

		return jdbc;
	}

	private Jdbc()
	{

		Properties p = new PropertiesLoader("classpath:/appconfig.txt").getProperties();

		username = p.getProperty("user");

		userpwd = p.getProperty("password");

		driver = p.getProperty("driver");

		driverUrl = p.getProperty("jdbcUrl");

	}

	/**
	 * 获取数据库 所有表及字段信息
	 * 
	 * @return
	 */
	public List<TableInfo> getTableInfo(Config config)
	{

		List<TableInfo> tables = new ArrayList<TableInfo>();

		try
		{
			Connection conn = DriverManager.getConnection(driverUrl, username, userpwd);

			PreparedStatement pstmt = conn.prepareStatement(MYSQL_SETELCT_SCHEMA);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				String name = rs.getString("name");

				if (config != null)
				{
					if (!config.ignoreTable.contains(name))
					{
						String comment = rs.getString("comment");

						TableInfo tableInfo = new TableInfo(name, comment);

						tableInfo.setFields(getFieldInfo(name, tableInfo));

						tables.add(tableInfo);
					}
				}
			}

			rs.close();

			pstmt.close();

			conn.close();

		} catch (Exception ex)
		{
			logger.error(ex.getMessage());
		}

		return tables;

	}

	/**
	 * 获取表中的所有字段信息
	 * 
	 * @param tableName数据库表名
	 * 
	 * @return
	 */
	private List<Object> getFieldInfo(String tableName, TableInfo tableInfo)
	{

		List<Object> fieldMap = new ArrayList<Object>();

		try
		{
			Connection conn = DriverManager.getConnection(driverUrl, username, userpwd);

			PreparedStatement pstmt = conn.prepareStatement(MYSQL_SELECT_TABLE_INFO + " " + tableName);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				FieldInfo fieldInfo = new FieldInfo(rs.getString("field"), rs.getString("type"), rs.getString("null"), rs.getString("comment"), rs.getString("default"), rs.getString("key"));

				if (fieldInfo.getPk().equals("PRI"))
				{
					tableInfo.setPkFieldInfo(fieldInfo);
				}

				fieldMap.add(fieldInfo.getMaps());
			}

			rs.close();

			pstmt.close();

			conn.close();

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return fieldMap;
	}
}
