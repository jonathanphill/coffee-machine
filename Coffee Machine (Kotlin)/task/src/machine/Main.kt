package machine

fun main() {
    var waterQty = 0
    var milkQty = 0
    var coffeeBeans = 0
    var numberOfCups = 0


    val initialState = mutableMapOf(
        "waterQty" to 400,
        "milkQty" to 540,
        "coffeeBeans" to 120,
        "numberOfCups" to 9,
        "openingBalance" to 550
    )
    val currentState = machineStatus(initialState)
    println()
    println("Write action(buy, fill, take):")
    val userInput = readln()
    var coffeeTypeOption = 0
    if (userInput == "buy") {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        try {
            coffeeTypeOption = readln().toInt()
            when (coffeeTypeOption) {

                1 -> makeEspresso(currentState)
                2 -> makeLatte(currentState)
                3 -> makeCappuccino(currentState)
            }
        } catch (e: Exception) {
            println(e.message)
        }

    } else if (userInput == "fill") {

        println("Write how many ml of water you want to add:")
        waterQty = readln().toInt()
        println("Write how many ml of milk you want to add:")
        milkQty = readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans = readln().toInt()
        println("Write how many disposable cups you want to add:")
        numberOfCups = readln().toInt()
        println()
        machineStatus(fillMachine(initialState, waterQty, milkQty, coffeeBeans, numberOfCups))

    } else if (userInput == "take") {
        println("I gave you $${initialState.getValue("openingBalance")}")
        println()
        initialState.put("openingBalance", 0)
        machineStatus(initialState)

    }

}

fun fillMachine(
    currentState: MutableMap<String, Int>,
    waterQty: Int,
    milkQty: Int,
    coffeeBeans: Int,
    cup: Int
): MutableMap<String, Int> {
    return currentState.toMutableMap().apply {
        // Update water quantity
        put("waterQty", getValue("waterQty") + waterQty)
        // Update milk quantity
        put("milkQty", getValue("milkQty") + milkQty)
        // Update coffee beans quantity
        put("coffeeBeans", getValue("coffeeBeans") + coffeeBeans)
        // Increase the number of cups available
        put("numberOfCups", getValue("numberOfCups") + cup)
    }
}


fun makeDrink(
    currentState: MutableMap<String, Int>,
    waterQty: Int,
    milkQty: Int,
    coffeeBeans: Int,
    cost: Int
): MutableMap<String, Int> {
    return currentState.toMutableMap().apply {
        // Update water quantity
        put("waterQty", getValue("waterQty") - waterQty)
        // Update milk quantity
        put("milkQty", getValue("milkQty") - milkQty)
        // Update coffee beans quantity
        put("coffeeBeans", getValue("coffeeBeans") - coffeeBeans)
        // Decrease the number of cups available
        put("numberOfCups", getValue("numberOfCups") - 1)
        // Add to the opening balance since the drink was sold
        put("openingBalance", getValue("openingBalance") + cost)
    }
}


fun makeLatte(currentState: MutableMap<String, Int>) {
    val updatedState = makeDrink(currentState, 350, 75, 20, 7)
    println()
    machineStatus(updatedState)
}

fun makeCappuccino(currentState: MutableMap<String, Int>) {
    val updatedState = makeDrink(currentState, 200, 100, 12, 6)
    println()
    machineStatus(updatedState)
}

fun makeEspresso(currentState: MutableMap<String, Int>) {
    val updatedState = makeDrink(currentState, 250, 0, 16, 4)
    println()
    machineStatus(updatedState)
}

fun machineStatus(coffeeMachineState: MutableMap<String, Int>): MutableMap<String, Int> {
    var currentSate = mutableMapOf<String, Int>()
    currentSate = coffeeMachineState
    println("The coffee machine has:")
    println("${coffeeMachineState["waterQty"]} ml of water")
    println("${coffeeMachineState["milkQty"]} ml of milk")
    println("${coffeeMachineState["coffeeBeans"]} g of coffee beans")
    println("${coffeeMachineState["numberOfCups"]} disposable cups")
    println("$${coffeeMachineState["openingBalance"]} of money")

    return currentSate

}
