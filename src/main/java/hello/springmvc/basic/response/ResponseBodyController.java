package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    } //제일 기본적인 방법 response를 받아 getWrite로 하는 방법

}
