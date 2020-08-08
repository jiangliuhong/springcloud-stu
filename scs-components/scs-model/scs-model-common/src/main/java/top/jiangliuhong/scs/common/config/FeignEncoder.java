package top.jiangliuhong.scs.common.config;

import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.openfeign.encoding.HttpEncoding;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;

import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * 
 * FeignEncoder
 * 
 * @description 自定义request编码器，处理get的requestbody和dto参数情况
 * @author jiangliuhong
 * @date 2020/8/8 15:29
 * @version 1.0.0
 */
public class FeignEncoder extends SpringFormEncoder {

    /**
     * 构造函数
     */
    public FeignEncoder() {
        this(new Encoder.Default());
    }

    /**
     * 构造函数
     * 
     * @param delegate delegate
     */
    public FeignEncoder(Encoder delegate) {
        super(delegate);
    }

    @Override
    public void encode(Object requestBody, Type bodyType, RequestTemplate template) {

        Collection<String> contentTypes = template.headers().get(HttpEncoding.CONTENT_TYPE);
        // 没有指定contenttype,并且参数不为空，并且非lang包下的类
        if (requestBody != null && CollectionUtils.isEmpty(contentTypes)
            && !StringUtils.startsWith(bodyType.getTypeName(), "java.lang")) {
            template.header(HttpEncoding.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }

        super.encode(requestBody, bodyType, template);
    }
}
