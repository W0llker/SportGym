package by.pvt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoderByCrypt() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.DELETE, "/orders/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/orders/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT, "/orders/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.GET, "/orders/").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/shawarmas/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/shawarmas/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT, "/shawarmas/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.DELETE, "/burgers/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST, "/burgers/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT, "/burgers/").hasAuthority("Admin")
                .requestMatchers("/admins/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.DELETE, "/clients/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT, "/clients/").hasAuthority("Admin")
                .requestMatchers(HttpMethod.GET, "/clients/").authenticated());
        return http.build();
    }
}
