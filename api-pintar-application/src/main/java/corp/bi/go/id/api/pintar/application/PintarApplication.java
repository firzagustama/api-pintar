package corp.bi.go.id.api.pintar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "corp.bi.go.id.api.pintar.facade",
        "corp.bi.go.id.api.pintar.service",
})
public class PintarApplication {
    public static void main(String[] args) {
        SpringApplication.run(PintarApplication.class, args);
    }
}
