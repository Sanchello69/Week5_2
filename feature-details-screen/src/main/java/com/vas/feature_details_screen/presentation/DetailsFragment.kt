package com.vas.feature_details_screen.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.squareup.picasso.Picasso
import com.vas.core.utils.Constants
import com.vas.core.utils.Status
import com.vas.feature_details_screen.R
import com.vas.feature_details_screen.databinding.FragmentDetailsBinding
import com.vas.feature_details_screen.di.DetailsComponentViewModel
import com.vas.feature_details_screen.domain.model.CharacterDetails
import javax.inject.Inject

class DetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory

    private var binding: FragmentDetailsBinding? = null
    private var viewModel: DetailsViewModel? = null

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<DetailsComponentViewModel>()
            .newDetailsComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setupObservers() {
        var name = arguments?.getString("name")?:"Iron Man"
        viewModel?.getDetails(name)?.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.d("status", "SUCCESS")
                        Log.d("status", "${it.data}")
                        setupUI(it.data!!)
                    }
                    Status.ERROR -> {
                        Log.d("status", "ERROR ${it.message}")
                    }
                    Status.LOADING -> {
                        Log.d("status",  "LOADING")
                    }
                }
            }
        })
    }

    private fun setupUI(character: CharacterDetails) {
        binding?.apply {
            nameTextView.text = character.name
            characterTypeTextView.text = "Character type: ${character.characterType}"
            powersTextView.text = "Powers: ${character.powers}"

            Picasso.with(context)
                .load(character.urlIcon)
                .fit()
                .placeholder(R.drawable.ic_superhero)
                .into(characterImageView)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailsViewModel::class.java)
    }

}