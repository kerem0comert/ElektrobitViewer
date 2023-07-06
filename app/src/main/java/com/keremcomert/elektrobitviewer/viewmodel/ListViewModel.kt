package com.keremcomert.elektrobitviewer.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keremcomert.elektrobitviewer.api.Repository


class ListViewModel @ViewModelInject constructor(private val repository: Repository,
                                                  @Assisted state: SavedStateHandle
): ViewModel() {


}