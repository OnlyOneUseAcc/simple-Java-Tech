package SecondLesson

/**
 * Method to test null param
 * (possible)
 * @param temp any Integer number
 * @return temp
 */
def Integer toInteger(Integer temp){
    return temp
}

/**
 * Method to test null param
 * (impossible)
 * @param temp any Integer number
 * @return temp
 */
def int toInt(int temp) {
    return temp
}

println " try to get null - ${toInteger(null)}"
//println " try to get null - ${toInt(null)}"

BigDecimal decimal1 = new BigDecimal(108963)
BigDecimal decimal2 = new BigDecimal(108963)

println("comparing1: ${decimal1 == decimal2}")
println("comparing2: ${decimal1.equals(decimal2)}")

def answer = decimal1.add(decimal2)
println "${answer} - using add"
println("${decimal1 + decimal2} - using +")

noType = 10
println "${noType} - ${noType.getClass()}"
noType = "First"
println "${noType} - ${noType.getClass()}"

Date dateOne = new Date(2015, 2, 28)
Date dateTwo = new Date(2015, 1, 31)
println "${dateOne - dateTwo} - difference "
dateOne.month += 1 + 1
dateOne.date += 1
println "${dateOne} - after adding"


