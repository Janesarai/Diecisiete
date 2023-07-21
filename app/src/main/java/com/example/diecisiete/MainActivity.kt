package com.example.diecisiete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.diecisiete.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private val divisas = listOf<String>("Dolar", "Peso", "Euro")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinner2.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)

        initListener()
    }

    private fun initListener() {
        binding.buttonConvert.setOnClickListener {
            val monto = binding.tvEntrada.text.toString().toDouble()
            val divisaActual = binding.spinner.selectedItem.toString()
            val divisaCambio = binding.spinner2.selectedItem.toString()
            val resultado = convertordivisas(monto, divisaActual, divisaCambio)
            binding.txResultado.text = resultado.toString()

        }
        binding.button2.setOnClickListener(View.OnClickListener {
            limpiar()
        })

        binding
    }
    }

    fun convertordivisas(monto: Double, divisaActual: String, divisaCambio: String):Double {
        var resultado = monto
        when (divisaActual) {

            "Dolar" -> if (divisaCambio == "Pesos") {
                resultado = monto * 817
            } else if (divisaCambio == "Dolar") {
                resultado = monto * 1
            } else if (divisaCambio == "Euro") {
                resultado = monto * 0.89
            }

            "Pesos" -> if (divisaCambio == "Pesos") {
                resultado = monto * 1
            } else if (divisaCambio == "Dolar") {
                resultado = monto * 0.001
            } else if (divisaCambio == "Euro") {
                resultado = monto * 0.001
            }

            "Euro" -> if (divisaCambio == "Pesos") {
                resultado = monto * 910
            } else if (divisaCambio == "Dolar") {
                resultado = monto * 1.11

            } else if (divisaCambio == "Euro") {
                resultado = monto * 1
            }

        }
        return resultado
    }

    fun limpiar() {

        binding.tvEntrada.setText("")
        binding.txResultado.text= ""

    }

