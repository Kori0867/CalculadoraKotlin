package mx.edu.utch.calculadoraapp

class Controlador(private val vista: Vista, private val modelo: Modelo) {

    fun iniciar() {
        vista.obtenerBotonSuma().setOnClickListener {
            operacionSeleccionada(1)
        }

        vista.obtenerBotonResta().setOnClickListener {
            operacionSeleccionada(2)
        }

        vista.obtenerBotonMultiplicacion().setOnClickListener {
            operacionSeleccionada(3)
        }

        vista.obtenerBotonDivision().setOnClickListener {
            operacionSeleccionada(4)
        }
    }

    fun agregarNumero(numero: String) {
        val textoNumero = vista.obtenerTextoNumero()
        val textoNumero2 = vista.obtenerTextoNumero2()

        if (textoNumero.isEmpty()) {
            // Si no hay un número en TextViewNum1, establecer el valor ingresado
            vista.establecerTextoNumero(numero, vista.obtenerTextViewNum1())
            modelo.numero1 = numero.toDouble() // Guardar el primer número en el modelo
        } else {
            // Si hay un número en TextViewNum1, verificar si ya se ha ingresado un operador
            if (modelo.operacion == 0) {
                // Si no se ha ingresado un operador, agregar al número en TextViewNum1
                vista.establecerTextoNumero(textoNumero + numero, vista.obtenerTextViewNum1())
                modelo.numero1 = (textoNumero + numero).toDouble() // Actualizar el primer número en el modelo
            } else {
                // Si se ha ingresado un operador, establecer el valor ingresado en TextViewNum2
                vista.establecerTextoNumero(textoNumero2 + numero, vista.obtenerTextViewNum2())
                modelo.numero2 = (textoNumero2 + numero).toDouble() // Guardar el segundo número en el modelo
            }
        }
    }


    fun agregarPunto() {
        val numeroActual = vista.obtenerTextoNumero()
        val numeroActual2 = vista.obtenerTextoNumero2()

        // Verificar si el punto decimal ya está presente en el número actual
        if (!numeroActual.contains(".") && numeroActual2.isEmpty()) {
            vista.establecerTextoNumero(numeroActual + ".", vista.obtenerTextViewNum1())
        } else if (!numeroActual2.contains(".")) {
            vista.establecerTextoNumero(numeroActual2 + ".", vista.obtenerTextViewNum2())
        }
    }


    fun presionarIgual() {
        if (modelo.numero1 != null && modelo.numero2 != null && modelo.operacion != 0) {
            val resultado = modelo.realizarOperacion()
            vista.mostrarResultado(resultado)
        } else {
            vista.mostrarMensajeError("Ingrese ambos números y seleccione una operación.")
        }
    }


    private fun operacionSeleccionada(operacion: Int) {
        if (modelo.numero1 != null) {
            modelo.operacion = operacion
            vista.mostrarOperacion(modelo.numero1, operacion)
        } else {
            vista.mostrarMensajeError("Ingrese un número primero.")
        }
    }


    fun borrarTodo() {
        vista.establecerTextoNumero("", vista.obtenerTextViewNum1())
        vista.establecerTextoNumero("", vista.obtenerTextViewNum2())

        modelo.operacion = 0
        primerNumeroIngresado = false // Restablecer el estado
        vista.mostrarMensajeError("Se borraron todos los números y operaciones.")
    }

    private var primerNumeroIngresado = false






}