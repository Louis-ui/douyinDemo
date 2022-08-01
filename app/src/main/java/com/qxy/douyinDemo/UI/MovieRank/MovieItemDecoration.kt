package com.qxy.douyinDemo.UI.MovieRank

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MovieItemDecoration: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = 0
            outRect.bottom = 0
        } else {
            outRect.top = 0
            outRect.bottom = 0
        }
    }
}