package day63;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 의 Auditing(감시/감사) 기능 활성화
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}