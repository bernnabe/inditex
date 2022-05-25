package ar.com.inditex.prices;

import ar.com.inditex.prices.repository.PriceRepository;
import ar.com.inditex.prices.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@EnableSwagger2
//@EnableCircuitBreaker
public class PricesApplication {

    public static void main(String[] args) {

        SpringApplication.run(PricesApplication.class, args);

    }

    @Bean
    CommandLineRunner initDatabase(PriceService service) {
        return args -> {
            service.loadInitialData();
        };
    }
}
