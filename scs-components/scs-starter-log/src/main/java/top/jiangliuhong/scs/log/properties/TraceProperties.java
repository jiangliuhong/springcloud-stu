package top.jiangliuhong.scs.log.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.Getter;
import lombok.Setter;

/**
 * 日志链路追踪配置
 *
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "scs.trace")
@RefreshScope
public class TraceProperties {
    /**
     * 是否开启日志链路追踪
     */
    private Boolean enable = false;
}
