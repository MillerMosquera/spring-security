package com.example.springsecurity.config;import lombok.RequiredArgsConstructor;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.security.authentication.AuthenticationManager;import org.springframework.security.authentication.AuthenticationProvider;import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;import org.springframework.security.config.http.SessionCreationPolicy;import org.springframework.security.web.SecurityFilterChain;import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;import org.springframework.security.web.util.matcher.AntPathRequestMatcher;import org.springframework.security.web.util.matcher.OrRequestMatcher;import org.springframework.security.web.util.matcher.RequestMatcher;import org.springframework.web.bind.annotation.RequestMapping;@Configuration@EnableWebSecurity@RequiredArgsConstructor@EnableMethodSecuritypublic class SecurityConfig {    @Autowired    private final JwtFilter jwtFilter;    @Autowired    private final AuthenticationProvider authenticationProvider;    @Bean    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {        httpSecurity.csrf(csrf -> csrf.disable())                .authorizeHttpRequests(authorize -> authorize                        .requestMatchers(publicEndPoints()).permitAll()                        .anyRequest().authenticated())                .sessionManagement(session -> session                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))                .authenticationProvider(authenticationProvider)                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);        return httpSecurity.build();    }    private RequestMatcher publicEndPoints() {        return new OrRequestMatcher(                new AntPathRequestMatcher("/api/greeting/sayHelloPublic"),                new AntPathRequestMatcher("/api/auth/**")        );    }}