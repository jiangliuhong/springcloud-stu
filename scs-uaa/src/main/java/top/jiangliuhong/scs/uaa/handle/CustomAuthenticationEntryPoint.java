package top.jiangliuhong.scs.uaa.handle;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import top.jiangliuhong.scs.common.bean.res.ErrorResponse;

@Component("customAuthenticationEntryPoint")
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        ErrorResponse er = new ErrorResponse();
        er.setCode(HttpStatus.UNAUTHORIZED.value());
        er.setMessage("client_id或client_secret错误");
        response.setHeader("Content-Type", "application/json;charset=utf-8");

        response.getWriter().print(JSON.toJSONString(er));
        response.getWriter().flush();
    }
}
