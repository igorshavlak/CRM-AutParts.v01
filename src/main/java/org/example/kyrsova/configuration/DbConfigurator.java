package org.example.kyrsova.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbConfigurator {

        @Bean
        @Qualifier("postgresDb")
        public HikariDataSource dataSource(@Value("${spring.datasource.hikari.username}") String username,
                                           @Value("${spring.datasource.hikari.password}") String password,
                                           @Value("${spring.datasource.hikari.driver-class-name}") String driver,
                                           @Value("${spring.datasource.hikari.jdbc-url}") String url) {

            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(driver);
            hikariConfig.setJdbcUrl(url);
            hikariConfig.setUsername(username);
            hikariConfig.setPassword(password);
            return new HikariDataSource(hikariConfig);
        }

        @Bean("myPostgresDb")
        public JdbcTemplate researchCenterNamedJdbc(@Qualifier("postgresDb") HikariDataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }


        @Bean(initMethod = "migrate")
        public Flyway flyway(@Qualifier("postgresDb") HikariDataSource dataSource) {
            return Flyway.configure()
                    .dataSource(dataSource)
                    .outOfOrder(true)
                    .locations("classpath:/db_migrations")
                    .cleanDisabled(true)
                    .baselineOnMigrate(true)
                    .load();
        }


}
