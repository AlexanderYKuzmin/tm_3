package com.kuzmin.tm_3.ui.nav_constructions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kuzmin.tm_3.databinding.ItemConstructionBinding
import com.kuzmin.tm_3.domain.model.ConstructionSimple
import com.kuzmin.tm_3.extensions.formatToDate

class NavObjectsAdapter(
    val context: Context
) : ListAdapter<ConstructionSimple, NavObjectsAdapter.ItemBuildingSimpleViewHolder>(BuildingSimpleDiffCallback) {

    var onItemBuildingClickListener: ((Long) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemBuildingSimpleViewHolder {
        val binding = ItemConstructionBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        return ItemBuildingSimpleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemBuildingSimpleViewHolder, position: Int) {
        val buildingSimple = getItem(position)
        with(holder.binding) {
            with(buildingSimple) {
                tvBuildingName.text = name
                tvAddressBuilding.text = address
                tvEmployee.text = employee
                tvCreationDate.text = date.formatToDate()
                root.setOnClickListener {
                    onItemBuildingClickListener?.invoke(id)
                }
            }
        }
    }

    inner class ItemBuildingSimpleViewHolder(
        val binding: ItemConstructionBinding
    ) : RecyclerView.ViewHolder(binding.root)

    object BuildingSimpleDiffCallback : DiffUtil.ItemCallback<ConstructionSimple>(){
        override fun areItemsTheSame(oldItem: ConstructionSimple, newItem: ConstructionSimple): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ConstructionSimple, newItem: ConstructionSimple): Boolean {
            return oldItem == newItem
        }
    }
}