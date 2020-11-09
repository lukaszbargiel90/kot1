package pl.ke.luba.kot1.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.expression.SecurityExpressionHandler
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Bean
    override fun userDetailsService(): UserDetailsService {

        var user: UserDetails = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("p1")
                .roles("USER")
                .build()

        var admin: UserDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build()

        return InMemoryUserDetailsManager(user, admin)
    }

    override fun configure(http: HttpSecurity) {

        http.
        authorizeRequests().
        antMatchers("/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**").hasRole("ADMIN")
                .and().formLogin()
                .and().logout()
                .and().exceptionHandling().accessDeniedPage("/login")




    }

}