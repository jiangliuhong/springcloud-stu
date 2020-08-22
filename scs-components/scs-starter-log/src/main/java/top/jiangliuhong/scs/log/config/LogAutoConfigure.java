package top.jiangliuhong.scs.log.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;

import top.jiangliuhong.scs.log.properties.AuditLogProperties;
import top.jiangliuhong.scs.log.properties.LogDbProperties;
import top.jiangliuhong.scs.log.properties.TraceProperties;

/**
 * 日志自动配置
 *
 */
@EnableConfigurationProperties({TraceProperties.class, AuditLogProperties.class})
public class LogAutoConfigure {
    /**
     * 日志数据库配置
     */
    @Configuration
    @ConditionalOnClass(HikariConfig.class)
    @EnableConfigurationProperties(LogDbProperties.class)
    public static class LogDbAutoConfigure {}
}
