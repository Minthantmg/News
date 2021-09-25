package com.nara.news.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nara.news.MainActivity
import com.nara.news.R
import com.nara.news.ui.NewsViewModel


class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
    }
}