package top.jiangliuhong.scs.base.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * ApiConstatns
 * @description API信息常量
 * @author jiangliuhong
 * @date 2020/8/8 15:48
 * @version 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiConstatns {

    /**
     * API 版本1的前缀.
     */
    public static final String API_V1 = "/api/v1";

    /**
     * 路由
     */
    public static final String API_ROUTE_V1 = API_V1 + "/route";
}
