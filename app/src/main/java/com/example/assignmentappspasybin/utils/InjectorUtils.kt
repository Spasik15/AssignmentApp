package com.example.assignmentappspasybin.utils

import com.example.assignmentappspasybin.model.MainRepository
import com.example.assignmentappspasybin.model.NetworkApi
import com.example.assignmentappspasybin.viewmodels.viewmodelfactories.MainFragmentViewModelFactory

object InjectorUtils {
    private fun getPreviewRepository() = MainRepository.getInstance(NetworkApi.create())

    fun providePreview1ViewModelFactory() = MainFragmentViewModelFactory(getPreviewRepository())
}