package ThirdLesson


def closureRating = { a, b -> return a / b }

def closureDifference = { d, c -> return (d - c) }

def closureGeneral = { a, b, c -> return (closureDifference(closureRating(a, b), c)) }

println closureRating(25, 5)
println closureDifference(10, 2)
println closureGeneral(100, 100, 40)
