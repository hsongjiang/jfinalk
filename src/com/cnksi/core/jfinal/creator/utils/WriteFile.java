package com.cnksi.core.jfinal.creator.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteFile
{

	/**
	 * 写Java文件
	 * 
	 * @param folder
	 *            文件夹
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
	 */
	public static void writeFile(String folder, String filename, String content)
	{

		try
		{
			createFolder(folder);

			filename = folder + "\\" + filename;

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");

			out.write(content);

			out.flush();

			out.close();

		} catch (IOException e)
		{

			e.printStackTrace();

		}
	}

	/**
	 * 根据director 和 packageName 得到文件存放的文件夹
	 * 
	 * @param director
	 *            D:\gen
	 * @param packageName
	 *            com.cnksi.demo
	 * @return
	 */
	public static String getPackagePath(String projectName, String director)
	{

		director = director.endsWith("/") ? director + projectName : director + "/" + projectName;

		director = director.startsWith("/") ? director.replaceFirst("/", "") : director;

		return director;
	}

	/**
	 * 创建 目录
	 * 
	 * @param folderName
	 */
	private static void createFolder(String folderName)
	{

		File moduleFile = new File(folderName);

		if (!moduleFile.exists())
		{

			moduleFile.mkdirs();

		}
	}
}
