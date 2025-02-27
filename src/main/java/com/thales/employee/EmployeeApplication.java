package com.thales.employee;

//import java.io.IOException;
//import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add((request, body, execution) -> {
            request.getHeaders().add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            request.getHeaders().add("Accept", "application/json, text/javascript, */*; q=0.01");
            request.getHeaders().add("Referer", "http://dummy.restapiexample.com/");
            request.getHeaders().add("Origin", "http://dummy.restapiexample.com");
            request.getHeaders().add("Connection", "keep-alive");
            request.getHeaders().add("Cookie", "humans_21909=1");

            return execution.execute(request, body);
        });

        restTemplate.setInterceptors(interceptors);
		
        return restTemplate;
    }
}