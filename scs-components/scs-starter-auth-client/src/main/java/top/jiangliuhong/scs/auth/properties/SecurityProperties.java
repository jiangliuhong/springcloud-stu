package top.jiangliuhong.scs.auth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangliuhong
 * @date 2019/1/4
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "scs.security")
@RefreshScope
public class SecurityProperties {
    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 验证码配置
     */
    @Setter
    @Getter
    public class ValidateCodeProperties {
        /**
         * 设置认证通时不需要验证码的clientId
         */
        private String[] ignoreClientCode = {};

        /**
         * 开启验证码
         */
        private Boolean enable = false;
    }
}
