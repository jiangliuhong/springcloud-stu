package top.jiangliuhong.scs.admin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @GetMapping("/index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("index");
    }
}
