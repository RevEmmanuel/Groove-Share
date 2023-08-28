package org.grooveshare.playlist.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppUtils {

    public static final String ISSUER= "Administrator";

    public static final String SONG_NOT_FOUND = "Song could not be found";

    public static final String PATTERN = "yyyy-MM-dd";

    @Value("${cloudinary_name}")
    private String cloudName;
    @Value("${cloudinary_api_key}")
    private String apiKey;
    @Value("${cloudinary_api_secret}")
    private String apiSecret;


    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name",cloudName,
                        "api_key",apiKey,
                        "api_secret",apiSecret
                )
        );
    }

    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return mapper;
    }

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}

