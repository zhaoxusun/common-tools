package common.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
    private static Logger logger ;
    static {
        logger = Logger.getLogger(LogUtil.class);
        String logConfigPath = System.getProperty("user.dir")+"/config/log4j.properties";
        PropertyConfigurator.configure(logConfigPath);
    }

    private static Object getMessage(Object message){
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String fileName = className.substring(className.lastIndexOf('.') + 1);
        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        return String.format("[%s.%s(%s.java:%d)]:%s%s%s", className, methodName, fileName,
                lineNumber, System.lineSeparator(), message, System.lineSeparator());

    }

    public static void debug(Object message){
        logger.debug(getMessage(message));
    }
    public static void debug(Object message,Throwable t){
        logger.debug(getMessage(message),t);
    }
    public static void info(Object message){
        logger.info(getMessage(message));
    }
    public static void info(Object message,Throwable t){
        logger.info(getMessage(message),t);
    }
    public static void warn(Object message){
        logger.warn(getMessage(message));
    }
    public static void warn(Object message,Throwable t){
        logger.warn(getMessage(message),t);
    }
    public static void error(Object message){
        logger.error(getMessage(message));
    }
    public static void error(Object message,Throwable t){
        logger.error(getMessage(message),t);
    }
}

