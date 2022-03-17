var amountTransferPastMonth = 50000

enum class Card {
    MASTERCARD, MAESTRO, VISA, MIR, VKPAY
}

fun main() {
    userInput()
}

fun userInput() {
    var card: Card
    var amount: Int

    while (true) {
        print(
            """
            Откуда совершаете платёж?
            1 Mastercard
            2 Maestro
            3 Visa
            4 Мир 
            5 VK Pay
            укажите номер (1 - 5): 
        """.trimIndent()
        )
        try {
            val userNumberCard = readLine()?.toInt() ?: return
            if (userNumberCard < 1 || userNumberCard > 5) {
                println("Выберете от 1 до 5!\n")
                continue
            }
            card = when (userNumberCard) {
                1 -> Card.MASTERCARD
                2 -> Card.MAESTRO
                3 -> Card.VISA
                4 -> Card.MIR
                else -> Card.VKPAY
            }
            break
        } catch (err: Exception) {
            println("Странный ввод :)\n")
        }
    }

    while (true) {
        print("Введите сумму перевода: ")
        try {
            amount = readLine()?.toInt() ?: return
            if (amount <= 0) {
                println("Сумма должна быть больше нуля!\n")
                continue
            }
            break
        } catch (err: Exception) {
            println("!Не похоже на сумму :)\n")
        }
    }
    transfer(card, amount * 100)
}


fun transfer(card: Card, amount: Int) {
    val str = when (card) {
        Card.MASTERCARD, Card.MAESTRO -> {
            if (amountTransferPastMonth in 30000..7500000) {
                "0"
            } else {
                " ${((amount * 0.006) + 2000) / 100}"
            }
        }
        Card.VISA, Card.MIR -> {
            if ((amount * 0.0075) < 3500) {
                "35"
            } else {
                "${(amount * 0.0075) / 100}"
            }
        }
        else -> "0"
    }
    amountTransferPastMonth += amount

    println("--> перевод с $card")
    println("--> сумма перевода ${amount / 100} руб.")
    println("--> комиссия за перевод $str руб.")
}