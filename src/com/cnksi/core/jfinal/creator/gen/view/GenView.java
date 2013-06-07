package com.cnksi.core.jfinal.creator.gen.view;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cnksi.core.jfinal.creator.config.Config;
import com.cnksi.core.jfinal.creator.jdbc.Jdbc;
import com.cnksi.core.jfinal.creator.jdbc.meta.TableInfo;
import com.cnksi.core.jfinal.creator.utils.FreeMarkers;
import com.cnksi.core.jfinal.creator.utils.WriteFile;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class GenView
{

	private Config config = new Config();

	private static GenView instance;

	public static GenView newInstance(Config config)
	{

		if (instance == null)
		{
			instance = new GenView();

			if (config != null)
			{
				instance.setConfig(config);
			}
		}

		return instance;
	}

	/**
	 * 生产View LIST,FORM文件
	 * 
	 * @param projectName项目名称
	 */
	public String genView()
	{

		String director = "";

		List<TableInfo> tables = Jdbc.newInstance().getTableInfo(config);

		for (TableInfo table : tables)
		{
			if (table.getPkFieldInfo() == null)
			{
				continue;
			}

			Configuration cfg;

			try
			{

				Map<String, Object> model = table.getMaps();

				model.put("basePackage", config.groupid + "." + config.projectName);

				model.put("date", new Date());

				model.put("config", config);

				cfg = new Configuration();

				cfg.setTemplateLoader(new ClassTemplateLoader(GenView.class, ""));

				cfg.setObjectWrapper(new DefaultObjectWrapper());

				Template template = cfg.getTemplate("/List.tpl");

				String content = FreeMarkers.renderTemplate(template, model);

				String className = model.get("className").toString();

				//JSP 层分文件存放
				director = WriteFile.getPackagePath(config.projectName, config.genFolder) + "\\views";

				String filename = "list.jsp";

				WriteFile.writeFile(director + "/" + className.toLowerCase(), filename, content);

				/*----------------------------------  create form.jsp -----------------------------------------------*/

				Template templateForm = cfg.getTemplate("/Form.tpl");

				//JSP 层分文件存放
				director = WriteFile.getPackagePath(config.projectName, config.genFolder) + "\\views";

				String filenameForm = "form.jsp";

				String contentForm = FreeMarkers.renderTemplate(templateForm, model);

				WriteFile.writeFile(director + "/" + className.toLowerCase(), filenameForm, contentForm);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		return director;
	}

	public Config getConfig()
	{

		return config;
	}

	public void setConfig(Config config)
	{

		this.config = config;
	}

}
