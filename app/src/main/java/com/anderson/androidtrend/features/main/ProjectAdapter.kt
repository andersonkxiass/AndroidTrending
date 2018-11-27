package com.anderson.androidtrend.features.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anderson.androidtrend.R
import com.anderson.androidtrend.databinding.ProjectItemBinding
import com.anderson.androidtrend.features.details.DetailsActivity
import com.anderson.androidtrend.model.Item

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ViewHolder>(){

    private lateinit var binding : ProjectItemBinding
    private lateinit var repositories : List<Item>

    fun setData(repositories: List<Item>){
        this.repositories = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.project_item, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::repositories.isInitialized) repositories.size else 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val projectItem = repositories[position]

        viewHolder.bind(projectItem)
    }

    class ViewHolder(private val binding : ProjectItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(projectItem : Item){
            binding.dataModel = projectItem
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                val context = it.context
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("item", projectItem)
                context.startActivity(intent)
            }
        }
    }
}
