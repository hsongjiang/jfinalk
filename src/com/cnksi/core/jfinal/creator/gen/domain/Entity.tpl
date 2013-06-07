package ${basePackage}.domain;

import java.io.Serializable;
import com.jfinal.plugin.activerecord.Model;

/**
 * 
 * ${className} Entity
 * 
 * @author creator
 * 
 * @since ${date?datetime}
 */
public class ${className} extends Model<${className}> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static ${className} ${className?uncap_first}Dao = null;

	public static ${className} dao()
	{
		if (${className?uncap_first}Dao == null)
		{
			${className?uncap_first}Dao = new  ${className}();
		}

		return ${className?uncap_first}Dao;
	}
}