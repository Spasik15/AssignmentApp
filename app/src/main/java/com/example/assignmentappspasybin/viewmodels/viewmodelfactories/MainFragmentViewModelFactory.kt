package com.example.assignmentappspasybin.viewmodels.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentappspasybin.model.MainRepository
import com.example.assignmentappspasybin.viewmodels.MainFragmentViewModel

class MainFragmentViewModelFactory(
    private val mainRepository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = MainFragmentViewModel(mainRepository) as T
}