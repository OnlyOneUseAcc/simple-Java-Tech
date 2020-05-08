package ThirdLesson

/**
 * rating of two numbers
 */
def closureRating = { a, b -> return a / b }

/**
 * difference of two number
 */
def closureDifference = { d, c -> return (d - c) }

/**
 * mix of closureDifference and closureRating
 */
def closureGeneral = { a, b, c -> return (closureDifference(closureRating(a, b), c)) }

println closureRating(25, 5)
println closureDifference(10, 2)
println closureGeneral(100, 100, 40)
