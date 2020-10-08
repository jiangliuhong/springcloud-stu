package top.jiangliuhong.scs.common.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * FeignConfig
 * 
 * @description fegin配置文件
 * @author jiangliuhong
 * @date 2020/8/8 14:19
 * @version 1.0.0
 */
@Component
@Slf4j
public class FeignConfig implements RequestInterceptor {
    /**
     * 应用名称
     */
    @Value("${spring.application.name:scs}")
    private String applicationName;

    /**
     * 应用实例id
     */
    @Value("${eureka.instance.instance-id:scs}")
    private String instanceId;

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Autowired
    private ObjectMapper objectMapper;

    /** GET请求 */
    private static final String HTTP_METHOD_GET = "GET";
    /** 授权信息常量 */
    public static final String AUTHORIZATION = "authorization";
    /** 应用名称 */
    public static final String APPLICATION_NAME = "applicationName";
    /** 实例ID */
    public static final String INSTANCE_ID = "instanceId";

    @Override
    public void apply(RequestTemplate template) {
        // 添加调用方信息
        template.header(APPLICATION_NAME, applicationName);
        template.header(INSTANCE_ID, instanceId);

        // 转发授权码信息
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            template.header(AUTHORIZATION, request.getHeader(AUTHORIZATION));
        }
        // 处理get传递dto为requestBody问题
        byte[] bodyBtye = template.body();
        if (HTTP_METHOD_GET.equals(template.method()) && bodyBtye != null) {
            try {
                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(objectMapper.readTree(bodyBtye), null, queries);
                template.queries(queries);
            } catch (IOException e) {
                log.error("转换get的body为查询参数异常,url:{}", template.url(), e);
            }

        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {

        // 数据节点，完成递归
        if (!jsonNode.isContainerNode()) {

            if (queries.containsKey(path)) {
                queries.get(path).add(jsonNode.asText(""));
            } else {
                Collection<String> value = new HashSet<>();
                value.add(jsonNode.asText(""));
                queries.put(path, value);
            }
            return;
        }

        if (jsonNode.isArray()) {
            jsonNode.elements().forEachRemaining(ele -> {
                buildQuery(ele, path, queries);
            });
        } else {
            // 结构节点，递归构造
            jsonNode.fields().forEachRemaining(entry -> {
                if (StringUtils.isBlank(path)) {
                    // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                } else {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                }
            });
        }
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public Encoder feignFormEncoder() {
        return new FeignEncoder(new SpringEncoder(messageConverters));
    }
}
