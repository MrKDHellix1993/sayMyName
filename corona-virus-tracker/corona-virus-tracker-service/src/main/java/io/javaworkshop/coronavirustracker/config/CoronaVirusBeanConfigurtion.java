package io.javaworkshop.coronavirustracker.config;

import org.springframework.context.annotation.Bean;

import io.javaworkshop.coronavirustracker.models.CoronaVirsuStatSummay;


public class CoronaVirusBeanConfigurtion {

	@Bean
	public CoronaVirsuStatSummay getCoronaVirsuStatSummayObj() {
		return new CoronaVirsuStatSummay();
	}

}
