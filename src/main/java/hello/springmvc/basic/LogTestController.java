package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
/*
    private final Logger log = LoggerFactory.getLogger(getClass()); Slf4j가 이역할을 대신한다.
*/

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
//로컬서버에서 개발하는데 모든 로그를 보고싶다면 properties로 들어간니
        System.out.println("name = " + name);
        log.trace("trace.log={}",name); //trace debug는 로그가 안남는다
        log.debug("debug.log={}",name);
        log.info("info.log={}", name);
        log.warn("warn.log={}",name);
        log.error("error.log={}",name);


        return "ok"; // RestController를 사용하면 리턴값에 문자열을 적으면 그게 자동으로 반환된다.html 바디에 바로 주입한다.
    }
}
