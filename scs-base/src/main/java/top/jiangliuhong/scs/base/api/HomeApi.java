package top.jiangliuhong.scs.base.api;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @Value(value = "${scs.datasource.ip}")
    private String ip;

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("index:" + ip);
    }
}
