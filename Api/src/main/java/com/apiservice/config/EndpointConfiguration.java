package com.apiservice.config;

import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.http.client.HttpClient;
import org.springframework.context.annotation.Bean;

public class EndpointConfiguration {
    String apiUrl;
    public void getProperties()
    {
        apiUrl=ApplicationPropertiesaaa.INSTANCE.getConfig("api.url");

    }
    @Bean
    public HttpClient apiClient(){
        getProperties();
        HttpClient httpClient = CitrusEndpoints.http()
                .client()
                .charset("UTF-8")
                .defaultAcceptHeader(false)
                .requestUrl(apiUrl+"/v2")
                .build();
        return httpClient;
    }

}
