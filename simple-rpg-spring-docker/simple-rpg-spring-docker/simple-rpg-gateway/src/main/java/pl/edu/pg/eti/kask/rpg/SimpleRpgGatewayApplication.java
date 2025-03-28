package pl.edu.pg.eti.kask.rpg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SimpleRpgGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRpgGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${rpg.character.url}") String characterUrl,
            @Value("${rpg.profession.url}") String professionUrl,
            @Value("${rpg.user.url}") String userUrl,
            @Value("${rpg.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("users", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/users/{uuid}",
                                "/api/users"
                        )
                        .uri(userUrl)
                )
                .route("professions", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/professions/{uuid}",
                                "/api/professions"
                        )
                        .uri(professionUrl)
                )
                .route("characters", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/characters",
                                "/api/characters/**",
                                "/api/users/{uuid}/characters",
                                "/api/users/{uuid}/characters/**",
                                "/api/professions/{uuid}/characters",
                                "/api/professions/{uuid}/characters/**"
                        )
                        .uri(characterUrl)
                )
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
