package trilha.back.financys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;

//@EntityScan(basePackages = ("trilha.back.financys.entities")) //onde que está nossas entidades
//@ComponentScan(basePackages = ("controller"))
//@Component

@SpringBootApplication

public class FinancysApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);
		
	}

	
}
