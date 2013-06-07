package ${basePackage}.controller;

import com.cnksi.core.jfinal.BaseService;
import ${basePackage}.service.${className}Service;
import ${basePackage}.domain.${className};
import com.cnksi.core.jfinal.BaseControllerDwz;

/**
 * ${className} 管理的Controller
 * 
 * List page     : GET  /${className?lower_case}/index
 * Create page   : GET  /${className?lower_case}/create 
 * Create action : POST /${className?lower_case}/created 
 * Update page   : GET  /${className?lower_case}/update?id={${pkFieldInfo.field}}
 * Update action : POST /${className?lower_case}/updated
 * Delete action : GET  /${className?lower_case}/delete?id={${pkFieldInfo.field}}
 * Delete action : GET  /${className?lower_case}/deletes?ids=ids
 * Export action : GET  /${className?lower_case}/export
 * 
 * @author creator
 *
 */
public class ${className}Controller extends BaseControllerDwz<${className}>
{
	@Override
	protected BaseService<${className}> getService()
	{
		return ${className}Service.service();
	} 
}

  