package top.jiangliuhong.scs.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.jiangliuhong.scs.common.model.BaseEntity;

@Getter
@Setter
@ToString
@ApiModel("认证信息")
@Table(name = "db_base.t_client_details")
public class ClientDetails extends BaseEntity {
    /**
     * 应用标识
     */
    @Column(name = "c_client_id")
    private String clientId;

    /**
     * 资源限定串(逗号分割)
     */
    @Column(name = "c_resource_ids")
    private String resourceIds;

    /**
     * 应用密钥(bcyt) 加密
     */
    @Column(name = "c_client_secret")
    private String clientSecret;

    /**
     * 应用密钥(明文)
     */
    @Column(name = "c_client_secret_str")
    private String clientSecretStr;

    /**
     * 范围
     */
    @Column(name = "c_scope")
    private String scope;

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    @Column(name = "c_grant_types")
    private String grantTypes;

    /**
     * 回调地址
     */
    @Column(name = "c_redirect_url")
    private String redirectUrl;

    /**
     * 权限
     */
    @Column(name = "c_authorities")
    private String authorities;

    /**
     * access_token有效期
     */
    @Column(name = "n_access_token_validity")
    private Integer accessTokenValidity;

    /**
     * refresh_token有效期
     */
    @Column(name = "n_refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 是否自动授权 1 是 2 否
     */
    @Column(name = "c_auto_approve")
    private String autoApprove;

    /**
     * 扩展属性
     */
    @Column(name = "j_ext")
    private String ext;
}