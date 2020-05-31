package gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@SpringBootApplication
public class CounterController {

    private final AtomicLong counter = new AtomicLong();

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
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(CounterController.class, args);
    }

}
