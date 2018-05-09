package com.evolve.gropiedemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by krishna on 5/8/18.
 */
class MainFragment : Fragment() {


    lateinit var groupieAdapter: GroupAdapter<ViewHolder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainFragment.activity)
            adapter = buildAdapter(getDummyData())
        }


    }


    fun buildAdapter(list: List<Channel>): GroupAdapter<ViewHolder> {
        groupieAdapter = GroupAdapter()
        return groupieAdapter.apply {
            list.forEachIndexed { index, channel ->
                val parent = ChannelHeaderItem(index, channel)
                val expandableGroup = ExpandableGroup(parent)
                channel.categoryList.forEach { category ->
                    expandableGroup.apply {
                        val item = CategoryItem(index, category, parent)
                        parent.selectedList.add(item)
                        add(Section(item))
                    }
                }
                add(expandableGroup)
            }
        }


    }



    private fun getDummyData(): List<Channel> {
        val list = mutableListOf<Channel>()
        for (i in 1..10) {
            list.add(Channel("Header $i", getDummyCategory(i)))
        }
        return list
    }


    private fun getDummyCategory(index: Int): List<Category> {
        val list = mutableListOf<Category>()
        for (i in 1..5) {
            list.add(Category("Category $index$i",false))
        }

        return list

    }

}




