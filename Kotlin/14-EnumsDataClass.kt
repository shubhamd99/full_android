fun main() {
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(result = Repository.getCurrentState())
    Repository.error()
    getResult(result = Repository.getCurrentState())
}

fun getResult(result: Result) {
    return when (result) {
        is Error -> {
            println(result.exception)
        }
        is Success -> {
            println(result.dataFetched)
        }
        is Loading -> {
            println("loading...")
        }
        is NotLoading -> {
            println("Idle")
        }
        else -> println("N/A")
    }
}

abstract class Result

data class Success(val dataFetched: String?) : Result()

data class Error(val exception: Exception) : Result()

object NotLoading : Result()

object Loading : Result()

// This class doesn't create too many instances itself
// Not allowed to create many instances with object keyword
object Repository {
    private var loadState: Result = NotLoading
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Loading
        dataFetched = "data data"
    }

    fun finishedFetch() {
        loadState = Success(dataFetched)
        dataFetched = null
    }

    fun error() {
        loadState = Error(exception = Exception("Error"))
    }

    fun getCurrentState(): Result {
        return loadState
    }
}
