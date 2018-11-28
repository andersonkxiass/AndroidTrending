package com.anderson.androidtrend.features.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anderson.androidtrend.R
import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.utlis.GlideApp
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.project_item.view.*

class ContributorAdapter : RecyclerView.Adapter<ContributorAdapter.ViewHolder>(){

    private lateinit var contributors: List<Owner>

    fun setData(repositories: List<Owner>){
        this.contributors = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contributors_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(::contributors.isInitialized) contributors.size else 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val contributor = contributors[position]

        GlideApp.with(viewHolder.itemView.context)
            .load(contributor.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(viewHolder.avatar)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.avatars!!
    }
}