package top.jiangliuhong.scs.gateway.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * web配置
 */
@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 不知道为啥，映射index.html的方式不生效，使用indexRouter的方法
        // registry.addResourceHandler("/index.html").addResourceLocations("classpath:/dist/index.html");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/dist/static/");
    }

    @Bean
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/dist/index.html") final Resource indexHtml) {
        return RouterFunctions
            .route(RequestPredicates.GET("/index.html"),
                request -> ServerResponse.ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtml));
    }
}
