package com.scala.common;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Who on 2014/4/10.
 */
public final class Reflection {

    public static List<Class> getAllClassByInterface(Class i, String packageName) {
        List<Class> classList = null;
        if (i.isInterface()) {
            List<Class<?>> classes = getClasses(packageName);
            if (classes.size() > 0) {
                classList = new ArrayList<Class>();
                for (Class c : classes) {
                    if (i.isAssignableFrom(c)) {
                        if (!i.equals(c)) {
                            classList.add(c);
                        }
                    }
                }
            }
        }
        return classList;
    }

    public static List<Class<?>> getClasses(String packageName) {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassesInPackageByFile(packageName, filePath, classList);
                }
            }
        } catch (IOException e) {
        }
        return classList;
    }

    public static void findClassesInPackageByFile(String packageName, String packagePath, List<Class<?>> classList) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] dirFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), classList);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classList.add(Class.forName(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                }
            }
        }
    }

    public static List<Object> getInstancesByInterface(Class i, String packageName) {
        List<Class> classList = getAllClassByInterface(i, packageName);
        List<Object> objectList = null;
        if (classList == null || classList.size() == 0) {
            return null;
        }
        objectList = new ArrayList<Object>();
        for (Class c : classList) {
            try {
                objectList.add((Object) c.newInstance());
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            }
        }
        return objectList;
    }
}