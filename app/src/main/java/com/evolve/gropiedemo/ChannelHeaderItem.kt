package com.evolve.gropiedemo

import android.support.v7.widget.SwitchCompat
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder


import kotlinx.android.synthetic.main.channel_header.*

/**
 * Created by krishna on 5/8/18.
 */
class ChannelHeaderItem(val position: Int, val headerItem: Channel) : Item<com.xwray.groupie.ViewHolder>(),
        ExpandableItem {

    private var expandableGroup: ExpandableGroup? = null
    lateinit var binding: ViewHolder


    var selectedList: ArrayList<CategoryItem> = arrayListOf()
    private var isSelected = false

    override fun getLayout(): Int {
        return R.layout.channel_header
    }

    override fun bind(viewBinding: ViewHolder, position: Int) {
        this.binding = viewBinding
        binding.itemView.findViewById<TextView>(R.id.channel_name).text = headerItem.title

        binding.itemView.findViewById<TextView>(R.id.channel_toggle).text = " Count : 0"


        binding.itemView.setOnClickListener {
            expandableGroup?.onToggleExpanded()
        }


    }


    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }

    fun evaluateSelection(hashCode: String, checked: Boolean) {
        var count = 0
        selectedList.forEach { toggleSelection ->
            if (toggleSelection.getCategoryId() == hashCode) {
                toggleSelection.setSelected(checked)
            }
            if(toggleSelection.isCategorySelected()){
                count++
            }
        }

        binding.itemView.findViewById<TextView>(R.id.channel_toggle).text = " Count : $count"
        Toast.makeText(binding.itemView.context,"Evaluation $count",Toast.LENGTH_SHORT).show()


    }




}