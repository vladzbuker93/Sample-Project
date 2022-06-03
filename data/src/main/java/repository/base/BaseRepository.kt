package repository.base

import dto.common.ApiError
import dto.common.Failure
import dto.common.Success
import dto.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    protected suspend fun <T> withCtxResult(request: suspend () -> T): Result<T> {
        return try {
            Success(request())
        } catch (exception: Exception) {
            Failure(ApiError(exception))
        }
    }
}