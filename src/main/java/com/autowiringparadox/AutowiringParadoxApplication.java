package com.autowiringparadox;

import com.autowiringparadox.dto.Data;
import com.autowiringparadox.service.MethodProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutowiringParadoxApplication {

	@Autowired
    MethodProviderService autowiredMethodProviderService;

	private static Logger logger = LoggerFactory.getLogger(AutowiringParadoxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AutowiringParadoxApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			MethodProviderService contextedMethodProviderService =(MethodProviderService) ctx.getBean("method");
			MethodProviderService methodProviderService = new MethodProviderService();
			Data data = new Data(2,4);

			logger.info("Autowired output - {} (notice the logging done via aspect for this case)",autowiredMethodProviderService.power(data));
			logger.info("\'Context-ed\' output - {} (notice the logging done via aspect for this case)",contextedMethodProviderService.power(data));
			logger.info("Normal output - {} (notice that there no logging aspects in this case)",methodProviderService.power(data));


		};
	}
}
