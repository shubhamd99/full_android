// Sealed classes and interfaces represent restricted class hierarchies that provide more control
// over inheritance
// All direct subclasses of a sealed class are known at compile time.
// No other subclasses may appear outside a module within which the sealed class is defined

fun main() {
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(result = Repository.getCurrentState())
    Repository.error()
    getResult(result = Repository.getCurrentState())
    Repository.customFailure()
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
        is Failure.CustomFailure -> {
            println(result.customFailure.toString())
        }

    // else -> println("N/A") -> No need of else in case of sealed class
    }
}

sealed class Result

data class Success(val dataFetched: String?) : Result()

data class Error(val exception: Exception) : Result()

object NotLoading : Result()

object Loading : Result()

sealed class Failure : Result() {
    data class CustomFailure(val customFailure: NullPointerException) : Failure()
}

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
    fun customFailure() {
        loadState = Failure.CustomFailure(NullPointerException("Something went wrong"))
    }
}
