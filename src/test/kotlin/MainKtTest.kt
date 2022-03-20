import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transfer_MasterCard_Maestro() {
        // arrange
        val cardT = Card.MAESTRO
        val amountT = 100

        // act
        val result = transfer(
            card = cardT,
            amountUser = amountT
        )

        // assert
        assertEquals(20.6, result, 0.02)
    }

//    @Test
//    fun transfer_Visa_Mir() {
//        // arrange
//        val cardT = Card.VISA
//        val amountT = 100000
//
//        // act
//        val result = transfer(
//            card = cardT,
//            amountUser = amountT
//        )
//
//        // assert
//        assertEquals(750.0, result, 0.02)
//    }
}