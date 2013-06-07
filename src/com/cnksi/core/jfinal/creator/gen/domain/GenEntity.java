package com.cnksi.core.jfinal.creator.gen.domain;

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

public class GenEntity
{

	private Config config = new Config();

	private static GenEntity instance;

	public static GenEntity newInstance(Config config)
	{

		if (instance == null)
		{
			instance = new GenEntity();

			if (config != null)
			{
				instance.setConfig(config);
			}
		}

		return instance;
	}

	/**
	 * 生产Entity文件
	 * 
	 * @param projectName项目名称
	 * 
	 * @return 文件生成的目录
	 */
	public String genEntity()
	{

		String director = "";

		List<TableInfo> tables = Jdbc.newInstance().getTableInfo(config);

		Configuration cfg = new Configuration();

		cfg.setTemplateLoader(new ClassTemplateLoader(GenEntity.class, ""));

		cfg.setObjectWrapper(new DefaultObjectWrapper());

		for (TableInfo table : tables)
		{

			try
			{
				Template template = cfg.getTemplate("/Entity.tpl");

				Map<String, Object> model = table.getMaps();

				model.put("basePackage", config.groupid + "." + config.projectName);

				model.put("date", new Date());

				model.put("config", config);

				String content = FreeMarkers.renderTemplate(template, model);

				String className = model.get("className").toString() + ".java";

				director = WriteFile.getPackagePath(config.projectName + "/domain/", config.genFolder);

				WriteFile.writeFile(director, className, content);

			} catch (Exception e)
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
