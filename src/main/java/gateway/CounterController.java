package gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@SpringBootApplication
public class CounterController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private Environment env;
    @GetMapping("/")
    public String indexCounterApp() {
        return  "Welcome to Counter App";
    }
    @GetMapping("/counter")
    public String getCounter() {
        return counter.incrementAndGet() + "";
    }
    @PostMapping("/counter")
    public String postCounter() {
        counter.incrementAndGet();
        return counter.incrementAndGet()  + "";
    }
    @DeleteMapping("/counter")
    public String deleteCounter() {
        return counter.decrementAndGet() + "";
    }
    @GetMapping("/info")
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("git commit hash: ").append("hashcode").append(System.getProperty("line.separator"));
        sb.append("branch name of the source code: ").append("master").append(System.getProperty("line.separator"));
        sb.append("environment name of the app: ").append(env.getProperty("app.name")).append(System.getProperty("line.separator"));
        sb.append("hostname: ").append("localhost:8080").append(System.getProperty("line.separator"));
        return sb.toString();
    }
    public static void main(String[] args) {
        SpringApplication.run(CounterController.class, args);
    }
}
