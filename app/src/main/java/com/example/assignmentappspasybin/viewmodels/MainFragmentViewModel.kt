package com.example.assignmentappspasybin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentappspasybin.model.MainRepository
import com.example.assignmentappspasybin.model.data.Post
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {
    val posts = MutableLiveData<List<Post>>()

    val progressBarVisibility = MutableLiveData<Boolean>()

    fun loadPosts() {
        progressBarVisibility.postValue(true)

        viewModelScope.launch {
            posts.postValue(mainRepository.getPages())
            progressBarVisibility.postValue(false)
        }
    }

    fun loadNewPage(page: Int) {
        progressBarVisibility.postValue(true)
        viewModelScope.launch {
            posts.postValue(mainRepository.getPages(page))
            progressBarVisibility.postValue(false)
        }
    }
}

