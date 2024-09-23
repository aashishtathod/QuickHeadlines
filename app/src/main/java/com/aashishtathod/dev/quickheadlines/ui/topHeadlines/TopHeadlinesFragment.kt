package com.aashishtathod.dev.quickheadlines.ui.topHeadlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.aashishtathod.dev.quickheadlines.databinding.FragmentTopHeadlinesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlinesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    // private var param1: String? = null

    private lateinit var binding: FragmentTopHeadlinesBinding
    private val viewModel by viewModels<TopHeadlinesViewModel>()

    private val adapter by lazy {
        TopHeadlinesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopHeadlinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        observeFlows()
    }

    private fun setUpUI() {
        binding.newsRecyclerView.adapter = adapter
    }

    private fun observeFlows() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiState.collect {
                    when (it) {
                        is TopHeadlinesUiState.None -> {

                        }

                        is TopHeadlinesUiState.Loading -> {
                            Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                        }

                        is TopHeadlinesUiState.Success -> {
                            adapter.submitList(it.news)
                        }

                        is TopHeadlinesUiState.Error -> {
                            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                        }

                    }
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String = "") =
            TopHeadlinesFragment().apply {
                arguments = Bundle().apply {
                    //  putString(ARG_PARAM1, param1)
                }
            }
    }
}