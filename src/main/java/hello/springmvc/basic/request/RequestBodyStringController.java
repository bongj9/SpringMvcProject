package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {
    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();  //IOexception 추가해줘야함
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//byteCode로 문자를 받을때는 항상 어떤 인코딩으로 받을지 명시해야함

        log.info("messagebody={}", messageBody);

        response.getWriter().write("ok");

    }
    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//byteCode로 문자를 받을때는 항상 어떤 인코딩으로 받을지 명시해야함

        log.info("messagebody={}", messageBody);

        responseWriter.write("ok");

    }
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();
        log.info("messagebody={}", messageBody);

        return new HttpEntity<>("ok");
    }
}
