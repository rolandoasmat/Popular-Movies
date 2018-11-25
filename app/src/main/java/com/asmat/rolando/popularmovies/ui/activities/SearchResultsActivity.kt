package com.asmat.rolando.popularmovies.ui.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater

import com.asmat.rolando.popularmovies.R
import com.asmat.rolando.popularmovies.ui.fragments.SearchResultsFragment

class SearchResultsActivity : AppCompatActivity() {
    lateinit var resultsGrid: SearchResultsFragment
    lateinit var searchview: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
        setupToolbar()
        setupFragment()
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    // Enable Back arrow
    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val bar = supportActionBar
        bar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupFragment() {
        resultsGrid = supportFragmentManager.findFragmentById(R.id.results_grid) as SearchResultsFragment
    }

    // Handle the search query
    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            searchview.setQuery(query, false)
            resultsGrid.setSearchQuery(query)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the options menu from XML
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search_results, menu)
        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchview = menu.findItem(R.id.search).actionView as SearchView
        // Assumes current activity is the searchable activity
        searchview.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchview.isIconified = false
        searchview.setIconifiedByDefault(true)
        searchview.isSubmitButtonEnabled = true
        return true
    }
}