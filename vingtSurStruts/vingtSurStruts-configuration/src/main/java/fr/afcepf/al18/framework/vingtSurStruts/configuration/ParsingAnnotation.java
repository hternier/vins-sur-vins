package fr.afcepf.al18.framework.vingtSurStruts.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Action;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Form;

public class ParsingAnnotation {
	
	private static ParsingAnnotation instance;
	
	private List<String> packageName;
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> actionsMap = new HashMap<String, Class>();
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> formMap = new HashMap<String, Class>();
	
	private ParsingAnnotation(List<String> packageName) throws ClassNotFoundException, IOException {
		this.packageName = packageName;
		this.parsePackages();
	}

	public static ParsingAnnotation getInstance(List<String> packageName) throws ClassNotFoundException, IOException {
		if (instance == null) {
			instance = new ParsingAnnotation(packageName);
		}
		return instance;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void parsePackages() throws ClassNotFoundException, IOException {
		Set<Class> classesInPackages = new HashSet<Class>();
		
		for(String packageName : this.packageName) {
			classesInPackages.addAll(Arrays.asList(getClasses(packageName)));
		}

		List<Class> actionClasses = new ArrayList<Class>();
		List<Class> formClasses = new ArrayList<Class>();
		
		for (Class clazz : classesInPackages) {
			if (clazz.isAnnotationPresent(Action.class)) {
				actionClasses.add(clazz);
			} else if (clazz.isAnnotationPresent(Form.class)) {
				formClasses.add(clazz);
			}
		}
		
		this.initForms(formClasses);
		this.initActions(actionClasses);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initForms(List<Class> formClasses) {
		for (Class clazz : formClasses) {
			Form actionAnnocation = (Form) clazz.getAnnotation(Form.class);
			this.formMap.put(actionAnnocation.value(), clazz);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initActions(List<Class> actionClasses) {
		for (Class clazz : actionClasses) {
			Action actionAnnocation = (Action) clazz.getAnnotation(Action.class);
			this.actionsMap.put(actionAnnocation.urlPattern(), clazz);
		}
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	private static Class[] getClasses(String packageName)
	        throws ClassNotFoundException, IOException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    assert classLoader != null;
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    ArrayList<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Class> getActionsMap() {
		return actionsMap;
	}

	@SuppressWarnings("rawtypes")
	public void setActionsMap(Map<String, Class> actionsMap) {
		this.actionsMap = actionsMap;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Class> getFormMap() {
		return formMap;
	}

	@SuppressWarnings("rawtypes")
	public void setFormMap(Map<String, Class> formMap) {
		this.formMap = formMap;
	}
	
}
