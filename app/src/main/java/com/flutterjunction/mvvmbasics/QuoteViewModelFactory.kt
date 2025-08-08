package com.flutterjunction.mvvmbasics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flutterjunction.mvvmbasics.data.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T;
    }
}