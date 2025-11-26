package com.github.lume.api.api;

import com.github.lume.api.api.security.DotenvInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class LumeApplication {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LumeApplication.class);
        app.addInitializers(new DotenvInitializer());

        ConfigurableEnvironment env = app.run(args).getEnvironment();
	}

}
