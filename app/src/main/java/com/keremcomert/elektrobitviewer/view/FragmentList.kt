package com.keremcomert.elektrobitviewer.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.keremcomert.elektrobitviewer.R
import com.keremcomert.elektrobitviewer.databinding.FragmentListBinding
import com.keremcomert.elektrobitviewer.databinding.FragmentSiteDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentList: Fragment(R.layout.fragment_list) {

    private var b: FragmentListBinding? = null
    private val args: FragmentListArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentListBinding.bind(view)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        b = null
    }
}