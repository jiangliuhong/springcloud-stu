package top.jiangliuhong.scs.gateway.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @GetMapping("")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("这里是网关");
    }
}
