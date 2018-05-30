package fr.Xcoiffure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan({ "fr.formation.service" })
@Import({ JpaConfig.class })
public class AppConfig
{

}