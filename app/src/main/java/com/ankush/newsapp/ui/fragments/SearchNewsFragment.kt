package com.ankush.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankush.newsapp.R
import com.ankush.newsapp.adapters.SearchNewsAdapter
import com.ankush.newsapp.ui.viewModel.SearchNewsViewModel
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.android.synthetic.main.fragment_search_news.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchNewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mainActivityViewModel: SearchNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_search_news, container, false)
//        search_button?.setOnClickListener {
//            getData(search_text.text.toString())
//            Log.e("SSSS",search_text.text.toString())
//        }
        // Inflate the layout for this fragment
        view.search_button.setOnClickListener {
            getData(search_text.text.toString())
        }
        return view
    }
    private fun getData(searchText: String){
        mainActivityViewModel = ViewModelProvider(this).get(SearchNewsViewModel::class.java)
        mainActivityViewModel.getUser(searchText)!!.observe(this, Observer { serviceSetterGetter ->
            Log.e("Success",serviceSetterGetter.articles.toString())
            val adapter = SearchNewsAdapter(serviceSetterGetter)
            val layoutManager = LinearLayoutManager(context)
            rv_searchNews.layoutManager = layoutManager
            rv_searchNews.adapter = adapter
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}