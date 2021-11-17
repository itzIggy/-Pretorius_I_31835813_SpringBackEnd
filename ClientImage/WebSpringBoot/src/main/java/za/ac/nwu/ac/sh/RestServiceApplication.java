package za.ac.nwu.ac.sh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.RepoMember;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RestServiceApplication {

    @Autowired
    private RepoMember repoMember;

    @PostConstruct
    public void initUsers() {
        List<Member> members = Stream.of(
                new Member("Ivan", "Pretorius", "ivan@gmail.com", "0797515646","Ivan123" ),
                new Member("Johan", "Botha", "johan@gmail.com", "0825598653","Johan123" ),
                new Member("Sean", "Oosthuizen", "sean@gmail.com", "0794463258","Sean123" ),
                new Member("Zian", "DeJager", "zian@gmail.com", "0825789125","Zian123" )
        ).collect(Collectors.toList());
        repoMember.saveAll(members);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    /*@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
                corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                        "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                        "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }*/
}