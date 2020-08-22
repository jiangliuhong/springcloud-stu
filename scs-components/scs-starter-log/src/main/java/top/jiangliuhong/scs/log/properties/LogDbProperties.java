package top.jiangliuhong.scs.log.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.zaxxer.hikari.HikariConfig;

import lombok.Getter;
import lombok.Setter;

/**
 * 日志数据源配置 logType=db时生效(非必须)，如果不配置则使用当前数据源
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "scs.audit-log.datasource")
public class LogDbProperties extends HikariConfig {}
