package top.jiangliuhong.scs.common.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * Swagger2Configuration
 * @description Swagger2Configuration
 * @author jiangliuhong
 * @date 2020/8/12 10:33 上午
 * @version 1.0.0
 */
@ConditionalOnProperty(name = "scs.swagger.enabled", matchIfMissing = true)
@Import({
        Swagger2DocumentationConfiguration.class
})
public class Swagger2Configuration {
}
