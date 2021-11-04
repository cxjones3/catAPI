package com.example.apitest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apitest.R
import androidx.activity.viewModels
import com.example.apitest.adapter.CatAdapter
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.viewmodel.CatViewModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity", "pass cv")

        initViews()

        viewModel.cats.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
            (binding.rvImages.adapter as CatAdapter).updateUrls(it)
        }
    }

    private fun initViews() = with(binding) {
        btnFetch.setOnClickListener {
            val count = binding.etCount.text?.toString()?.toIntOrNull()
            Log.d("MainActivity","got count")
            // Use this method to get the images
            viewModel.getImages(count ?: 1)
        }
        rvImages.adapter = CatAdapter()

    }

}