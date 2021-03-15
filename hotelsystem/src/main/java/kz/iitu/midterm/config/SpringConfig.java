package kz.iitu.midterm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "kz.iitu.midterm")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.iitu.midterm.repository")
public class SpringConfig {
}
