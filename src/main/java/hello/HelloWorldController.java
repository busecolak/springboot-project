package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello() {
        return new Greeting(counter.incrementAndGet(), String.format(template, "Stranger"));
    }
    
    @GetMapping("/hello-world/{name}")
    @ResponseBody
    public Greeting sayHello(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}