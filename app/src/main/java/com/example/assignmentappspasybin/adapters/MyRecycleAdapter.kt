package com.example.assignmentappspasybin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentappspasybin.databinding.ListItemBinding
import com.example.assignmentappspasybin.model.data.Post
import java.util.*

class MyRecycleAdapter(private val postsList: ArrayList<Post>) :
    RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postsList[position]
        holder.apply {
            bind(createOnClickListener(post), post)
            itemView.tag = post
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    private fun createOnClickListener(post: Post): View.OnClickListener {
        return View.OnClickListener {

        }
    }

    class MyViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Post) {
            binding.apply {
                clickListener = listener
                post = item
                executePendingBindings()
            }
        }
    }

    fun addItems(posts: List<Post>) {
        posts.forEach {
            postsList.add(it)
        }
        super.notifyDataSetChanged()
    }
}
