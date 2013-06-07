package com.cnksi.core.jfinal.creator.gen.domain;

/**
 * 
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(500,NULL,'用户管理'，'user:*');
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(501,500,'读取用户'，'user:read');
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(502,500,'新增用户'，'user:create');
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(503,500,'删除用户'，'user:delete');
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(504,500,'编辑用户'，'user:edit');
 * INSERT INTO security_operation(id,pid,operanmae,operacode) VALUES(505,500,'导出用户Excel'，'user:export-xls');
 * 
 * @author dell
 *
 */

public class GenDBSQL
{

	static int start = 100;

	static int pstart = 100;

	public static String genSQL(String entityName, String tableComment)
	{

		StringBuilder sbuilder = new StringBuilder();

		String p_opera = String.format("INSERT INTO security_menu VALUES(%s,NULL,'%s管理','/%s/list',1,'navTab','%s-list','creater',NOW(),NOW(),1,0);", start, tableComment, entityName.toLowerCase(), entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,pauthorityid,authorityname,authoritytype,creater,createtime,lastmodifytime,valid,VERSION) VALUES(%s,NULL,'%s管理','MENU','creater',NOW(),NOW(),1,0);", start, tableComment);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_menu(menuid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		pstart++;

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,NULL,'%s管理','%s:*');", start, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityid,authorityname,authoritytype,pauthorityid) VALUES(%s,'%s管理','OPERATION',NULL);", start, tableComment);
		sbuilder.append(p_opera);

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,%s,'读取%s','%s:read');", start, pstart, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityname,authoritytype,pauthorityid) VALUES(%s,'读取%s','OPERATION',%s);", start, tableComment, pstart);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,%s,'新增%s','%s:create');", start, pstart, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityname,authoritytype,pauthorityid) VALUES(%s,'新增%s','OPERATION',%s);", start, tableComment, pstart);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,%s,'删除%s','%s:delete');", start, pstart, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityname,authoritytype,pauthorityid) VALUES(%s,'删除%s','OPERATION',%s);", start, tableComment, pstart);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,%s,'修改%s','%s:edit');", start, pstart, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityname,authoritytype,pauthorityid) VALUES(%s,'修改%s','OPERATION',%s);", start, tableComment, pstart);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		p_opera = String.format("INSERT INTO security_operation(id,pid,operaname,operacode) VALUES(%s,%s,'导出%sExcel','%s:export-xls');", start, pstart, tableComment, entityName.toLowerCase());
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority(id,authorityname,authoritytype,pauthorityid) VALUES(%s,'导出%sExcel','OPERATION',%s);", start, tableComment, pstart);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		p_opera = String.format("INSERT INTO security_authority_operation(operid,authorityid) VALUES(%s,%s);", start, start);
		sbuilder.append(p_opera);
		sbuilder.append("\n");

		start++;

		pstart = start;

		return sbuilder.toString();
	}

	public static void main(String[] args)
	{

		GenDBSQL.genSQL("User", "用户");
	}
}
