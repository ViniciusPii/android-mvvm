package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.adapters.MainAdapter
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.repositories.MainRepository
import com.example.mvvm.rest.RetrofitService
import com.example.mvvm.viewmodel.main.MainViewModel
import com.example.mvvm.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private val adapter = MainAdapter()
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this, MainViewModelFactory(MainRepository(retrofitService))
        )[MainViewModel::class.java]

        binding.recycler.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        setObserver()
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllLives()
    }

    private fun setObserver() {
        viewModel.liveList.observe(this) { lives ->
            Log.i("Log", "onStart  $lives")
            adapter.setLiveList(lives)
        }

        viewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}