package com.gusgd.catalogo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite CORS em todos os endpoints
                .allowedOrigins("http://localhost:5173") // URL do seu front-end Vue
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite qualquer cabeçalho
                .allowCredentials(true); // Permite credenciais (cookies, cabeçalhos de autenticação)
    }
}
