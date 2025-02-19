package machine

fun main() {
    var coffeeMachine = CoffeeMachine()

    while (coffeeMachine.isOn) {
        coffeeMachine.askActionMenu()
        val userInput = readln()
        when (userInput) {
            "remaining" -> coffeeMachine.machineStatus()
            "fill" -> coffeeMachine.fillMenu()
            "buy" -> coffeeMachine.buy()
            "take" -> coffeeMachine.give()
            "exit" -> coffeeMachine.isOn = false
            else -> println("Incorrect action selected")
        }


    }


}

class CoffeeMachine {
    private var waterQty: Int = 400
    private var milkQty: Int = 540
    private var coffeeBeans: Int = 120
    private var cups: Int = 9
    private var balance: Int
    var isOn: Boolean

    init {
        this.balance = 550
        this.isOn = true
    }

    fun machineStatus() {
        println()
        println("The coffee machine has:")
        println("${this.waterQty} ml of water")
        println("${this.milkQty} ml of milk")
        println("${this.coffeeBeans} g of coffee beans")
        println("${this.cups} disposable cups")
        println("$${this.balance} of money")
        println()
    }

    fun askActionMenu() {
        println("Write action (buy, fill, take, remaining, exit):")
    }

    fun fillMenu() {
        try {
            println()
            println("Write how many ml of water you want to add:")
            this.waterQty += readln().toInt()
            println("Write how many ml of milk you want to add: ")
            this.milkQty += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            this.coffeeBeans += readln().toInt()
            println("Write how many disposable cups you want to add: ")
            this.cups += readln().toInt()
            println()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun buy() {
        println()
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        try {
            val userInput = readln()
            if (userInput == "back") {
                println()
                return
            }
            when (userInput.toInt()) {
                1 -> makeEspresso()
                2 -> makeLatte()
                3 -> makeCappuccino()
            }

        } catch (e: Exception) {
            println(e.message)
        }
    }

    private fun makeBeverage(waterQty: Int, milkQty: Int, coffeeBeans: Int, cost: Int) {
        if (this.waterQty >= waterQty && this.coffeeBeans >= coffeeBeans && this.milkQty >= milkQty) {
            this.waterQty -= waterQty
            this.coffeeBeans -= coffeeBeans
            this.milkQty -= milkQty
            this.balance += cost
            this.cups -= 1
            println("I have enough resources, making you a coffee!")
        } else if (this.waterQty < waterQty) {
            println("Sorry, not enough water!")
        } else if (this.coffeeBeans < coffeeBeans) {
            println("Sorry, not enough coffee beans!")
        } else if (this.milkQty < milkQty) {
            println("Sorry, not enough milk!")
        }

        println()
    }

    private fun makeCappuccino() {
        val waterQty = 200
        val coffeeBeans = 12
        val milkQty = 100
        val cost = 6
        makeBeverage(waterQty, milkQty, coffeeBeans, cost)

    }


    private fun makeLatte() {
        val waterQty = 350
        val coffeeBeans = 20
        val milkQty = 75
        val cost = 7
        makeBeverage(waterQty, milkQty, coffeeBeans, cost)

    }


    private fun makeEspresso() {
        val waterQty = 250
        val coffeeBeans = 16
        val milkQty = 0
        val cost = 4
        makeBeverage(waterQty, milkQty, coffeeBeans, cost)
    }

    fun give() {
        println()
        println("I gave you $${this.balance}")
        this.balance = 0
    }

}