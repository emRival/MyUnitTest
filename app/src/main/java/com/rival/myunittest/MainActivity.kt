package com.rival.myunittest

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rival.myunittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnSave.setOnClickListener(this@MainActivity)
            btnCalculateCircumference.setOnClickListener(this@MainActivity)
            btnCalculateVolume.setOnClickListener(this@MainActivity)
            btnCalculateSurfaceArea.setOnClickListener(this@MainActivity)

            mainViewModel.result.observe(this@MainActivity){
               tvResult.text = it.toString()
            }
        }




    }

    override fun onClick(v: View?) {
        binding.apply {
            val length = edtLength.text.toString()
            val width = edtWidth.text.toString()
            val height = edtHeight.text.toString()
            val err = "Field ini tidak boleh kosong"


            when {
                TextUtils.isEmpty(length) -> {
                    edtLength.error = err
                }

                TextUtils.isEmpty(width) -> {
                    edtWidth.error = err
                }

                TextUtils.isEmpty(height) -> {
                    edtHeight.error = err
                }

                else -> {
                    val valueLength = length.toDouble()
                    val valueWidth = width.toDouble()
                    val valueHeight = height.toDouble()
                    when (v?.id) {
                        R.id.btn_save -> {
                            mainViewModel.save(valueLength, valueWidth, valueHeight)
                            visible()
                        }

                        R.id.btn_calculate_circumference -> {
                            mainViewModel.getCircumference()
                            gone()
                        }

                        R.id.btn_calculate_surface_area -> {

                            mainViewModel.getSurfaceArea()
                            gone()
                        }

                        R.id.btn_calculate_volume -> {
                            mainViewModel.getVolume()
                            gone()
                        }
                    }
                }
            }


        }
    }

    private fun gone() {
        binding.apply {
            btnCalculateVolume.visibility = View.GONE
            btnCalculateCircumference.visibility = View.GONE
            btnCalculateSurfaceArea.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }

    private fun visible() {
        binding.apply {
            btnCalculateVolume.visibility = View.VISIBLE
            btnCalculateCircumference.visibility = View.VISIBLE
            btnCalculateSurfaceArea.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }
}
