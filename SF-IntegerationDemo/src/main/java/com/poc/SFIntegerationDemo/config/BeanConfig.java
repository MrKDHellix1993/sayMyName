/*
 * package com.poc.SFIntegerationDemo.config;
 * 
 * import org.apache.http.HttpHeaders; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.MediaType; import
 * org.springframework.web.reactive.function.client.WebClient;
 * 
 * @Configuration public class BeanConfig {
 * 
 * 
 * @Bean JavarestApi JavarestApi(JavarestApi javarestApi) { return javarestApi;
 * }
 * 
 * 
 * @Bean WebClient webClient(WebClient webClientBuilder) { webClientBuilder =
 * WebClient.builder().baseUrl("https://ap16.salesforce.com")
 * .defaultHeader(HttpHeaders.CONTENT_TYPE,
 * MediaType.APPLICATION_JSON_VALUE).build(); return webClientBuilder; }
 * 
 * }
 */