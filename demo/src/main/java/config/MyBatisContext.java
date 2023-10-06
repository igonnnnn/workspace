package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class MyBatisContext {

	private ApplicationContext applicationContext;

	@Bean
	@Qualifier("orclSqlSessionFactory")
	public SqlSessionFactory orclSqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();

		sfb.setDataSource(dataSource);
		sfb.setDatabaseIdProvider(null);
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlmap/**/*.xml"));

		return sfb.getObject();
	}

	@Bean
	@Qualifier("orclSqlSession")
	public SqlSessionTemplate orclSqlSession(@Qualifier("orclSqlSessionFactory") SqlSessionFactory sf) {
		return new SqlSessionTemplate(sf);
	}

	@Bean
	@Qualifier("orclTxManager")
	public DataSourceTransactionManager orclTxManager(@Qualifier("oracleDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Qualifier("mysqlSqlSessionFactory")
	public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		
		sfb.setDataSource(dataSource);
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlmap/**/*.xml"));
		
		return sfb.getObject();
	}

	@Bean
	@Qualifier("mysqlSqlSession")
	public SqlSessionTemplate mysqlSqlSession(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sf) {
		return new SqlSessionTemplate(sf);
	}

	@Bean
	@Qualifier("mssqlSqlSessionFactory")
	public SqlSessionFactory mssqlSqlSessionFactory(@Qualifier("mssqlDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();

		sfb.setDataSource(dataSource);
		sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlmap/**/*.xml"));
		
		return sfb.getObject();
	}

	@Bean
	@Qualifier("mssqlSqlSession")
	public SqlSessionTemplate mssqlSqlSession(@Qualifier("mssqlSqlSessionFactory") SqlSessionFactory sf) {
		return new SqlSessionTemplate(sf);
	}
}
