const val MAX_LIMIT = 75_000_00
const val OVER_LIMIT_COMMISSION = 20_00
const val COMMISSION = .0075
const val MIN_COMMISSION = 35_00

enum class PaymentSystem {
    Mastercard, Maestro, VKPay, Visa, Mir
}

fun main() {
    val lostSum = 0
    println("Введите сумму перевода: ")
    val transferSum: Int = readLine()?.toInt()?.times(100)!!
    println("Выбор платежной системы")
    println("1. VKPay")
    println("2. Mastercard")
    println("3. Maestro")
    println("4. Visa")
    println("5. MIR")
    val paymentSystem = when (readLine()?.toInt()!!) {
        1 -> PaymentSystem.VKPay
        2 -> PaymentSystem.Mastercard
        3 -> PaymentSystem.Maestro
        4 -> PaymentSystem.Visa
        5 -> PaymentSystem.Mir
        else -> error("Ошибка ввода")
    }
    println(calculationResult(transferSum, commissionCalculate(transferSum, lostSum, paymentSystem)))
}

fun commissionCalculate(
    transferSum: Int,
    lostSum: Int = 0,
    paymentSystem: PaymentSystem = PaymentSystem.VKPay
): Int {
    return when (paymentSystem) {
        PaymentSystem.VKPay -> 0
        PaymentSystem.Maestro, PaymentSystem.Mastercard -> {
            if (lostSum < MAX_LIMIT) {
                0
            } else {
                    (transferSum * .006 + OVER_LIMIT_COMMISSION).toInt()
            }
        }
        PaymentSystem.Visa, PaymentSystem.Mir -> {
            if (transferSum * COMMISSION > MIN_COMMISSION) (transferSum * COMMISSION).toInt() else MIN_COMMISSION
        }
    }
}

fun calculationResult(sum: Int, commission: Int = 0): String {
    return if (commission == 0) {
        ("Комиссия не взымается \n" +
                "Сумма перевода " + sum / 100 + "руб. " + sum % 100 + " коп.")
    } else {
        ("Комиссия " + commission / 100 + "руб. " + commission % 100 + " коп. \n" +
                "Сумма перевода " + (sum - commission) / 100 + "руб. " + (sum - commission) % 100 + " коп.")
    }
}








