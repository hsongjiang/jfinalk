package com.cnksi.core.jfinal.creator.gen.service;

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

public class GenService
{

	private Config config = new Config();

	private static GenService instance;

	public static GenService newInstance(Config config)
	{

		if (instance == null)
		{
			instance = new GenService();

			if (config != null)
			{
				instance.setConfig(config);
			}
		}

		return instance;
	}

	/**
	 * 生产Service文件
	 * 
	 * @param projectName项目名称
	 */
	public String genService()
	{

		String director = "";

		List<TableInfo> tables = Jdbc.newInstance().getTableInfo(config);

		for (TableInfo table : tables)
		{
			Configuration cfg;

			try
			{
				cfg = new Configuration();

				cfg.setTemplateLoader(new ClassTemplateLoader(GenService.class, ""));

				cfg.setObjectWrapper(new DefaultObjectWrapper());

				Template template = cfg.getTemplate("/Service.tpl");

				Map<String, Object> model = table.getMaps();

				model.put("basePackage", config.groupid + "." + config.projectName);

				model.put("date", new Date());

				String content = FreeMarkers.renderTemplate(template, model);

				String className = model.get("className").toString();

				//Service 层分文件存放
				director = WriteFile.getPackagePath(config.projectName, config.genFolder);

				String filename = className + "Service.java";

				WriteFile.writeFile(director + "/service", filename, content);

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
