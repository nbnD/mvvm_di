package com.flutterjunction.mvvmbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.flutterjunction.mvvmbasics.data.Quote
import com.flutterjunction.mvvmbasics.databinding.ActivityMainBinding

import com.flutterjunction.mvvmbasics.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.quotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[QuotesViewModel::class.java]

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote -> stringBuilder.append("$quote\n\n") }
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(
                binding.editTextQuote.text.toString(),
                binding.editTextAuthor.text.toString()
            )
            viewModel.addQuote(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}

