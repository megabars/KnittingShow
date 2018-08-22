package ru.mezentsev.knittingshow.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_item.view.*

open class KnittingHolder (val mView: View): RecyclerView.ViewHolder(mView) {

    val nameView: TextView = mView.content
}