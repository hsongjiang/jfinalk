
package com.cnksi.core.jfinal.creator.utils;

import java.io.IOException;

public class ExecCmd
{

	/**
	 * 在资源管理器中打开文件夹
	 * 
	 * @param folder  文件夹路径,D:\\gen
	 * 
	 */
	public static void openFolderInWindowsExplorer(String folder)
	{

		try
		{
			Runtime.getRuntime().exec("cmd /c start " + folder);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
