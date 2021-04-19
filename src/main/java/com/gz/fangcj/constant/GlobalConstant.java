package com.gz.fangcj.constant;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * The class Global constant.
 *
 * @author paascloud.net@gmail.com
 */
public class GlobalConstant {

    /**
     * The constant FILE_MAX_SIZE.
     */
    public static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "X-Real-IP";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";


    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    public static final int MAX_IP_LENGTH = 15;

    public static final String DEV_PROFILE = "dev";
    public static final String TEST_PROFILE = "test";
    public static final String PRO_PROFILE = "pro";
    public static final int TWO_INT = 2;
    public static final int M_SIZE = 1024;
    public static final String ROOT_PREFIX = "ybt";

    public static final int EXCEPTION_CAUSE_MAX_LENGTH = 2048;
    public static final int EXCEPTION_MESSAGE_MAX_LENGTH = 2048;

    public static final String ACCOUNT_PASSWORD_DEFAULT = "123456";

    public interface Number {
        int THOUSAND_INT = 1000;
        int HUNDRED_INT = 100;
        int ONE_INT = 1;
        int TWO_INT = 2;
        int THREE_INT = 3;
        int FOUR_INT = 4;
        int FIVE_INT = 5;
        int SIX_INT = 6;
        int SEVEN_INT = 7;
        int EIGHT_INT = 8;
        int NINE_INT = 9;
        int TEN_INT = 10;
        int EIGHTEEN_INT = 18;
    }

    /**
     * The class Symbol.
     *
     * @author paascloud.net@gmail.com
     */
    public static final class Symbol {
        private Symbol() {
        }

        /**
         * The constant COMMA.
         */
        public static final String COMMA = ",";
        public static final String SPOT = ".";
        /**
         * The constant UNDER_LINE.
         */
        public final static String UNDER_LINE = "_";
        /**
         * The constant PER_CENT.
         */
        public final static String PER_CENT = "%";
        /**
         * The constant AT.
         */
        public final static String AT = "@";
        /**
         * The constant PIPE.
         */
        public final static String PIPE = "||";
        public final static String SHORT_LINE = "-";
        public final static String SPACE = " ";
        public static final String SLASH = "/";
        public static final String MH = ":";

    }

    /**
     * The class Oss.
     *
     * @author paascloud.net@gmail.com
     */
    public static final class Oss {
        private Oss() {
        }

        /**
         * The constant DEFAULT_FILE_PATH.
         */
        public static final String DEFAULT_FILE_PATH = "/default/";
    }


    /**
     * 图片压缩高度和宽度
     */
    public static final int IMAGE_WIDTH = 1920;
    /**
     * The constant IMAGE_HEIGHT.
     */
    public static final int IMAGE_HEIGHT = 1280;

    /**
     * The constant Y.
     */
    public static final Integer Y = 1;
    /**
     * The constant N.
     */
    public static final Integer N = 0;

    public static JSONArray getExceptionStackTrace(Exception ex) {
        StackTraceElement[] stackTraceElement = ex.getStackTrace();
        JSONArray errTraceArray = new JSONArray();
        for (int i = 0; i < stackTraceElement.length; i++) {
            StackTraceElement stackTrace = stackTraceElement[i];
            if (!stackTrace.getClassName().startsWith("com.gz.mxc.controller") && !stackTrace.getClassName().startsWith("com.gz.mxc.service")) {
                continue;
            }
            if (stackTrace.getClassName().contains("$")) {
                continue;
            }
            JSONObject errTraceObject = new JSONObject();
            errTraceObject.put("className", stackTrace.getClassName());
            errTraceObject.put("fileName", stackTrace.getFileName());
            errTraceObject.put("methodName", stackTrace.getMethodName());
            errTraceObject.put("lineNumber", stackTrace.getLineNumber());
            errTraceArray.add(errTraceObject);
        }
        return errTraceArray;
    }

}
