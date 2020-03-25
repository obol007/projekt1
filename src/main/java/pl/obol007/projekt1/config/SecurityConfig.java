package pl.obol007.projekt1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, active FROM users " +
                        "WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM users " +
                        "WHERE username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                //konfigurujemy od szczegolu do ogolu (jak w try - catch)
                .antMatchers("/").permitAll()
                .antMatchers("/register/*").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/business").hasAuthority("BUSINESS")
                .antMatchers("/client").hasAuthority("CLIENT")
                .anyRequest().authenticated()
                .and()
          .formLogin()
                .loginPage("/login")
                //kod nadmiarowy - username i password to domyslne parametry Spring Security
                .usernameParameter("username")
                .passwordParameter("password")

                //po zalogowaniu przechodzi na strone na ktora chcial wejsc
                .defaultSuccessUrl("/selectRole")
                //po zalogowaniu trafiasz na strone glowna,
//                .defaultSuccessUrl("/", true)
                .and()
          .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .and()
                //formularz do zabezpieczenia przed wymuszaniem danych
           .csrf();
    }


}

