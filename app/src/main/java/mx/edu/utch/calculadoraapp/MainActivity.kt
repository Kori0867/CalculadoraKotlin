package mx.edu.utch.calculadoraapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), Vista {

    private lateinit var modelo: Modelo
    private lateinit var controlador: Controlador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv_num1 = findViewById<TextView>(R.id.tv_num1)
        val tv_num2 = findViewById<TextView>(R.id.tv_num2)
        modelo = Modelo()
        controlador = Controlador(this, modelo)
        controlador.iniciar()

        val numeros = listOf(R.id.numcero, R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9)
        numeros.forEach { id ->
            findViewById<Button>(id).setOnClickListener { button ->
                val textoBoton = (button as Button).text.toString()
                controlador.agregarNumero(textoBoton) // Pasar el texto del botón como String
            }
        }


        val btnBorrarTodo = findViewById<Button>(R.id.btnBorrarTodo)
        btnBorrarTodo.setOnClickListener {
            controlador.borrarTodo()
        }
        val btnIgual = findViewById<Button>(R.id.igual)
        btnIgual.setOnClickListener {
            controlador.presionarIgual()
        }
        val btnPunto = findViewById<Button>(R.id.punto)
        btnPunto.setOnClickListener {
            controlador.agregarPunto()
        }
    }

    override fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun mostrarOperacion(num2: Double, operacion: Int) {
        val operacionTexto = when (operacion) {
            1 -> "+"
            2 -> "-"
            3 -> "*"
            4 -> "/"
            else -> ""
        }

        establecerTextoNumero(num2.toString(), obtenerTextViewNum1())
        establecerTextoNumero("", obtenerTextViewNum2())

        val textoOperacion = "$num2 $operacionTexto"
        Toast.makeText(this, textoOperacion, Toast.LENGTH_SHORT).show()
    }

    override fun obtenerBotonSuma(): Button {
        return findViewById(R.id.suma)
    }

    override fun obtenerBotonResta(): Button {
        return findViewById(R.id.resta)
    }

    override fun obtenerBotonMultiplicacion(): Button {
        return findViewById(R.id.multiplicacion)
    }

    override fun obtenerBotonDivision(): Button {
        return findViewById(R.id.division)
    }

    override fun obtenerBotonIgual(): Button {
        return findViewById(R.id.igual)
    }

    override fun obtenerBotonBorrarTodo(): Button {
        return findViewById(R.id.btnBorrarTodo)
    }
    override fun obtenerTextoNumero2(): String {
        return obtenerTextViewNum2().text.toString()
    }

    override fun obtenerTextoNumero(): String {
        return obtenerTextViewNum1().text.toString()
    }

    override fun establecerTextoNumero(texto: String, textView: TextView) {
        textView.text = texto
    }

    override fun obtenerTextViewNum1(): TextView {
        return findViewById(R.id.tv_num1)
    }

    override fun obtenerTextViewNum2(): TextView {
        return findViewById(R.id.tv_num2)
    }

    override fun obtenerTextViewResultado(): TextView {
        return findViewById(R.id.tv_num2)
    }

    // Update the mostrarResultado function to use the new obtenerTextViewResultado function
    override fun mostrarResultado(resultado: Double) {
        establecerTextoNumero(resultado.toString(), obtenerTextViewResultado())
    }
}
