package net.tchinchow.snippet.vuejs_springboot_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class VueJsSpringBootConfig {
    @Value("${webapp.publicdir:/webapp/}")
    @NonNull
    @SuppressWarnings("null")
    private String publicdir;


    // @Value("${vuejs_springboot_demo.staticDir:/webapp/}")
    // private String webapp1;

    @Bean
    @NonNull
    SinglePageAppResourceResolver webapp1ResourceResolver() {
        final SinglePageAppResourceResolver tmpVueResolver = new SinglePageAppResourceResolver();
        tmpVueResolver.setPublicPathLocation(publicdir);
        return tmpVueResolver;
    }
}
