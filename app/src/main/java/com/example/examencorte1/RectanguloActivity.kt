package com.example.examencorte1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectangulo: Rectangulo
    private lateinit var lblBase: TextView
    private lateinit var txtBase: EditText
    private lateinit var lblAltura: TextView
    private lateinit var txtAltura: EditText
    private lateinit var lblCalculoArea: TextView
    private lateinit var lblCalArea: TextView
    private lateinit var lblCalculoPerimetro: TextView
    private lateinit var lblCalPerimetro: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectanguloactividad)

        rectangulo = Rectangulo()

        lblBase = findViewById(R.id.lblBase)
        txtBase = findViewById(R.id.txtBase)
        lblAltura = findViewById(R.id.lblAltura)
        txtAltura = findViewById(R.id.txtAltura)

        lblCalculoArea = findViewById(R.id.lblCalculoArea)
        lblCalArea = findViewById(R.id.lblCalArea)
        lblCalculoPerimetro = findViewById(R.id.lblCalculoPerimetro)
        lblCalPerimetro = findViewById(R.id.lblCalPerimetro)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnCalcular.setOnClickListener {
            calcularAreaYPerimetro()
        }

        btnLimpiar.setOnClickListener {
            limpiarCampos()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun calcularAreaYPerimetro() {
        val base = txtBase.text.toString().toIntOrNull() ?: 0
        val altura = txtAltura.text.toString().toIntOrNull() ?: 0

        rectangulo.base = base
        rectangulo.altura = altura

        val area = rectangulo.calcularArea()
        val perimetro = rectangulo.calcularPagPerimetro()

        lblCalArea.text = area.toString()
        lblCalPerimetro.text = perimetro.toString()
    }

    private fun limpiarCampos() {
        txtBase.text.clear()
        txtAltura.text.clear()
        lblCalArea.text = ""
        lblCalPerimetro.text = ""
    }
}
