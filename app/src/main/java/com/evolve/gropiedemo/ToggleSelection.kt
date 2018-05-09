package com.evolve.gropiedemo

/**
 * Created by krishna on 5/8/18.
 */
interface ToggleSelection{
    fun onToggleChange(isSelected: Boolean)
    fun getCategoryId(): String
    fun isCategorySelected(): Boolean
}