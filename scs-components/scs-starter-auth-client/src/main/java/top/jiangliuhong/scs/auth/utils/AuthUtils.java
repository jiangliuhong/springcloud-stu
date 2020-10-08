package top.jiangliuhong.scs.auth.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import top.jiangliuhong.scs.common.constants.CommonConstant;

/**
 * 认证授权工具类 <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/5 11:18 下午
 * @version 1.0.0
 */
@Slf4j
public final class AuthUtils {

    private AuthUtils() {}

    private static final String BASIC_ = "Basic ";

    public static String getToken(HttpServletRequest request) {
        // 先从header信息中获取一次，如果没有再从参数中获取access_token
        String token = getTokenByHeader(request);
        if (StringUtils.isBlank(token)) {
            token = getTokenByParams(request);
        }
        return token;
    }

    /**
     * 从header信息中获取token
     * 
     * @param request 请求信息
     * @return token
     */
    public static String getTokenByHeader(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(CommonConstant.TOKEN_HEADER);
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            if (StringUtils.isNotBlank(header) && header.startsWith(CommonConstant.BEARER_TYPE)) {
                String authHeaderValue = header.substring(CommonConstant.BEARER_TYPE.length()).trim();
                int commaIndex = authHeaderValue.indexOf(',');
                if (commaIndex > 0) {
                    authHeaderValue = authHeaderValue.substring(0, commaIndex);
                }
                return authHeaderValue;
            }
        }
        return CommonConstant.TOKEN_HEADER;
    }

    /**
     * 从请求参数中获取token
     * 
     * @param request 请求信息
     * @return token
     */
    public static String getTokenByParams(HttpServletRequest request) {
        return request.getParameter(CommonConstant.ACCESS_TOKEN);
    }
}
