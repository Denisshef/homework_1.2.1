import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transfer_MasterCard_PastMonthZero() {
        // arrange
        val cardT = Card.MASTERCARD
        val amountT = 100

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT
        )

        // assert
        assertEquals(20.6, result, 0.02)
    }

    @Test
    fun transfer_Maestro_AmountPastMonthFree() {
        // arrange
        val cardT = Card.MAESTRO
        val amountT = 400
        val transferPastMonthT = 40000

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT,
            transferPastMonth = transferPastMonthT
        )

        // assert
        assertEquals(0.0, result, 0.02)
    }

    @Test
    fun transfer_Visa() {
        // arrange
        val cardT = Card.VISA
        val amountT = 400

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT,
        )

        // assert
        assertEquals(35.0, result, 0.02)
    }

    @Test
    fun transfer_Mir() {
        // arrange
        val cardT = Card.MIR
        val amountT = 80000

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT,
        )

        // assert
        assertEquals(600.0, result, 0.02)
    }

    @Test
    fun transfer_VkPay() {
        // arrange
        val cardT = Card.VKPAY
        val amountT = 400

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT,
        )

        // assert
        assertEquals(1.0, result, 0.02)
    }
}