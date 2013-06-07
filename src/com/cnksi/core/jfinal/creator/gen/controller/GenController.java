package com.cnksi.core.jfinal.creator.gen.controller;

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

public class GenController
{

	private Config config = new Config();

	private static GenController instance;

	public static GenController newInstance(Config config)
	{

		if (instance == null)
		{
			instance = new GenController();

			if (config != null)
			{
				instance.setConfig(config);
			}
		}

		return instance;
	}

	/**
	 * 生产Controller文件
	 * 
	 * @param projectName项目名称
	 */
	public String genController()
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
				cfg = new Configuration();

				cfg.setTemplateLoader(new ClassTemplateLoader(GenController.class, ""));

				cfg.setObjectWrapper(new DefaultObjectWrapper());

				Template template = cfg.getTemplate("/Controller.tpl");

				Map<String, Object> model = table.getMaps();

				model.put("basePackage", config.groupid + "." + config.projectName);

				model.put("date", new Date());

				model.put("config", config);

				String content = FreeMarkers.renderTemplate(template, model);

				String className = model.get("className").toString();

				director = WriteFile.getPackagePath(config.projectName, config.genFolder);

				String filename = className + "Controller.java";

				WriteFile.writeFile(director + "/controller", filename, content);

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
