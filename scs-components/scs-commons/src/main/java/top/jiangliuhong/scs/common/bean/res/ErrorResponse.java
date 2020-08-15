package top.jiangliuhong.scs.common.bean.res;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * ErrorResponse
 * 
 * @description 异常返回结果
 * @author jiangliuhong
 * @date 2020/7/3 10:38
 * @version 1.0.0
 */
@Getter
@Setter
public class ErrorResponse {
    /** 状态码 */
    private int code;
    /** 异常信息 */
    private String message;

}
