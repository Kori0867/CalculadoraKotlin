package mx.edu.utch.calculadoraapp
class Modelo {
    var operacion: Int = 0
    var numero1: Double = 0.0
    var numero2: Double = 0.0
    var resultado: Double = 0.0

    fun realizarOperacion(): Double {
        resultado = when (operacion) {
            1 -> numero1 + numero2
            2 -> numero1 - numero2
            3 -> numero1 * numero2
            4 -> {
                if (numero2 != 0.0) {
                    numero1 / numero2
                } else {
                    throw ArithmeticException("División por cero no permitida")
                }
            }
            else -> throw IllegalArgumentException("Operación no válida: $operacion")
        }
        return resultado
    }
}
