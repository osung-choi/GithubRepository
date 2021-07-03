package com.osung.githubrepository.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.osung.githubrepository.R
import com.osung.githubrepository.databinding.ActivityMainBinding
import com.osung.githubrepository.view.adpater.SearchAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    private val adapter by lazy { SearchAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.searchResultList.adapter = adapter
    }
}