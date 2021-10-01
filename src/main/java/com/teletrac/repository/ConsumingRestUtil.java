package com.teletrac.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumingRestUtil {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestUtil.class);

	@Bean
	public static RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public static MarketList getMarkets(RestTemplate restTemplate) throws Exception {

		MarketList mackets = restTemplate.getForObject("https://www.cryptingup.com/api/markets", MarketList.class);
		return mackets;
	}
}
