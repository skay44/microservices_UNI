package aui.skay44.lab3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
public class SpaceMiningGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceMiningGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${rpg.miningDrills.url}") String miningDrills,
			@Value("${rpg.asteroidss.url}") String asteroids,
			@Value("${rpg.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("asteroids", route -> route
						.host(host)
						.and()
						.path(
								"/api/asteroid/{uuid}",
								"/api/asteroids"
						)
						.uri(asteroids)
				)
				.route("miningDrills", route -> route
						.host(host)
						.and()
						.path(
								"/api/miningDrills",
								"/api/miningDrill/**",
								"/api/users/{uuid}/miningDrills",
								"/api/users/{uuid}/miningDrills/**",
								"/api/asteroid/{uuid}/drills",
								"/api/asteroid/{uuid}/drills/**"
						)
						.uri(miningDrills)
				)
				.build();
	}
}
