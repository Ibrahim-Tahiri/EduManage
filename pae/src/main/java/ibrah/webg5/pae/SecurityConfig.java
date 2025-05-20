package ibrah.webg5.pae;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig {

    @Bean
public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}


    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        // UserDetails user1 = User.withUsername("prof")
        //         .password("{noop}prof")
        //         .authorities("PROF")
        //         .build();

        // UserDetails user2 = User.withUsername("etudiant")
        //         .password("{noop}etudiant")
        //         .authorities("USER")
        //         .build();

        // UserDetails user3 = User.withUsername("secretariat")
        //         .password("{noop}secretariat")
        //         .authorities("SECRETARIAT")
        //         .build();

        // InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

        // users.createUser(user1);
        // users.createUser(user2);
        // users.createUser(user3);

      

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username,password,enabled from my_user where username=?");
        users.setAuthoritiesByUsernameQuery("select id,username,authority from authority where username=?");
        
        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.formLogin(form -> form.loginPage("/login"));
        http.formLogin();
        // http.exceptionHandling(error -> error.accessDeniedPage("/"));


    http.authorizeHttpRequests((authz) -> authz
    .requestMatchers("/").permitAll() 
    .requestMatchers("/css/**").permitAll()
    .requestMatchers("/image/**").permitAll()
    .requestMatchers("/courses/add").hasAnyAuthority("SECRETARIAT") 
    .requestMatchers("/courses/addStudent").hasAnyAuthority("SECRETARIAT")
    .requestMatchers("/students/add").hasAnyAuthority("SECRETARIAT")
    .requestMatchers("/students/addCourse").hasAnyAuthority("SECRETARIAT")
    .requestMatchers("/h2-console/**").permitAll()//acces h2console

    .requestMatchers("/**").authenticated());
    
    
    http.exceptionHandling(error -> error.accessDeniedPage("/"));
    
    http.logout(logout -> logout.logoutSuccessUrl("/"));
    
    return http.build();

}
}
