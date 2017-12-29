package common.log;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LogUtilTest {
    @Test
    public void testDebug() throws Exception {
        LogUtil.debug("debug",new Exception("debug"));
    }

    @Test
    public void testDebug1() throws Exception {
        LogUtil.debug("debug");
    }

    @Test
    public void testInfo() throws Exception {
        LogUtil.info("info",new Exception("info"));
    }

    @Test
    public void testInfo1() throws Exception {
        LogUtil.info("info");
    }

    @Test
    public void testWarn() throws Exception {
        LogUtil.warn("warn",new Exception("warn"));
    }

    @Test
    public void testWarn1() throws Exception {
        LogUtil.warn("warn");
    }

    @Test
    public void testError() throws Exception {
        LogUtil.error("error",new Exception("error"));
    }

    @Test
    public void testError1() throws Exception {
        LogUtil.error("error");
    }

}