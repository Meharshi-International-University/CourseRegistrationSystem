package courseRegistrationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SecurityConfiguration {


//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests()
//                    .requestMatchers("/registration-events/").hasRole("ADMIN")
//                     .requestMatchers("/registration-events/student/**",
//                             "/registration-requests/**","/registrations/").hasRole("USER")
//                    .requestMatchers("/email-list/").permitAll().
//                    anyRequest().authenticated();
//            http.addFilterBefore(
//            //        jwtTokenFilter,
//                    UsernamePasswordAuthenticationFilter.class
//            );
//            return http.build();
//        }
////            @Bean
////            public InMemoryUserDetailsManager userDetailsService() {
////            List<UserDetails> users = User.withDefaultPasswordEncoder()
////                        .username("student")
////                        .password("student")
////                        .roles("USER")
////                        ;
////                return new InMemoryUserDetailsManager(users);
////            }
//
//    @Bean
//    public UserDetailsService users() {
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("student")
//                .password("student")
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    }

