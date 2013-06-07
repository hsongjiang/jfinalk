package com.cnksi.core.jfinal;

import java.util.List;

import com.cnksi.core.jfinal.ext.render.DwzRender;
import com.cnksi.core.jfinal.ext.render.excel.PoiRender;
import com.cnksi.core.utils.SearchFilter;
import com.cnksi.core.utils.WebUtils;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("rawtypes")
public abstract class BaseControllerDwz<M extends Model> extends Controller
{
	protected Logger logger = null;

	protected BaseService<M> service;

	public static final String VIEW_FOLDER = "/dwz";

	protected M model;

	protected String modelName = "", pkName = "";

	protected int pageNum = 1;

	protected String orderField = "";

	protected String orderDirection = "";

	protected int numPerPage = 20;

	public BaseControllerDwz()
	{
		this.service = getService();

		if (service != null)
		{
			this.model = service.getDao();
			logger = Logger.getLogger(model.getClass());
			this.modelName = this.model.getTableName();
			this.pkName = this.model.getPrimaryKey();
		}
	}

	protected void fpage()
	{
		pageNum = getParaToInt("pageNum", pageNum);

		numPerPage = getParaToInt("numPerPage", numPerPage);

		orderField = getPara("orderField", model.getPrimaryKey());

		orderDirection = getPara("orderDirection", "desc");

		setAttr("orderField", orderField);

		setAttr("orderDirection", orderDirection);
	}

	public void index()
	{
		fpage();

		Page page = service.paginate(pageNum, numPerPage, orderField, orderDirection, filters());

		setAttr("page", page);

		setAttr("modelName", modelName);

		render(VIEW_FOLDER + "/" + modelName + "/" + "list.jsp");
	}

	public void create()
	{
		setAttr("action", "created");
		setAttr("modelName", modelName);

		render(VIEW_FOLDER + "/" + modelName + "/" + "form.jsp");
	}

	public void created()
	{
		if (getModel(model.getClass(), modelName).save())
		{
			render(DwzRender.closeCurrentAndRefresh(modelName + "-list"));
		} else
		{
			render(DwzRender.error());
		}
	}

	public void update()
	{
		setAttr("record", service.find(getPara("id")));
		setAttr("action", "updated");
		setAttr("modelName", modelName);

		render(VIEW_FOLDER + "/" + modelName + "/" + "form.jsp");
	}

	public void updated()
	{
		if (getModel(model.getClass(), modelName).update())
		{
			render(DwzRender.closeCurrentAndRefresh(modelName + "-list"));
		} else
		{
			render(DwzRender.error());
		}
	}

	public void delete()
	{
		if (service.deleteById(getPara("id")))
		{
			render(DwzRender.success());
		} else
		{
			render(DwzRender.error());
		}
	}

	public void deletes()
	{
		int deleteRecords = service.deleteByIds(getParaValues("ids"));

		if (deleteRecords > 0)
		{
			render(DwzRender.success("成功删除记录数:" + deleteRecords));
		} else
		{
			render(DwzRender.error());
		}
	}

	@SuppressWarnings("unchecked")
	public void xls()
	{
		fpage();
		Page page = service.paginate(pageNum, numPerPage, orderField, orderDirection, filters());
		render(PoiRender.excel(page.getList(), new String[] { "编号", "姓名" }));
	}

	public List<SearchFilter> filters()
	{
		return WebUtils.getParametersStartingWith(getRequest());
	}

	protected abstract BaseService<M> getService();
}
