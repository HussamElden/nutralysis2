package com.example.nutralysis2.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class analysisViewModelFactory (private val repository: nutrationRepo): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return analyisiViewModel(repository) as T
    }

}