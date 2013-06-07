package com.cnksi.core.jfinal;

import java.util.ArrayList;
import java.util.List;

import com.cnksi.core.utils.SearchFilter;
import com.cnksi.core.utils.Where;
import com.jfinal.aop.Before;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseService<M extends Model>
{

	public M model = null;

	public BaseService()
	{
		this.model = getDao();
	}

	public Page<M> paginate(Integer page, Integer limit)
	{
		return paginate(page, limit, null, null, null);
	}

	public Page<M> paginate(Integer page, Integer limit, String orderField, String orderDirection)
	{
		return paginate(page, limit, orderField, orderDirection, null);
	}

	public Page<M> paginate(Integer page, Integer limit, String orderField, String orderDirection, List<SearchFilter> searchFilterList)
	{
		String orderSql = "";
		List<Object> values = new ArrayList<Object>();
		String whereSql = Where.where(searchFilterList, values);
		if (StringKit.notBlank(orderDirection, orderField))
		{
			orderSql = " order by " + orderField + " " + orderDirection;
		}

		return model.paginate(page, limit, "select *", "from " + model.getTableName() + whereSql + orderSql, values.toArray());
	}

	public List<M> findAll()
	{
		return model.find("select * from " + model.getTableName());
	}

	public M find(Object id)
	{
		return (M) model.findById(id);
	}

	public List<M> findByPropertity(String propertity, String value)
	{
		return model.find("select * from " + model.getTableName() + " where " + propertity + " = ? ", value);
	}

	public M findFirstByPropertity(String propertity, String value)
	{
		return (M) model.findFirst("select * from " + model.getTableName() + " where " + propertity + " = ? ", value);
	}

	public boolean save(M record)
	{
		return record.save();
	}

	public boolean delete(M record)
	{
		return record.delete();
	}

	public boolean deleteById(Object id)
	{
		return model.deleteById(id);
	}

	@Before(Tx.class)
	public Integer deleteByIds(Object[] ids)
	{
		int c = 0;

		for (Object id : ids)
		{
			if (model.deleteById(id))
			{
				c++;
			}
		}

		return c;
	}

	public boolean update(M record)
	{
		return record.update();
	}

	public abstract M getDao();
}
