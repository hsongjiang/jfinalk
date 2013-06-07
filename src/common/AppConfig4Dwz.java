package common;

import com.cnksi.demo.IndexController;
import com.cnksi.demo.controller.UserController;
import com.cnksi.demo.domain.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class AppConfig4Dwz extends JFinalConfig
{
	@Override
	public void configConstant(Constants me)
	{
		super.loadPropertyFile("appconfig.txt");
		me.setDevMode(getPropertyToBoolean("devMode", true));
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me)
	{
		me.add("/", IndexController.class);
		me.add("/users", UserController.class);
	}

	@Override
	public void configPlugin(Plugins me)
	{
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arp.setShowSql(true);
		me.add(arp);
		arp.addMapping("users", User.class); // 映射blog 表到 Blog模型

	}

	@Override
	public void configInterceptor(Interceptors me)
	{

	}

	@Override
	public void configHandler(Handlers me)
	{
	}
}
