package machine

fun main() {
//    println("""Starting to make a coffee
//Grinding coffee beans
//Boiling water
//Mixing boiled water with crushed coffee beans
//Pouring coffee into the cup
//Pouring some milk into the cup
//Coffee is ready!""")

//    println("Write how many cups of coffee you will need:")
//    val cupsOfCofee = readlnOrNull()?.toIntOrNull()
    val coffeeParams = mutableListOf<Int>()
    val waterPerCup = 200
    val milkPerCup = 50
    val beansPerCup = 15
//    if (cupsOfCofee != null) {
//        println("For 25 cups of coffee you will need:")
//        println("${cupsOfCofee * waterPerCup} ml of water")
//        println("${cupsOfCofee * milkPerCup} ml of milk")
//        println("${cupsOfCofee * beansPerCup} g of coffee beans")
//
//
//    }
    var waterResult = 0
    var milkResult = 0
    var beanResult= 0


    try{
        println("Write how many ml of water the coffee machine has:")
        val waterAvailable = readln().toInt()
        println("Write how many ml of milk the coffee machine has:")
        val milkAvailable = readln().toInt()
        println("Write how many grams of coffee beans the coffee machine has:")
        val coffeeBeansAvailable = readln().toInt()
        println("Write how many cups of coffee you will need:")
        val coffeeCupsQty = readln().toInt()

        waterResult= waterAvailable / waterPerCup
        milkResult= milkAvailable / milkPerCup
        beanResult= coffeeBeansAvailable / beansPerCup

        coffeeParams.add(waterResult)
        coffeeParams.add(milkResult)
        coffeeParams.add(beanResult)
        val minimumQty = coffeeParams.min()

        if(coffeeCupsQty > minimumQty ){
            println("No, I can make only $minimumQty cups of coffee")
        }
        else if(coffeeCupsQty == minimumQty){
            println("Yes, I can make that amount of coffee")
        }else{
            println("Yes, I can make that amount of coffee (and even ${minimumQty- coffeeCupsQty} more than that)")
        }
    }catch (e: Exception){
        println(e.message)
    }










}
