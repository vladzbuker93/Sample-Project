package dto.common

sealed class Result<Res>
class Failure<Res>(val apiError: ApiError) : Result<Res>()
class Success<Res>(val response: Res) : Result<Res>()

val <Res> Result<Res>.response: Res?
    get() = when (this) {
        is Success -> this.response
        else -> null
    }

suspend fun <Res> Result<Res>.onSuccess(onSuccess: suspend (Res) -> Unit): Result<Res> {
    if (this is Success) {
        onSuccess(response)
    }
    return this
}

suspend fun <Res> Result<Res>.onFailure(onFailure: suspend (ApiError) -> Unit): Result<Res> {
    if (this is Failure) {
        onFailure(apiError)
    }
    return this
}

fun <Res, T> Result<Res>.map(onSuccess: (Res) -> T): Result<T> {
    return when (this) {
        is Success -> Success(onSuccess(this.response))
        is Failure -> Failure(this.apiError)
    }
}