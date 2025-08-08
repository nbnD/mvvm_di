package com.flutterjunction.mvvmbasics

import androidx.lifecycle.ViewModel
import com.flutterjunction.mvvmbasics.data.Quote
import com.flutterjunction.mvvmbasics.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuote()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}