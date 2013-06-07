package com.cnksi.core.jfinal.creator;

import com.cnksi.core.jfinal.creator.config.Config;
import com.cnksi.core.jfinal.creator.gen.controller.GenController;
import com.cnksi.core.jfinal.creator.gen.domain.GenEntity;
import com.cnksi.core.jfinal.creator.gen.service.GenService;
import com.cnksi.core.jfinal.creator.gen.view.GenView;
import com.cnksi.core.jfinal.creator.utils.ExecCmd;

@SuppressWarnings("all")
public class Gen
{

	public static void main(String[] args)
	{
		Config config = new Config();

		String folder = "";

		config.setProjectName("test");

		//config.setGenFolder("D:\\project\\sts\\java\\quickstart\\src\\main\\java\\com\\cnksi");

		folder = GenEntity.newInstance(config).genEntity();

		folder = GenService.newInstance(config).genService();
		folder = GenController.newInstance(config).genController();

		folder = GenView.newInstance(config).genView();
		ExecCmd.openFolderInWindowsExplorer(folder);

		//System.out.println("Gen java file end ");
	}
}
