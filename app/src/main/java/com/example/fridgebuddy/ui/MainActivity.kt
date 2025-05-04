package com.example.fridgebuddy.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fridgebuddy.data.AppDatabase
import com.example.fridgebuddy.data.FridgeItem
import com.example.fridgebuddy.data.FridgeRepository
import com.example.fridgebuddy.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: FridgeViewModel by viewModels {
        val dao = AppDatabase.getInstance(this).fridgeItemDao()
        FridgeViewModelFactory(FridgeRepository(dao))
    }

    private lateinit var adapter: FridgeItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeItems()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        adapter = FridgeItemAdapter { item -> viewModel.delete(item) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun observeItems() {
        viewModel.items.observe(this, Observer { list ->
            adapter.submitList(list)
        })
    }

    private fun setupAddButton() {
        binding.fabAdd.setOnClickListener {
            viewModel.add(
                FridgeItem(
                    id = 0,
                    name = "New Item",
                    quantity = 1,
                    addedDate = LocalDate.now(),
                    expirationDate = LocalDate.now().plusDays(7), // <- corrected
                    notes = ""
                )
            )
        }
    }
}
