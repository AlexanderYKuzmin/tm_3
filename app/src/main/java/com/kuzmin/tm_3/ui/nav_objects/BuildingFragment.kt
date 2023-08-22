package com.kuzmin.tm_3.ui.nav_objects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kuzmin.tm_3.R
import com.kuzmin.tm_3.TmApp
import com.kuzmin.tm_3.databinding.FragmentBuildingBinding
import com.kuzmin.tm_3.domain.model.Building
import com.kuzmin.tm_3.ui.ViewModelFactory
import javax.inject.Inject

class BuildingFragment : Fragment() {
    private var _binding: FragmentBuildingBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val buildingFragmentViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[BuildingFragmentViewModel::class.java]
    }

    private val buildingComponent by lazy {
        (requireActivity().application as TmApp).component.getBuildingSubComponent()
    }

    private var buildingId: Long = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildingComponent.inject(this)

        arguments?.let {
            buildingId = it.getLong(BUILDING_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvBuildingId.text = buildingId.toString()
    }

    companion object {
        const val BUILDING_ID = "building_id"
    }
}