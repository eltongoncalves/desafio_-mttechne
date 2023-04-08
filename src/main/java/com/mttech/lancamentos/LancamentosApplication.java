package com.mttech.lancamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mttech.lancamentos.entity"})
@EnableJpaRepositories("com.mttech.lancamentos.repository")
public class LancamentosApplication {

    public static void main(String[] args) {
        SpringApplication.run(LancamentosApplication.class, args);
    }

}
