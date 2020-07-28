package top.jiangliuhong.scs.core.bean.res;

import org.springframework.http.HttpStatus;

/**
 *
 * ErrorResponse
 * @description 异常返回结果
 * @author jiangliuhong
 * @date 2020/7/3 10:38
 * @version 1.0.0
 */
public class ErrorResponse {

    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode(){
        if(this.status != null){
            return this.status.value();
        }
        return null;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
