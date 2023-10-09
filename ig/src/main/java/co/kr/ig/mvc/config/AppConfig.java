package co.kr.ig.mvc.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import co.kr.ig.mvc.web.service.impl.BaseServiceImpl;

@Configuration
@ComponentScan(basePackages="co.kr.ig.mvc")
@PropertySources({
	@PropertySource("classpath:/properties/database.properties"),
	@PropertySource("classpath:/properties/spring.properties")
})
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean("commonService")
	public BaseServiceImpl commonService() {
		BaseServiceImpl service = new BaseServiceImpl();

		Map<String, String> mappers = new HashMap<String, String>();

		mappers.put(env.getProperty("spring.service.dao.orcl"), env.getProperty("spring.service.mapper.orcl"));
		mappers.put(env.getProperty("spring.service.dao.mysql"), env.getProperty("spring.service.mapper.mysql"));
		mappers.put(env.getProperty("spring.service.dao.maria"), env.getProperty("spring.service.mapper.maria"));

		service.setMapper(mappers);

		return service;
	}
}
