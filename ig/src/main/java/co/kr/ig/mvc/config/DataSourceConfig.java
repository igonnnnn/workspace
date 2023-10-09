package co.kr.ig.mvc.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.kr.ig.mvc.core.dao.CoreMapperDAO;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/properties/database.properties")
public class DataSourceConfig {
	@Autowired
	private Environment env;

	@Bean(name="orclDataSource", destroyMethod = "close")
	public DataSource orclDataSource () {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);
		return jdsl.getDataSource(env.getProperty("database.jndi.orcl"));
	}

	@Bean(name="mysqlDataSource", destroyMethod = "close")
	public DataSource mysqlDataSource () {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);

		return jdsl.getDataSource(env.getProperty("database.jndi.mysql"));
	}

	@Bean(name="mariaDataSource", destroyMethod = "close")
	public DataSource mariaDataSource () {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);

		return jdsl.getDataSource(env.getProperty("database.jndi.maria"));
	}


	@Bean(name="orclSessionFactory")
	public SqlSessionFactory orclSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();

		sfb.setDataSource(orclDataSource());
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("databse.sqlmap.classpath.orcl")));

		return sfb.getObject();
	}

	@Bean(name="mysqlSessionFactory")
	public SqlSessionFactory mysqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();

		sfb.setDataSource(mysqlDataSource());
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("databse.sqlmap.classpath.mysql")));

		return sfb.getObject();
	}

	@Bean(name="mariaSessionFactory")
	public SqlSessionFactory mariaSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();

		sfb.setDataSource(mariaDataSource());
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("databse.sqlmap.classpath.maria")));

		return sfb.getObject();
	}

	@Bean("orclMapper")
	@Primary
	public CoreMapperDAO orclMapper() throws Exception {
		SqlSessionTemplate session = new SqlSessionTemplate(orclSessionFactory());
		CoreMapperDAO mapper = new CoreMapperDAO(session);
		return mapper;
	}


	@Bean("mysqlMapper")
	public CoreMapperDAO mysqlMapper() throws Exception {
		SqlSessionTemplate session = new SqlSessionTemplate(mysqlSessionFactory());
		CoreMapperDAO mapper = new CoreMapperDAO(session);
		return mapper;
	}


	@Bean("mariaMapper")
	public CoreMapperDAO mariaMapper() throws Exception {
		SqlSessionTemplate session = new SqlSessionTemplate(mariaSessionFactory());
		CoreMapperDAO mapper = new CoreMapperDAO(session);
		return mapper;
	}
}
