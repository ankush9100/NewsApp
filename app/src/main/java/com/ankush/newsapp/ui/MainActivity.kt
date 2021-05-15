package com.ankush.newsapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ankush.newsapp.R
import com.ankush.newsapp.api.RetrofitInstance
import com.ankush.newsapp.ui.fragments.BreakingNewsFragment
import com.ankush.newsapp.ui.fragments.SavedNewsFragment
import com.ankush.newsapp.ui.fragments.SearchNewsFragment
import com.ankush.newsapp.ui.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val retrofit = RetrofitInstance()
    lateinit var context: Context
    lateinit var mainActivityViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        val breakingNewsFragment = BreakingNewsFragment()
        val savedNewsFragment = SavedNewsFragment()
        val searchNewsFragment = SearchNewsFragment()
        setCurrentFragment(breakingNewsFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.breaking_news_fragment->setCurrentFragment(breakingNewsFragment)
                R.id.saved_news_fragment->setCurrentFragment(savedNewsFragment)
                R.id.search_news_fragment->setCurrentFragment(searchNewsFragment)

            }
            true
        }





    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }




}