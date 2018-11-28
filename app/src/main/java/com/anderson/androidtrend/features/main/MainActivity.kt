package com.anderson.androidtrend.features.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.anderson.androidtrend.R
import com.anderson.androidtrend.databinding.ActivityMainBinding
import com.anderson.androidtrend.di.ViewModelFactory
import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.utlis.Outcome
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val projectAdapter : ProjectAdapter = ProjectAdapter()

    private lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val decoration = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)

        binding.viewModel = viewModel
        binding.adapter = projectAdapter
        binding.layoutManager = LinearLayoutManager(applicationContext)
        binding.dividerItemDecoration = decoration

        viewModel
            .outcomeData
            .observe(this, Observer<Outcome<List<Item>>> { outcome ->

                when (outcome) {

                    is Outcome.Success -> {
                        projectAdapter.setData(outcome.data)
                    }
                }
            })
    }
}
