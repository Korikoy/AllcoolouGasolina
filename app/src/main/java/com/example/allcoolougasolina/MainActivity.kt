package com.example.allcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.allcoolougasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener { calcularPreco() }

    }

    fun calcularPreco (){
        var precoAlcool = binding.editPreOAlcool.text.toString()
        var precoGasol = binding.editPreOGasol.text.toString()
        var camposValidados =  validarCampos(precoAlcool, precoGasol)
        if(camposValidados){
            var valorAlcool = precoAlcool.toDouble()
            var valorGasol = precoGasol.toDouble()
            var resultado = valorAlcool/valorGasol
            if (resultado >= 0.7){
                binding.resultado.text = "Ultilizar Alcool"

            }else{
                binding.resultado.text = "Ultilizar Gasolina"

            }



        }else{
            binding.resultado.text = "Preencha os preços primeiro!"
        }

    }
    fun validarCampos(pAlcool: String, pGasol: String): Boolean {
        var camposValidados = true
        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false
        }else if(pGasol == null || pGasol.equals("")){
            camposValidados = false

        }

        return camposValidados
    }



}

