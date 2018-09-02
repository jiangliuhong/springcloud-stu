package pers.jarome.scs.urp.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.jarome.scs.core.model.Student;

@FeignClient("SCS-STUDENT")
public interface StudentFeign {

    @GetMapping("/addStu")
    public Student addStu(@RequestParam("name") String name,@RequestParam("num")String num);

}
