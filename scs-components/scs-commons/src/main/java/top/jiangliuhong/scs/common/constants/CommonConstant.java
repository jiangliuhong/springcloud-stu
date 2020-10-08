package top.jiangliuhong.scs.common.constants;

/**
 *
 */
public final class CommonConstant {

    private CommonConstant() {}

    /**
     * header中的token
     */
    public final static String TOKEN_HEADER = "Authorization";

    /**
     * 请求参数中的token
     */
    public final static String ACCESS_TOKEN = "access_token";

    /**
     * Bearer关键字
     */
    public final static String BEARER_TYPE = "Bearer";

    /**
     * 超级管理员用户名
     */
    public final static String ADMIN_USER_NAME = "admin";
    /**
     * 公共日期格式
     */
    public final static String MONTH_FORMAT = "yyyy-MM";
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String SIMPLE_MONTH_FORMAT = "yyyyMM";
    public final static String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    public final static String SIMPLE_DATETIME_FORMAT = "yyyyMMddHHmmss";
    /**
     * 默认用户密码
     */
    public final static String DEFAULT_USER_PASSWORD = "123456";
    /**
     * redis锁前缀key
     */
    public final static String LOCK_KEY_PREFIX = "LOCK_KEY:";
    /**
     * 租户id参数
     */
    public final static String TENANT_ID_PARAM = "tenantId";
    /**
     * 日志链路追踪id信息头
     */
    public final static String TRACE_ID_HEADER = "x-traceId-header";
    /**
     * 日志链路追踪id日志标志
     */
    public final static String LOG_TRACE_ID = "traceId";
}
