package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DataSourceContext {
	
	@Bean(destroyMethod = "close")
	@Qualifier("oracleDataSource")
	public DataSource oracleDataSource() {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);

		return jdsl.getDataSource("jdbc/orcl");

	}

	@Bean(destroyMethod = "close")
	@Qualifier("mysqlDataSource")
	public DataSource mysqlDataSource() {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);

		return jdsl.getDataSource("jdbc/mysql");

	}

	@Bean(destroyMethod = "close")
	@Qualifier("mssqlDataSource")
	public DataSource mssqlDataSource() {
		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
		jdsl.setResourceRef(true);

		return jdsl.getDataSource("jdbc/mssql");

	}
}
