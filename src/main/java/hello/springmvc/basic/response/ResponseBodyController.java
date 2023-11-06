package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    } //제일 기본적인 방법 response를 받아 getWrite로 하는 방법

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String>responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    } //ResponseEcntity를 활용한 방법

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    } //제일 깔끔한 방법

}
