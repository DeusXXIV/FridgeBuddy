// app/src/main/java/com/example/fridgebuddy/ui/FridgeItemAdapter.kt
package com.example.fridgebuddy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fridgebuddy.data.FridgeItem
import com.example.fridgebuddy.databinding.ItemFridgeBinding
import java.time.format.DateTimeFormatter

class FridgeItemAdapter(
    private val onDelete: (FridgeItem) -> Unit
) : ListAdapter<FridgeItem, FridgeItemAdapter.VH>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemFridgeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(getItem(position))

    inner class VH(private val binding: ItemFridgeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FridgeItem) {
            binding.name.text = item.name
            binding.expiry.text = item.expirationDate.format(DateTimeFormatter.ISO_DATE)
            binding.btnDelete.setOnClickListener { onDelete(item) }
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<FridgeItem>() {
            override fun areItemsTheSame(old: FridgeItem, new: FridgeItem) =
                old.id == new.id
            override fun areContentsTheSame(old: FridgeItem, new: FridgeItem) =
                old == new
        }
    }
}
