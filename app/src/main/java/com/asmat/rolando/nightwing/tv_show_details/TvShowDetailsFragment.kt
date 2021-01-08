package com.asmat.rolando.nightwing.tv_show_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.asmat.rolando.nightwing.NightwingApplication
import com.asmat.rolando.nightwing.R
import com.asmat.rolando.nightwing.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show_details.*
import javax.inject.Inject

class TvShowDetailsFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel: TvShowDetailsViewModel by viewModels { viewModelFactory }

    val args: TvShowDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as NightwingApplication).component().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
        viewModel.load(args.tvShowIdArg)
    }

    private fun observeViewModel() {
        viewModel.uiModel.observe(viewLifecycleOwner) {
            createdByLabel?.text = it.createdBy
            firstAirDateLabel?.text = it.firstAirDate
            lastAirDateLabel?.text = it.lastAirDate
            networksLabel?.text = it.networks
            overviewLabel?.text = it.overview
            numberOfEpisodesLabel?.text = it.numberOfEpisodes
            numberOfSeasonsLabel?.text = it.numberOfSeasons
            taglineLabel?.text = it.tagline
        }

    }


}