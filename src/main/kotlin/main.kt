fun main() {
    val taxCommission = 75
    var amount: Int

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
    println("Сумма перевода $amount руб.")
    amount = (amount * taxCommission) / 10000
    if (amount <= 35) {
        print("Сумма комиссии за перевод 35 руб.")
    } else {
        print("Сумма комиссии за перевод $amount руб.")
    }


}