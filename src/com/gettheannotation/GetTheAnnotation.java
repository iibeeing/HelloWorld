package com.gettheannotation;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.annotation.Entity;

public class GetTheAnnotation {
	private static String basePackage = "com";

	/**
	@Description: TODO(这里用一句话描述这个方法的作用)
	@param @param args    设定文件
	@date 创建时间：2016-4-21 上午10:36:53 
	@version 1.0
	@return void    返回类型
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		List<Class<?>> actionClassList = getClassList();
		
		for(Class<?> cls: actionClassList){
			if(cls.isAnnotation()){
				System.out.println("注解类有： " + cls.toString());
			}
			
			if(cls.isAnnotationPresent(Entity.class)){
				Object t = cls.newInstance();
				System.out.println("被注解类有： " + cls.toString() + " 实例为：" + t);
			}
		}
	}
	
    public static List<Class<?>> getClassList() {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        try {
            // 从包名获取 URL 类型的资源
            Enumeration<URL> urls = getClassLoader().getResources(basePackage.replace(".", "/"));
            // 遍历 URL 资源
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    // 获取协议名（分为 file 与 jar）
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        // 若在 class 目录中，则执行添加类操作
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        addClass(classList, packagePath, basePackage);
                    } else if (protocol.equals("jar")) {
                        // 若在 jar 包中，则解析 jar 包中的 entry
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            // 判断该 entry 是否为 class
                            if (jarEntryName.endsWith(".class")) {
                                // 获取类名
                                String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                // 执行添加类操作
                                doAddClass(classList, className);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }
    
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
    
    public static void addClass(List<Class<?>> classList, String packagePath, String packageName) {
        try {
            // 获取包名路径下的 class 文件或目录
            File[] files = new File(packagePath).listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
/*                	boolean result = false;
                	if((file.isFile() && file.getName().endsWith(".class")) || file.isDirectory()){
                		result = true;
                	}
                	System.out.println("名：" + file.getName() + " 结果：" + result);
                	return result;*/
                    return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
                }
            });
            // 遍历文件或目录
            for (File file : files) {
                String fileName = file.getName();
                
                // 判断是否为文件或目录
                if (file.isFile()) {
                    // 获取类名
                    String className = fileName.substring(0, fileName.lastIndexOf("."));
                    if (packageName != null && packageName != "") {
                        className = packageName + "." + className;
                        System.out.println("类名是：" + className);
                    }
                    // 执行添加类操作
                    doAddClass(classList, className);
                } else {
                    // 获取子包
                    String subPackagePath = fileName;
                    if (packageName != null && packageName != "") {
                        subPackagePath = packagePath + "/" + subPackagePath;
                    }
                    // 子包名
                    String subPackageName = fileName;
                    if (packageName != null && packageName != "") {
                        subPackageName = packageName + "." + subPackageName;
                    }
                    // 递归调用
                    addClass(classList, subPackagePath, subPackageName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doAddClass(List<Class<?>> classList, String className) {
        // 加载类
        Class<?> cls = loadClass(className, false);
        // 判断是否可以添加类
        if (checkAddClass(cls)) {
            // 添加类
            classList.add(cls);
        }
    }
    
    public static boolean checkAddClass(Class<?> cls){
    	return true;
    }
    
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cls;
    }
}
