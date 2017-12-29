package common.properties;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {

    public static Object getProperty(String path,String prepKey) throws IOException {
        Properties properties = null;
        InputStream in = null;
        try {
            properties = new Properties();
            in = new BufferedInputStream(new FileInputStream(path));
            properties.load(in);
        } finally {
            if (null != in){
                in.close();
            }
        }
        return properties.getProperty(prepKey);
    }
    public static void setProperty(String path,String prepKey,String prepValue) throws IOException {
        Properties properties = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            properties = new Properties();
            in = new BufferedInputStream(new FileInputStream(path));
            properties.load(in);
            out = new FileOutputStream(path);
            properties.setProperty(prepKey,prepValue);
            properties.store(out,path+" add key- "+prepKey+", value-"+prepValue);
        } finally {
            if (null != in){
                in.close();
            }if (null != out){
                out.close();
            }
        }
    }
    public static void removeProperty(String path,String prepKey) throws IOException {
        Properties properties = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            properties = new Properties();
            in = new BufferedInputStream(new FileInputStream(path));
            properties.load(in);
            properties.remove(prepKey);
            out = new FileOutputStream(path);
            properties.store(out,path+" remove key- "+prepKey);
        } finally {
            if (null != in){
                in.close();
            }if (null != out){
                out.close();
            }
        }
    }
    public static Properties getProperties(String path) throws IOException {
        Properties properties = null;
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            properties = new Properties();
            properties.load(in);
        } finally {
            if (null != in){
                in.close();
            }
        }
        return properties;
    }
    public static void setProperties(String path,Properties properties) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        Set<Object> keySet = properties.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String keyValue = properties.getProperty(key);
            setProperty(path,key,keyValue);
        }
    }
    public static Set<Object> getPropertiesKeySet(String path) throws IOException {
        return getProperties(path).keySet();
    }


}

