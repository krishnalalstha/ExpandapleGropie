package com.evolve.gropiedemo

import android.widget.CheckBox
import android.widget.TextView
import com.evolve.gropiedemo.databinding.CategoryBinding
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import kotlinx.android.synthetic.main.category.*


class CategoryItem(var parentPostion:Int,var child: Category,  parent: ChannelHeaderItem) : BindableItem<CategoryBinding>(), ToggleSelection {
    private var isSelected: Boolean = false
   // var binding: CategoryBinding? = null
    var viewHolder:CategoryBinding?=null
    var parent:ChannelHeaderItem
    var headerMap= mapOf<Int,ChannelHeaderItem>()

    init {
        this.parent=parent
    }

    override fun getLayout(): Int {
        return R.layout.category

    }


    override fun bind(viewBinding: CategoryBinding, position: Int) {
        // this.binding = viewBinding
        this.viewHolder=viewBinding
        viewBinding.txtCategoryName.text = child.catName
        viewBinding.actionSelectCategory.setOnCheckedChangeListener(null)
        viewBinding.actionSelectCategory.isChecked = isSelected
        viewBinding.actionSelectCategory.setOnCheckedChangeListener { buttonView, isChecked ->
            isSelected = isChecked
            parent.evaluateSelection(position,child, isChecked)
        }
    }


    override fun onToggleChange(isSelected: Boolean) {
        // update isSelected state for on parent toggle changed
        this.isSelected = isSelected
        viewHolder?.actionSelectCategory?.isChecked = isSelected
    }

    override fun getCategoryId(): String {
        return child.catName
    }

    override fun isCategorySelected(): Boolean {
        return isSelected
    }

    fun setSelected(boolean: Boolean){
        isSelected=boolean
    }

}
