package com.evolve.gropiedemo

import android.widget.CheckBox
import android.widget.TextView
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.category.*


class CategoryItem(var child: String, var parent: ChannelHeaderItem) : Item<ViewHolder>(), ToggleSelection {
    private var isSelected: Boolean = false
   // var binding: CategoryBinding? = null
    var viewHolder:ViewHolder?=null

    override fun getLayout(): Int {
        return R.layout.category
    }


    override fun bind(viewBinding: ViewHolder, position: Int) {
        // this.binding = viewBinding
        this.viewHolder=viewBinding
        viewBinding.itemView.findViewById<TextView>(R.id.txtCategoryName).text = child
        viewBinding.itemView.findViewById<CheckBox>(R.id.action_select_category).isChecked = isSelected
        viewBinding.itemView.findViewById<CheckBox>(R.id.action_select_category).setOnCheckedChangeListener { buttonView, isChecked ->
            isSelected = isChecked
            parent.evaluateSelection(child, isChecked)
        }
    }


    override fun onToggleChange(isSelected: Boolean) {
        // update isSelected state for on parent toggle changed
        this.isSelected = isSelected
        viewHolder?.itemView?.findViewById<CheckBox>(R.id.action_select_category)?.isChecked = isSelected
    }

    override fun getCategoryId(): String {
        return child
    }

    override fun isCategorySelected(): Boolean {
        return isSelected
    }

    fun setSelected(boolean: Boolean){
        isSelected=boolean
    }

}
