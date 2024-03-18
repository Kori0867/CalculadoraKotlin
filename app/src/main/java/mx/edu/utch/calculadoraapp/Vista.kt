// Vista.kt
package mx.edu.utch.calculadoraapp

import android.widget.Button
import android.widget.TextView

interface Vista {
        // Métodos para obtener referencias a botones
        fun obtenerBotonSuma(): Button
        fun obtenerBotonResta(): Button
        fun obtenerBotonMultiplicacion(): Button
        fun obtenerBotonDivision(): Button
        fun obtenerBotonIgual(): Button
        fun obtenerBotonBorrarTodo(): Button

        // Métodos para mostrar información en la vista
        fun mostrarMensajeError(mensaje: String)
        fun mostrarOperacion(num: Double, operacion: Int)
        fun mostrarResultado(resultado: Double)

        // Métodos para interactuar con los TextViews
        fun obtenerTextoNumero(): String
        fun establecerTextoNumero(texto: String, textView: TextView)
        fun obtenerTextViewNum1(): TextView
        fun obtenerTextViewNum2(): TextView
        fun obtenerTextViewResultado(): TextView
        fun obtenerTextoNumero2(): String  // Nuevo método para obtener el texto del segundo TextView
}
