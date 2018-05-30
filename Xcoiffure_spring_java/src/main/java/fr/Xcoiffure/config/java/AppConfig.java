package fr.Xcoiffure.config.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.Xcoiffure.config.jpa.JpaConfig;


@Configuration
@Import({ JpaConfig.class })
public class AppConfig
{

}