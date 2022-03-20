var amountTransferMonth = 0

enum class Card {
    MASTERCARD, MAESTRO, VISA, MIR, VKPAY
}

fun main() {
    val cardPay = userInputCard()
    val amount = userInputAmount()
    val amountTransfer = saveAmountTransferMonth(amount)
    val commissionTransfer = transfer(cardPay, amount, amountTransfer)

    println("--> перевод с $cardPay")
    println("--> сумма перевода $amount руб.")
    println("--> комиссия за перевод $commissionTransfer руб.")
}

fun userInputCard(): Card {
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
            val userNumberCard = readLine()?.toInt() ?: continue
            if (userNumberCard < 1 || userNumberCard > 5) {
                println("Выберете от 1 до 5!\n")
                continue
            }
            return when (userNumberCard) {
                1 -> Card.MASTERCARD
                2 -> Card.MAESTRO
                3 -> Card.VISA
                4 -> Card.MIR
                else -> Card.VKPAY
            }
        } catch (err: Exception) {
            println("Странный ввод :)\n")
        }
    }
}

fun userInputAmount(): Int {
    while (true) {
        print("Введите сумму перевода: ")
        try {
            val amount = readLine()?.toInt() ?: continue
            if (amount <= 0) {
                println("Сумма должна быть больше нуля!\n")
                continue
            }
            return amount
        } catch (err: Exception) {
            println("!Не похоже на сумму :)\n")
        }
    }
}

fun saveAmountTransferMonth(amount: Int = 0): Int {
    amountTransferMonth += amount
    return amountTransferMonth
}

fun transfer(card: Card, amountUser: Int, transferPastMonth: Int = 0): Double {
    val amount = amountUser * 100

    val i = when (card) {
        Card.MASTERCARD, Card.MAESTRO -> {
            if (transferPastMonth in 30000..7500000) {
                0.0
            } else {
                ((amount * 0.006) + 2000) / 100
            }
        }
        Card.VISA, Card.MIR -> {
            if ((amount * 0.0075) < 3500) {
                35.0
            } else {
                (amount * 0.0075) / 100
            }
        }
        else -> 0.0
    }
    saveAmountTransferMonth(amountUser)
    return i
}