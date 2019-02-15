package app.ubie.kotlingraphqlsample.presentation

import graphql.servlet.DefaultGraphQLContextBuilder
import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLContextBuilder
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.http.HttpServletRequest
import javax.websocket.server.HandshakeRequest

@Configuration
class GraphQLUtil {

    private val log = LoggerFactory.getLogger(GraphQLUtil::class.java)

    class UbieAuthContext(httpServletRequest: HttpServletRequest, val token: String) : GraphQLContext(httpServletRequest) {

    }

    @Bean
    fun contextBuilder() : GraphQLContextBuilder {
        return object : DefaultGraphQLContextBuilder() {
            override fun build(httpServletRequest: HttpServletRequest): GraphQLContext {
                log.error("build(httpServletRequest: HttpServletRequest?)")

                log.error(httpServletRequest.getHeader("authroization"))

                return UbieAuthContext(httpServletRequest, "token!!!")
            }
        }
    }

}