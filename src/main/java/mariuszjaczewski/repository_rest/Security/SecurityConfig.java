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
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.sql.DataSource;





@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



//    DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .httpBasic()
//                .and()
                 .csrf()
                 .disable()
                .authorizeRequests()
               // .antMatchers(HttpMethod.GET,"/api/**").hasRole("ADMIN")
                //.antMatchers("/pages/NewAdvertisment.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().loginPage("/pages/login.html")
                .and()
                .httpBasic().and()




        ;






}



//                .loginProcessingUrl("/logging")
//                .usernameParameter("login")
//               .passwordParameter("password")

        ;
//System.err.println(login+" "+password);



//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(
//                        "select username, password, enabled from users where username=?")
//                .authoritiesByUsernameQuery(
//                        "select u.username, r.name from user_roles ur, users u, roles r where u.username=? and u.user_id = ur.user_id and ur.role_id = r.role_id");
//    }
}
