package pers.jarome.scs.act.rs.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

}
