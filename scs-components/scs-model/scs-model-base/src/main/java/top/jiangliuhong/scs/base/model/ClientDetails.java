package top.jiangliuhong.scs.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.jiangliuhong.scs.common.model.BaseEntity;

/**
* 
* 数据表db_base.t_client_details映射bean，由Mybaits自动生成工具生成
* @author null
* @date 2020-08-08
*/
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
    @ApiModelProperty("应用标识")
    private String clientId;

    /**
     * 资源限定串(逗号分割)
     */
    @Column(name = "c_resource_ids")
    @ApiModelProperty("资源限定串(逗号分割)")
    private String resourceIds;

    /**
     * 应用密钥(bcyt) 加密
     */
    @Column(name = "c_client_secret")
    @ApiModelProperty("应用密钥(bcyt) 加密")
    private String clientSecret;

    /**
     * 应用密钥(明文)
     */
    @Column(name = "c_client_secret_str")
    @ApiModelProperty("应用密钥(明文)")
    private String clientSecretStr;

    /**
     * 范围
     */
    @Column(name = "c_scope")
    @ApiModelProperty("范围")
    private String scope;

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    @Column(name = "c_grant_types")
    @ApiModelProperty("5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)")
    private String grantTypes;

    /**
     * 回调地址
     */
    @Column(name = "c_redirect_url")
    @ApiModelProperty("回调地址")
    private String redirectUrl;

    /**
     * 权限
     */
    @Column(name = "c_authorities")
    @ApiModelProperty("权限")
    private String authorities;

    /**
     * access_token有效期
     */
    @Column(name = "n_access_token_validity")
    @ApiModelProperty("access_token有效期")
    private Integer accessTokenValidity;

    /**
     * refresh_token有效期
     */
    @Column(name = "n_refresh_token_validity")
    @ApiModelProperty("refresh_token有效期")
    private Integer refreshTokenValidity;

    /**
     * 是否自动授权 1 是 2 否
     */
    @Column(name = "c_auto_approve")
    @ApiModelProperty("是否自动授权 1 是 2 否")
    private String autoApprove;

    /**
     * 扩展属性
     */
    @Column(name = "j_ext")
    @ApiModelProperty("扩展属性")
    private String ext;
}