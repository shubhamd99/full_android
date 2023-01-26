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
        Result.SUCCESS -> println("Success!!")
        Result.FAILURE -> println("Failure!!")
        Result.ERROR -> println("Error!!")
        Result.IDLE -> println("Idle!!")
        Result.LOADING -> println("Loading..")
    }
}

// Enumeration is a named list of constants
enum class Result {
    SUCCESS,
    FAILURE,
    ERROR,
    IDLE,
    LOADING
}

// This class doesn't create too many instances itself
// Not allowed to create many instances with object keyword
object Repository {
    private var loadState: Result = Result.FAILURE
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Result.LOADING
        dataFetched = "data"
    }

    fun finishedFetch() {
        loadState = Result.SUCCESS
        dataFetched = null
    }

    fun error() {
        loadState = Result.ERROR
    }

    fun getCurrentState(): Result {
        return loadState
    }
}
