package ru.mezentsev.knittingshow.fragment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mezentsev.knittingshow.R


import ru.mezentsev.knittingshow.fragment.KnittingListFragment.OnListFragmentInteractionListener

import ru.mezentsev.knittingshow.dto.Knitting
import ru.mezentsev.knittingshow.holders.KnittingHolder

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class KnittingRecyclerViewAdapter(
        private val items: List<Knitting>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), KnittingListFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: Knitting?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Knitting
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        return KnittingHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
//        holder.mIdView.text = item.id
        val data = holder as KnittingHolder
        data.nameView.text = item.name

        with(data.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = items.size

}
