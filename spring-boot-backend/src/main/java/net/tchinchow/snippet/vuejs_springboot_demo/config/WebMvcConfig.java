package net.tchinchow.snippet.vuejs_springboot_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    VueJsSpringBootConfig config;

    @NonNull
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
        "classpath:/META-INF/resources/",
        "classpath:/resources/",
        "classpath:/static/",
        "classpath:/public/"
    };

    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        SinglePageAppResourceResolver web1 = config.webapp1ResourceResolver();

        registry.addResourceHandler("/webapp", "/webapp/", "/webapp/**").resourceChain(false).addResolver(web1);
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

}
