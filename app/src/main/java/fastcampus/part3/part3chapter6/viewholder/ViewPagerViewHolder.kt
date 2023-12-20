package fastcampus.part3.part3chapter6.viewholder

import fastcampus.part3.part3chapter6.ListAdapter
import fastcampus.part3.part3chapter6.databinding.ItemCouponBinding
import fastcampus.part3.part3chapter6.databinding.ItemSaleBinding
import fastcampus.part3.part3chapter6.databinding.ItemSellItemBinding
import fastcampus.part3.part3chapter6.databinding.ItemViewpagerBinding
import fastcampus.part3.part3chapter6.model.ListItem
import fastcampus.part3.part3chapter6.model.ViewPager

class ViewPagerViewHolder(
    binding:ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}