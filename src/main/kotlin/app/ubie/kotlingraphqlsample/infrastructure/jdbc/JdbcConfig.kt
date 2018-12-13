package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
class JdbcConfig {

    @Bean
    fun dataSource(properties: DataSourceProperties): DataSource {
        return properties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
    }

    @Bean
    fun namedParameterJdbcTemplate(dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}