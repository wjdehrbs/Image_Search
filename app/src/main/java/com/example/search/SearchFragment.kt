package com.example.search

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.search.data.RetrofitClass
import com.example.search.data.SearchItemData
import com.example.search.data.SearchModel
import com.example.search.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        rvAdapter = SearchAdapter()
        binding.recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerview.adapter = rvAdapter

        val searchButton = binding.searchButton
        val searchEditText = binding.searchEditText

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            performImageSearch(query)
        }

        return view
    }

    private fun performImageSearch(query: String) {
        val call = RetrofitClass.api.search_image(query = query, sort = "accuracy", page = 1, size = 80)

        call.enqueue(object : Callback<SearchModel> {
            override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {
                println(response.body())
                if (response.isSuccessful) {
                    val searchModel = response.body()
                    if (searchModel != null) {
                        val searchResults = searchModel.documents
                        rvAdapter.items.clear()
                        rvAdapter.items.addAll(mapSearchResultsToItems(searchResults))
                        rvAdapter.notifyDataSetChanged()
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<SearchModel>, t: Throwable) {
                println(t.message)
            }
        })
    }

    private fun mapSearchResultsToItems(searchResults: List<SearchModel.Documents>): List<SearchItemData> {
        val items = ArrayList<SearchItemData>()
        for (result in searchResults) {
            val title = result.displaySiteName
            val dataTime = result.datetime
            val imageUrl = result.thumbnailUrl
            val item = SearchItemData(title, dataTime, imageUrl)
            items.add(item)
        }
        return items
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}