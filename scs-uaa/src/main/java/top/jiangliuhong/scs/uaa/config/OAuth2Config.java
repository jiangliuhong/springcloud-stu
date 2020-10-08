package top.jiangliuhong.scs.uaa.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import top.jiangliuhong.scs.uaa.service.ScsUserDetailsService;

/**
 * OAuth2Config <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/8 11:10 上午
 * @version 1.0.0
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private ScsUserDetailsService scsUserDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenStore jwtTokenStore;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /**
         * jwt 增强模式
         */
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList<>();
        enhancerList.add(jwtTokenEnhancer);
        enhancerList.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(enhancerList);
        endpoints.tokenStore(jwtTokenStore).userDetailsService(scsUserDetailsService)
            // 支持 password 模式
            .authenticationManager(authenticationManager).tokenEnhancer(enhancerChain)
            .accessTokenConverter(jwtAccessTokenConverter);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许客户端访问 OAuth2 授权接口
        security.allowFormAuthenticationForClients();
        // 允许已授权用户访问 checkToken 接口和获取 token 接口
        security.checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("isAuthenticated()");
    }
}
