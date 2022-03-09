fun main() {
    val taxCommission = 75
    val amount = 154_000_00

    println("Сумма перевода $amount коп.")
    print("Сумма комиссии за перевод ${(amount * taxCommission) / 10000} коп.")

}