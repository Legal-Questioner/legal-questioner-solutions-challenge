package io.shaded.legalquestionizer.config;

import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.RowMapperFactory;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JDBIConfig {

  @Bean
  public JdbiPlugin sqlObjectPlugin() {
    return new SqlObjectPlugin();
  }

  @Bean
  public JdbiPlugin postgresPlugin() {
    return new PostgresPlugin();
  }

  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder
      .create()
      .type(HikariDataSource.class)
      .url("jdbc:postgresql://localhost:5432/legal")
      .username("legal")
      .password("legal")
      .build();
  }

  @Bean
  public Jdbi jdbi(DataSource dataSource, List<JdbiPlugin> jdbiPlugins,
                   List<RowMapper<?>> rowMappers,
                   List<RowMapperFactory> rowMapperFactories,
                   List<ColumnMapper<?>> columnMappers) {

    final TransactionAwareDataSourceProxy dataSourceProxy =
      new TransactionAwareDataSourceProxy(dataSource);
    final Jdbi jdbi = Jdbi.create(dataSourceProxy);

    jdbiPlugins.forEach(jdbi::installPlugin);
    rowMappers.forEach(jdbi::registerRowMapper);
    rowMapperFactories.forEach(jdbi::registerRowMapper);
    columnMappers.forEach(jdbi::registerColumnMapper);

    return jdbi;
  }
}
