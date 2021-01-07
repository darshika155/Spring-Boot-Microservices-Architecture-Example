package com.example.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "department-service",configuration = {Client2ClientConfiguration.class })
//@RibbonClients(defaultConfiguration = {Client2ClientConfiguration.class })
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate(clientHttpRequestFactory());
	}
	
	private ClientHttpRequestFactory clientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	    factory.setReadTimeout(20000);
	    factory.setConnectTimeout(20000);
	    return factory;
	}
	
}
@Configuration
class Client2ClientConfiguration {

    @Bean
    public IPing ribbonPing() {
        PingUrl pingUrl = new PingUrl();
        pingUrl.setPingAppendString("/actuator/info");
        return pingUrl;
    }

    @Bean
    public IRule ribbonRule() {
        return  new RoundRobinRule();
    }
}