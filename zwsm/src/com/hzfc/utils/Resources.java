package com.hzfc.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <pre>
 *     框架配置文件资源获取类，可以可以在系统属性中定义名称为“_frameworkResourceBundleName”的属性
 *  值来指定框架的资源配置文件全路径名称，从而指定框架不同的资源配置文件。框架的资源文件只能且只有一个。
 *     默认框架配置文件：resources.framework
 *  
 *     方法
 * <code>
 * getFrameworkInstance()
 * </code>
 * 获得框架当前的资源配置获取对象实例。
 *  如果有其它的资源配置文件，各个应用系统独立使用，则可以使用方法
 * <code>
 * getInstance(String)
 * </code>
 *  来统一获取。
 *  
 *     其中getFactory(Class)方法是为方$M ResourceFactory而实现的，它以$M(ResourceFactory)的Factory超
 *  类Class作为参数，获取该Factory的实际使用子类对象。
 *  $M(ResourceFactory)的实现必须符合如下规则： 
 *         		1、扩展接口 hzjbbis.framework.util.Factory
 *         		2、在$M(ResourceFactory)的Factory超类中覆盖接口Factory的类属性值“FACTORY_KEY”
 *  （详细说明参见开发框架参考文档）
 *  如果目标Factory类没有遵循以上规则或者不能正常实例化，将抛出一个BaseException系统错误异常。
 * </pre>
 * 
 * @since 1.0
 * @author lix
 * @see hzjbbis.framework.util.Factory
 */
public class Resources {

	public static final Log logger = LogFactory.getLog(Resources.class);

	/**
	 * 可以在系统属性中定义以下面常量为名称的属性值来指定框架的资源配置文件全路径名称，从而指定框架不同的资源配置文件。
	 * 框架的资源文件必须有且只能有一个。
	 */
	public static final String _FRAMEWORK_RESOURCE_BUNDLE_NAME = "_frameworkResourceBundleName";

	/**
	 * 框架默认绑定资源文件名，可以通过 <code>getFrameworkInstance</code>
	 * 方法直接获取绑定该属性值为资源文件的Resources对象。
	 */
	public static final String FRAMEWORK_BUNDLE_NAME = "appconfig";

	private static Resources FRAMEWORK_RESOURCES;

	static {
		reloadFrameworkResources();
	}

	/**
	 * 重新初始化框架资源绑定文件。
	 */
	public static void reloadFrameworkResources() {
		String bundleName = System.getProperty(_FRAMEWORK_RESOURCE_BUNDLE_NAME);
		if (bundleName == null) {
			logger.info("load framework resources: " + FRAMEWORK_BUNDLE_NAME);
			FRAMEWORK_RESOURCES = getInstance(FRAMEWORK_BUNDLE_NAME);
		} else {
			logger.info("load framework resources: " + bundleName);
			FRAMEWORK_RESOURCES = getInstance(bundleName);
		}
	}

	/**
	 * 获取框架配置文件绑定的资源管理对象
	 * 
	 * @return Resources $(Singleton)
	 */
	private static Resources getFrameworkInstance() {
		return FRAMEWORK_RESOURCES;
	}

	/**
	 * 获取指定绑定目标资源的Resources对象。
	 * 
	 * @param bundleName
	 *            绑定资源名
	 * @return Resources a new Resources Object
	 */
	public static Resources getInstance(String bundleName) {
		return new Resources(bundleName);
	}

	/**
	 * 调用getFrameworkInstance().getString(key)
	 * 
	 * @param key
	 * @return String
	 */
	public static String getString(String key) {
		return getFrameworkInstance().getStringPrivate(key);
	}
	/**
	 * 调用getFrameworkInstance().getString(key)
	 * 
	 * @param key
	 * @return String
	 */
	public static int getInt(String key) {
		return Integer.parseInt(getFrameworkInstance().getStringPrivate(key));
	}



	private final String _bundleName;

	private final ResourceBundle _resourceBundle;

	/**
	 * @param bundleName
	 *            绑定资源名
	 */
	private Resources(String bundleName) {
		_bundleName = bundleName;
		_resourceBundle = ResourceBundle.getBundle(bundleName);
	}

	/**
	 * @return String 绑定的资源名称（文件名）
	 */
	public String getBundleName() {
		return _bundleName;
	}

	/**
	 * 如果key==null或者没有找到目标信息，将抛出BaseException。
	 * 
	 * @param key
	 *            不应该为null或空字符串
	 * @return String
	 */
	private String getStringPrivate(final String key) {
		if (key == null) {
			System.out.println("在 resources.framework 中未找到给定key（"
							+ key + "）的资源属性值！");
		}
		try {
			return _resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			System.out.println("在 resources.framework 中未找到给定key（" + key
							+ "）的资源属性值！");
		}
		return key;
	}

	/**
	 * 如果key==null或者没有找到目标信息，将抛出BaseException。
	 * 
	 * @param key
	 *            不应该为null或空字符串
	 * @return boolean
	 */
	public boolean getBoolean(String key) {
		return Boolean.valueOf(getStringPrivate(key)).booleanValue();
	}


}