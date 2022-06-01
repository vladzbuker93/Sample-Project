package repository.base

import dto.common.ApiError
import dto.common.Failure
import dto.common.Success
import dto.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    protected suspend fun <T> withCtxResult(
        onError: suspend (ApiError) -> ApiError,
        onSuccess: suspend () -> T
    ): Result<T> {
        return try {
            withContext(Dispatchers.IO) {
                Success(onSuccess())
            }
        } catch (exception: Exception) {
//            var error: ApiError? = if (exception is HttpException) {
//                mapErrorBody(
//                    exception.response()?.errorBody()?.byteStream()?.readBytes()
//                        ?.let { String(it) })
//            } else {
//                null
//            }
//
//            if (error == null) {
//                error = ApiError()
//            }

//            if (onError(error)) {
//                broadcastError(error)
//            }
            Failure(onError(ApiError()))
        }
    }

    private fun mapErrorBody(): ApiError {
        return ApiError()
    }
}