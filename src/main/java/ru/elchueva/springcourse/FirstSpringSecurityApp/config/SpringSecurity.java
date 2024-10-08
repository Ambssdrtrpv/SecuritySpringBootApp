package ru.elchueva.springcourse.FirstSpringSecurityApp.config;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;//
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//            .authorizeRequests(authorize -> authorize
//                    .requestMatchers("/auth/login").permitAll() // Разрешить доступ ко всем к логину
//                    .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
//            )
//            .formLogin((form) -> form
//                    .loginPage("/auth/login")
//                    .loginProcessingUrl("/process_login")
//                    .defaultSuccessUrl("/hello", true)
//                    .failureUrl("/auth/login?error=true")
//                    .permitAll()
//            )
//            .logout((logout) -> logout.permitAll());
//
//    return http.build();
//}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import ru.elchueva.springcourse.FirstSpringSecurityApp.security.AuthProviderImpl;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SpringSecurity implements WebSecurityConfigurer{
//
//    private final AuthProviderImpl authProvider;
//
//    @Autowired
//    public SpringSecurity(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }
//
//    @Override
//    public void init(SecurityBuilder builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(SecurityBuilder builder) throws Exception {
//
//    }
//}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.elchueva.springcourse.FirstSpringSecurityApp.repositories.PeopleRepository;
//import ru.elchueva.springcourse.FirstSpringSecurityApp.services.PersonDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity {
//
//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public SpringSecurity(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers("/public/**").permitAll ()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/hello")
//                .loginPage("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//
//
//    }
//}


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import ru.elchueva.springcourse.FirstSpringSecurityApp.security.AuthProviderImpl;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity {
//
//    private final AuthProviderImpl authProvider;
//
//    public SpringSecurity(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults()); // Используем форму логина по умолчанию
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
//        // Получаем AuthenticationManagerBuilder из AuthenticationConfiguration
//        return authConfig.getAuthenticationManager();
//    }
//}


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import ru.elchueva.springcourse.FirstSpringSecurityApp.security.AuthProviderImpl;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity {
//
//    private final AuthProviderImpl authProvider;
//
//    public SpringSecurity(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
//        // Получаем AuthenticationManagerBuilder из AuthenticationConfiguration
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .requestMatchers("/login").permitAll() // Разрешить доступ ко всем к логину
//                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
//                )
//                .formLogin(form -> form
//                        .loginPage("/login") // Укажите, что это ваша страница логина
//                        .defaultSuccessUrl("/hello", true) // Перенаправление на /hello после успешного входа
//                        .permitAll() // Разрешить доступ к странице логина всем пользователям
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout") // Перенаправление после выхода
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//
//}
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user) ;
//
//    anyRequest().hasAnyRole("ADMIN", "USER")}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.elchueva.springcourse.FirstSpringSecurityApp.services.PersonDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity {


    private final PersonDetailsService personDetailsService;

    @Autowired
    public SpringSecurity(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        //.requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/auth/login", "/error", "/auth/registration").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/auth/login")
                        .defaultSuccessUrl("/hello", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login") // Перенаправление после выхода
                );

        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(personDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

}

