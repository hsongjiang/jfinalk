package com.cnksi.core.utils;

import java.util.List;

import com.cnksi.core.utils.SearchFilter.Operator;

/**
 * combine sql where
 * 
 * @author joe
 *
 */
public class Where
{
	public static String where(List<SearchFilter> filters, List<Object> values)
	{
		StringBuffer wherebuffer = new StringBuffer(" where 1=1 ");
		if (filters != null && filters.size() > 0)
		{
			for (SearchFilter filter : filters)
			{
				wherebuffer.append(" and ");

				if (filter.operator.equals(SearchFilter.Operator.EQ))
				{
					dealMulitFieldName(filter, wherebuffer, " = ", values);
				} else if (filter.operator.equals(Operator.LIKE))
				{
					filter.setValue("%" + filter.getValue() + "%");
					dealMulitFieldName(filter, wherebuffer, " like ", values);
				} else if (filter.operator.equals(Operator.GT))
				{
					dealMulitFieldName(filter, wherebuffer, " > ", values);
				} else if (filter.operator.equals(Operator.GTE))
				{
					dealMulitFieldName(filter, wherebuffer, " >= ", values);
				} else if (filter.operator.equals(Operator.LT))
				{
					dealMulitFieldName(filter, wherebuffer, " < ", values);
				} else if (filter.operator.equals(Operator.LTE))
				{
					dealMulitFieldName(filter, wherebuffer, " <= ", values);
				}
			}
		}
		return wherebuffer.toString();
	}

	// 1=1 and (filed1 = value or field2 = value)
	private static void dealMulitFieldName(SearchFilter filter, StringBuffer wherebuffer, String sign, List<Object> values)
	{
		if (filter.isMuliFields())
		{
			wherebuffer.append("(");
			for (int i = filter.getFields().length - 1; i >= 0; i--)
			{
				wherebuffer.append(filter.getFields()[i] + sign + " ? ");
				if (i != 0)
				{
					wherebuffer.append(" or ");
				}
				values.add(filter.getValue());
			}
			wherebuffer.append(")");
		} else
		{
			wherebuffer.append(filter.getFieldName() + sign + " ? ");
			values.add(filter.getValue());
		}
	}
}
