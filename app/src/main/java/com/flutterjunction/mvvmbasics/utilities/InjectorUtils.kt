package com.flutterjunction.mvvmbasics.utilities

import com.flutterjunction.mvvmbasics.QuoteViewModelFactory
import com.flutterjunction.mvvmbasics.data.FakeDatabase
import com.flutterjunction.mvvmbasics.data.FakeQuoteDao
import com.flutterjunction.mvvmbasics.data.QuoteRepository

object InjectorUtils {
    fun quotesViewModelFactory(): QuoteViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}