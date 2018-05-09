package com.evolve.gropiedemo


import android.widget.Toast
import com.evolve.gropiedemo.databinding.ChannelHeaderBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by krishna on 5/8/18.
 */
class ChannelHeaderItem(val position: Int, val headerItem: Channel) : BindableItem<ChannelHeaderBinding>(),
        ExpandableItem {

    private var expandableGroup: ExpandableGroup? = null
    lateinit var binding: ChannelHeaderBinding


    var selectedList: ArrayList<CategoryItem> = arrayListOf()
    private var isSelected = false

    override fun getLayout(): Int {
        return R.layout.channel_header
    }

    override fun bind(viewBinding: ChannelHeaderBinding, position: Int) {
        this.binding = viewBinding
        binding.channelName.text = headerItem.title
        var count = 0
        headerItem.categoryList.forEach {
            if (it.isSelected) {
                count++
            }
        }
        binding.channelToggle.text = " Count : $count"
        binding.root.setOnClickListener {
            expandableGroup?.onToggleExpanded()
        }


    }


    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }

    fun evaluateSelection(parentPosition: Int, category: Category, checked: Boolean) {
        var count = 0
        headerItem.categoryList.forEachIndexed { index, mCategory ->
            if (category.catName == mCategory.catName)
                headerItem.categoryList[index].isSelected = checked
            if (headerItem.categoryList[index].isSelected) {
                count++
            }
        }
        binding.channelToggle.text = " Count : $count"
        Toast.makeText(binding.root.context, "Evaluation ${headerItem.title} --> $count", Toast.LENGTH_SHORT).show()
        // notifyChanged()


    }


}