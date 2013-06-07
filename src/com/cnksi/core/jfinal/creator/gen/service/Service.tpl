package ${basePackage}.service;
 
import ${basePackage}.domain.${className}; 
import com.cnksi.core.jfinal.BaseService;
 /**
 * ${className} 管理类.
 * 
 * @author creator
 */
	
public class ${className}Service extends BaseService<${className}>
{
	private static ${className}Service  ${className?lower_case}Service = null;

	public static ${className}Service service()
	{
		if (${className?lower_case}Service == null)
		{
			 ${className?lower_case}Service = new ${className}Service();
		}

		return  ${className?lower_case}Service;
	}

	@Override
	public ${className} getDao()
	{
		return ${className}.dao();
	} 
}

  