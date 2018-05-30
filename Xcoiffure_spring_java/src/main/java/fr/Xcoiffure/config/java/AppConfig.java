package fr.Xcoiffure.config.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan({ "fr.formation.service" })
@Import({ JpaConfig.class })
public class AppConfig
{

}