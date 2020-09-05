package top.jiangliuhong.scs.common.constants;

/**
 *
 */
public final class CommonConstant {

    private CommonConstant() {
    }

    /**
     * 项目版本号(banner使用)
     */
    public final static String PROJECT_VERSION = "4.0.0";

    /**
     * token请求头名称
     */
    public final static String TOKEN_HEADER = "Authorization";

    /**
     * The access token issued by the authorization server. This value is REQUIRED.
     */
    public final static String ACCESS_TOKEN = "access_token";

    public final static String BEARER_TYPE = "Bearer";

    /**
     * 标签 header key
     */
    public final static String HEADER_LABEL = "x-label";

    /**
     * 标签 header 分隔符
     */
    public final static String HEADER_LABEL_SPLIT = ",";

    /**
     * 标签或 名称
     */
    public final static String LABEL_OR = "labelOr";

    /**
     * 标签且 名称
     */
    public final static String LABEL_AND = "labelAnd";

    /**
     * 权重key
     */
    public final static String WEIGHT_KEY = "weight";

    /**
     * 删除
     */
    public final static String STATUS_DEL = "1";

    /**
     * 正常
     */
    public final static String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    public final static String STATUS_LOCK = "9";

    /**
     * 目录
     */
    Integer CATALOG = -1;

    /**
     * 菜单
     */
    Integer MENU = 1;

    /**
     * 权限
     */
    Integer PERMISSION = 2;

    /**
     * 删除标记
     */
    public final static String DEL_FLAG = "is_del";

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

    public final static String DEF_USER_PASSWORD = "123456";

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
    /**
     * 负载均衡策略-版本号 信息头
     */
    public final static String Z_L_T_VERSION = "z-l-t-version";
    /**
     * 注册中心元数据 版本号
     */
    public final static String METADATA_VERSION = "version";
}
