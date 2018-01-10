package mariuszjaczewski.repository_rest.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

 @Configuration
 @EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("user1").roles("USER")
                .and()
                .withUser("user2").password("user2").roles("USER", "ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               // .httpBasic()
                //.and()
                //.csrf()
                //.disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/**").hasRole("ADMIN")
                .antMatchers("/pages/NewAdvertisment.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().loginPage("/pages/login.html");

    }



//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configAutentication(AutenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication().dataSorce(dataSource).passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(
//                        "select username, password, enabled from users where username=?")
//                .authoritiesByUsernameQuery(
//                        "select u.username, r.name from user_roles ur, users u, roles r where u.username=? and u.user_id = ur.user_id and ur.role_id = r.role_id");
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.autorizeReguest()
//                .antMathers("/resources/**").permitAll()
//                   .anyRequest().autenticated()
//                   .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .permitAll().and().rememberMe().
//                        tokenValiditySeconds(1209600).and().csrf().disable();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }
}
