package top.jiangliuhong.scs.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import top.jiangliuhong.scs.uaa.handle.JWTokenEnhancer;

/**
 * JwtTokenConfig <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/8 10:45 上午
 * @version 1.0.0
 */
@Configuration
public class JwtTokenConfig {

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("dev");
        return accessTokenConverter;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return new JWTokenEnhancer();
    }

}
