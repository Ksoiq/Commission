import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculate_VKPay() {
        val transferSum = 20_000_00
        val lostSum = 0
        val paymentSystem = PaymentSystem.VKPay

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(0, result)
    }

    @Test
    fun commissionCalculate_Maestro_withoutCommission() {
        val transferSum = 1000_00
        val lostSum = 74_999_00
        val paymentSystem = PaymentSystem.Maestro

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(0, result)
    }

    @Test
    fun commissionCalculate_Maestro() {
        val transferSum = 1000_00
        val lostSum = 75_000_00
        val paymentSystem = PaymentSystem.Maestro

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(26_00, result)
    }

    @Test
    fun commissionCalculate_Mastercard_withoutCommission() {
        val transferSum = 1000_00
        val lostSum = 74_999_00
        val paymentSystem = PaymentSystem.Mastercard

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(0, result)
    }

    @Test
    fun commissionCalculate_Mastercard() {
        val transferSum = 1000_00
        val lostSum = 75_000_00
        val paymentSystem = PaymentSystem.Mastercard

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(26_00, result)
    }

    @Test
    fun commissionCalculate_Visa() {
        val transferSum = 100_000_00
        val lostSum = 0
        val paymentSystem = PaymentSystem.Visa

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(750_00, result)
    }

    @Test
    fun commissionCalculate_Visa_minCommission() {
        val transferSum = 1000_00
        val lostSum = 0
        val paymentSystem = PaymentSystem.Visa

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(35_00, result)
    }

    @Test
    fun commissionCalculate_Mir() {
        val transferSum = 100_000_00
        val lostSum = 0
        val paymentSystem = PaymentSystem.Mir

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(750_00, result)
    }

    @Test
    fun commissionCalculate_Mir_minCommission() {
        val transferSum = 1000_00
        val lostSum = 0
        val paymentSystem = PaymentSystem.Mir

        val result = commissionCalculate(
            transferSum = transferSum,
            lostSum = lostSum,
            paymentSystem = paymentSystem
        )

        assertEquals(35_00, result)
    }
}