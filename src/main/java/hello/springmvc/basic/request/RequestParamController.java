package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={},age={}", username, age); //log를 만들어줘야 제대로 작동했는지 확인가능
        //void면서 response값에 써버리면 그대로
        response.getWriter().write("ok"); //IOException이 생길수있어서 예외처리가 필요함
    }

    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName, //Param Http요청이름 ,String에는 내가 정한 변수이름
            @RequestParam("age") int memberAge
    ) {
        log.info("username = {}, age={}", memberName, memberAge);

        return "ok";

    }

    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, //타입을 같게하면 생략가능
            @RequestParam int age
    ) {
        log.info("username = {}, age={}", username, age);
        return"ok";
    }
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age//파라미터 요청값이랑 맞아야함
    ) {
        log.info("username = {}, age={}", username, age); //단순한 int, integer등 값이면 requsetParam도 생략가능
        return"ok";
    }
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //타입을 같게하면 생략가능 required는 필수조건
            @RequestParam(required = false) Integer age) { //Integer로 설정을 해서 null값도 받을수있게 함
        log.info("username = {}, age={}", username, age);
        //null과 ""은 다른것
        return"ok";
    }



}
