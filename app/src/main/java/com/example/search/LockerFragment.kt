package com.example.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.search.databinding.FragmentLockerBinding


class LockerFragment : Fragment() {    private var _binding: FragmentLockerBinding? = null
private val binding get() = _binding!!

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
    _binding = FragmentLockerBinding.inflate(inflater, container, false)
    return binding.root
}
}