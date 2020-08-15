package top.jiangliuhong.scs.core.exception;

import java.nio.file.AccessDeniedException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.jiangliuhong.scs.common.bean.res.ErrorResponse;
import top.jiangliuhong.scs.common.exception.NotFoundException;

/**
 *
 * ScsExceptionAdvice
 *
 * @description 统一异常处理
 * @author jiangliuhong
 * @date 2020/7/3 10:38
 * @version 1.0.0
 */
@ControllerAdvice({"top.jiangliuhong.scs"})
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ScsExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ScsExceptionAdvice.class);

    /**
     * 异常拦截
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        HttpStatus status;
        if (exception instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (exception instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponse error = new ErrorResponse();
        error.setCode(status.value());
        error.setMessage(exception.getMessage());
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        logger.error(stackTrace);
        return ResponseEntity.status(status).body(error);
    }
}
