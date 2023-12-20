package fastcampus.part3.part3chapter6.viewholder

import fastcampus.part3.part3chapter6.ListAdapter
import fastcampus.part3.part3chapter6.databinding.ItemFullAdBinding
import fastcampus.part3.part3chapter6.databinding.ItemHorizontalBinding
import fastcampus.part3.part3chapter6.databinding.ItemSaleBinding
import fastcampus.part3.part3chapter6.model.ListItem
import fastcampus.part3.part3chapter6.model.ViewPager

class HorizontalViewHolder(
    private val binding: ItemHorizontalBinding,
) : BindingViewHolder<ItemHorizontalBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}