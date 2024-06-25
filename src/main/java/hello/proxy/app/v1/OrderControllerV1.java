package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RestController // 스프링 @Controller 또는 @RequestMapping 있어야 스프링 컨트롤러로 인식
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
