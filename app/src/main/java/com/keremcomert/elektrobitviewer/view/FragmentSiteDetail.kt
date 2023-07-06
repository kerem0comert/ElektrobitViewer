package com.keremcomert.elektrobitviewer.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.keremcomert.elektrobitviewer.R
import com.keremcomert.elektrobitviewer.databinding.FragmentSiteDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class FragmentSiteDetail: Fragment(R.layout.fragment_site_detail) {

    private var b: FragmentSiteDetailBinding? = null
    private val args: FragmentSiteDetailArgs by navArgs() // TODO: To be fixed, navArgs dont compile for some reason

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentSiteDetailBinding.bind(view)
        b?.apply {
            Glide.with(requireContext())
                .load(args.photo.imgSrc)
                .dontAnimate()
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(ivDetailPhoto)

            site = args.site
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        b = null
    }
}