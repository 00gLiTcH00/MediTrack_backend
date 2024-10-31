package smartbits.junior.meditrack.config;

import java.util.List;

//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
public class WebConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .cors(cors -> cors.configurationSource(request -> {
//                    var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
//                    corsConfiguration.setAllowedOrigins(List.of("*"));
//                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "DELETE"));
//                    corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type", "Credentials"));
//                    corsConfiguration.setAllowCredentials(true);
//                    corsConfiguration.setExposedHeaders(List.of("Authorization"));
//                    return corsConfiguration;
//                }))
//                .authorizeHttpRequests(req -> req.anyRequest().permitAll())
//                .build();
//    }
}
