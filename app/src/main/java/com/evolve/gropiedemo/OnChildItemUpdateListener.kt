package com.evolve.gropiedemo

/**
 * Created by krishna on 5/8/18.
 */
interface OnChildItemUpdateListener{
    fun onChildItemUpdate(id: String, isSelected: Boolean)
    fun onParentSelectionUpdated(position: Int, isSelected: Boolean, children: ArrayList<ToggleSelection>)

}