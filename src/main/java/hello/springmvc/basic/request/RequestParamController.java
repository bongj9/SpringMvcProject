package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        return "ok";
    }

    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age//파라미터 요청값이랑 맞아야함
    ) {
        log.info("username = {}, age={}", username, age); //단순한 int, integer등 값이면 requsetParam도 생략가능
        return "ok";
    }

    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //타입을 같게하면 생략가능 required는 필수조건
            @RequestParam(required = false) Integer age) { //Integer로 설정을 해서 null값도 받을수있게 함
        log.info("username = {}, age={}", username, age);
        //null과 ""은 다른것
        return "ok";
    }

    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //default값이 있으면 required는 굳이 필요가 없다
            @RequestParam(required = false, defaultValue = "-1") int age) { //값이 없어도되니 int로 써두되고 없으면 -1으로 나
        log.info("username = {}, age={}", username, age);
        //null과 ""은 다른것
        return "ok";
    }

    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username = {}, age={}", paramMap.get("username"), paramMap.get("age"));
        {
            //null과 ""은 다른것
            return "ok";
        }
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData hellodata) {


        /*(@RequestParam String username, @RequestParam int age) {
        HelloData hellodata = new HelloData();
        hellodata.setUsername(username);
        hellodata.setAge(age);*/
        log.info("username ={},age={}", hellodata.getUsername(), hellodata.getAge());
/*
        log.info("helloDate={}", hellodata);
*/
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData hellodata) {
        log.info("username ={},age={}", hellodata.getUsername(), hellodata.getAge());
        return "ok";             //@ModelAttribute를 뺴도 된다
    }
}