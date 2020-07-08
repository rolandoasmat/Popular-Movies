package com.asmat.rolando.popularmovies.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.asmat.rolando.popularmovies.R
import com.asmat.rolando.popularmovies.ui.mylists.MyListsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_saved.*

class SavedFragment: Fragment() {

    private val tabName = listOf("Favorites", "To Watch")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = MyListsPagerAdapter(this)
        container?.adapter = adapter
        TabLayoutMediator(tabs, container) { tab, position ->
            tab.text = tabName[position]
        }.attach()
    }

}