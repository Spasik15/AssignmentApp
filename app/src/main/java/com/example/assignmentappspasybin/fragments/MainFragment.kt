package com.example.assignmentappspasybin.fragments

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentappspasybin.R
import com.example.assignmentappspasybin.activities.MainActivity
import com.example.assignmentappspasybin.adapters.MyRecycleAdapter
import com.example.assignmentappspasybin.databinding.FragmentMainBinding
import com.example.assignmentappspasybin.utils.InjectorUtils
import com.example.assignmentappspasybin.utils.PagingListener
import com.example.assignmentappspasybin.utils.toast
import com.example.assignmentappspasybin.viewmodels.MainFragmentViewModel
import java.util.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var binding: FragmentMainBinding

    private var pagingListener = ScrollListener()

    var page: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.apply {
            layoutPreview1.layoutTransition.apply {
                enableTransitionType(LayoutTransition.CHANGING)
                setDuration(700)
            }
        }

        val adapter = MyRecycleAdapter(ArrayList())
        with(binding.postsList) {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                this.adapter = adapter
                pagingListener.attach(this)
            }

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: MyRecycleAdapter) {
        val factory = context?.let { InjectorUtils.providePreview1ViewModelFactory() }
        viewModel = ViewModelProviders.of(this, factory).get(MainFragmentViewModel::class.java)
        viewModel.apply {
            posts.observe(viewLifecycleOwner, Observer { posts ->
                posts.let {
                    if (posts.isEmpty()) context?.toast("Network issue")
                    else adapter.apply {
                        addItems(it)
                        notifyDataSetChanged()
                        pagingListener.setEnabled(true)
                        pagingListener.setPaused(false)
                        (activity as MainActivity).setToolBarCount(itemCount)
                    }
                }
                progressBarVisibility.observe(viewLifecycleOwner, Observer { visibility ->
                    if (visibility) binding.progressBar.visibility = View.VISIBLE
                    else binding.progressBar.visibility = View.GONE
                })
            })
            loadPosts()
        }
    }

    private inner class ScrollListener : PagingListener() {
        var page: Int = 1

        override fun lastItemVisible() {
            page++
            pagingListener.setPaused(true)
            viewModel.loadNewPage(page)
            binding.progressBar.visibility = View.VISIBLE
        }
    }
}
