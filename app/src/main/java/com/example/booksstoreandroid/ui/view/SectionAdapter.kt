package com.example.booksstoreandroid.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksstoreandroid.databinding.SectionItemBinding
import com.example.booksstoreandroid.ui.data.model.SectionModel

class SectionAdapter(context: Context, sectionsData: List<SectionModel>): RecyclerView.Adapter<SectionAdapter.SectionHolder>() {

  private val items: List<SectionModel>
  private val context: Context

  init {
    this.items = sectionsData
    this.context = context
  }

  inner class SectionHolder(val binding: SectionItemBinding): RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
    val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return SectionHolder(binding)
  }

  override fun onBindViewHolder(holder: SectionHolder, position: Int) {
    with(holder) {
      with(items[position]) {
        binding.txtSectionName.text = this.sectionTitle

        val booksAdapter = BookAdapter(context, this.books)
        binding.rvSections.setHasFixedSize(true)
        binding.rvSections.layoutManager =
            LinearLayoutManager(context, if(this.sectionTitle == "Best Sellers") LinearLayoutManager.HORIZONTAL else LinearLayoutManager.VERTICAL, false)
        binding.rvSections.adapter = booksAdapter
      }
    }
  }

  override fun getItemCount(): Int {
    return items.count()
  }
}