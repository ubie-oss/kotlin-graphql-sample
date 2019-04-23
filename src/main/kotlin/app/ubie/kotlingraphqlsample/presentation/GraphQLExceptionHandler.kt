package app.ubie.kotlingraphqlsample.presentation

import graphql.GraphQLError
import graphql.servlet.GenericGraphQLError
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler

@Component
class GraphQLExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class, RuntimeException::class)
    fun handleSomeException(e: Throwable): GraphQLError {
        return GenericGraphQLError(e.message)
    }
}