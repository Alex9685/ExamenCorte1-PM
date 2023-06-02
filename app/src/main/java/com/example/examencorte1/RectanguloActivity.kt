package com.example.examencorte1

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectangulo: Rectangulo
    private lateinit var lblMostrarNombreUser: TextView
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

        lblMostrarNombreUser = findViewById(R.id.lblMostrarNombreUser)


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

        val nombre = intent.getStringExtra("nombre")

        lblMostrarNombreUser.text = nombre

        btnCalcular.setOnClickListener {
            calcularAreaYPerimetro()
        }

        btnLimpiar.setOnClickListener {
            limpiarCampos()
        }

        btnRegresar.setOnClickListener {
            salir()
        }
    }

    private fun salir() {
        val builder = AlertDialog.Builder(this@RectanguloActivity)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de querer cerrar sesión?")
        builder.setPositiveButton("Sí") { dialog, which ->
            // Acciones a realizar si se selecciona "Sí"
            val intent = Intent(this@RectanguloActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Finaliza la actividad actual (CalculadorActivity)
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, which ->
            // Acciones a realizar si se selecciona "No"
            dialog.dismiss() // Cierra el diálogo sin realizar ninguna acción adicional
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun calcularAreaYPerimetro() {
        val baseText = txtBase.text.toString()
        val alturaText = txtAltura.text.toString()

        if (baseText.isEmpty()) {
            txtBase.error = "Ingresa la base"
            return
        }

        if (alturaText.isEmpty()) {
            txtAltura.error = "Ingresa la altura"
            return
        }

        val base = baseText.toIntOrNull()
        val altura = alturaText.toIntOrNull()

        if (base == null) {
            txtBase.error = "Ingresa un valor numérico válido"
            return
        }

        if (altura == null) {
            txtAltura.error = "Ingresa un valor numérico válido"
            return
        }

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
