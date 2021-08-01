package br.com.zup.edu.proposta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.GET, "/api/v1/biometrias/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.GET, "/api/v1/propostas/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.GET, "/api/v1/cartoes/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.POST, "/api/v1/propostas/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.POST, "/api/v1/biometrias/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.POST, "/api/v1/cartoes/**").hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                        .anyRequest().authenticated()
        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}
