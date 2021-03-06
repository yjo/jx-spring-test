package hello;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    private static final String template = "Hello there, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    void handleFoo(HttpServletResponse response) throws IOException {
        response.sendRedirect("/greeting");
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
