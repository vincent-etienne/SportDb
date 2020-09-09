package com.etienne.vincent.sportdb.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) != 0) {
                top = this@MarginItemDecoration.top
            }
            left = this@MarginItemDecoration.left
            right = this@MarginItemDecoration.right
            bottom = this@MarginItemDecoration.bottom
        }
    }
}