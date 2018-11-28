package com.anderson.androidtrend.features.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.anderson.androidtrend.R
import com.anderson.androidtrend.databinding.ActivityDetailsBinding
import com.anderson.androidtrend.di.ViewModelFactory
import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.utlis.Outcome
import dagger.android.AndroidInjection
import javax.inject.Inject


class DetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityDetailsBinding

    private val contributorAdapter : ContributorAdapter = ContributorAdapter()

    private val viewModel: DetailsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DetailsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        binding.toolbar.title = ""

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        intent.extras?.let { it ->

            val item = it.getParcelable<Item>("item")

            item?.let {

                bindData(item)
            }
        }
    }

    private fun bindData(item: Item) {
        binding.dataModel = item
        binding.adapter = contributorAdapter
        binding.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        viewModel
            .outcomeData
            .observe(this, Observer<Outcome<List<Owner>>> { outcome ->

                when (outcome) {

                    is Outcome.Success -> {
                        contributorAdapter.setData(outcome.data)
                    }
                }
            })

        viewModel.getDetails(item.owner!!.login!!, item.name!!)
    }
}
