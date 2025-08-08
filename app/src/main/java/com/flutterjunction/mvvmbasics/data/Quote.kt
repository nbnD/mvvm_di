package com.flutterjunction.mvvmbasics.data

import org.w3c.dom.Text

data class Quote(val quoteText: String, val author:String) {

    override fun toString(): String {
        return "$quoteText  - $author"
    }
}