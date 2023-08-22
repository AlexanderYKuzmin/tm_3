package com.kuzmin.tm_3.ui.nav_objects

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kuzmin.tm_3.R
import com.kuzmin.tm_3.databinding.FragmentNavObjectsBinding
import com.kuzmin.tm_3.domain.model.BuildingSimple
import com.kuzmin.tm_3.ui.nav_objects.BuildingFragment.Companion.BUILDING_ID

class NavObjectsFragment : Fragment() {

    private var _binding: FragmentNavObjectsBinding? = null
    private val binding get() = _binding!!

    lateinit var buildingList: List<BuildingSimple>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildingList = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList(BUILDING_LIST, BuildingSimple::class.java) ?:
            listOf()
        } else {
            arguments?.getParcelableArrayList(BUILDING_LIST) ?: listOf()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNavObjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NavObjectsAdapter(requireActivity())
        binding.rvNavObjects.adapter = adapter

        setOnItemBuildingClickListener(adapter)

        adapter.submitList(buildingList)
    }

    fun setOnItemBuildingClickListener(adapter: NavObjectsAdapter) {
        adapter.onItemBuildingClickListener = {
            findNavController().navigate(R.id.nav_building, bundleOf(BUILDING_ID to it))
        }
    }

    companion object {
        const val BUILDING_LIST = "buildings"
    }
}