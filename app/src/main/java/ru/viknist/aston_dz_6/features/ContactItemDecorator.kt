package ru.viknist.aston_dz_6.features

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.viknist.aston_dz_6.R

class ContactItemDecorator(context: Context) : RecyclerView.ItemDecoration() {
    var margin = context.resources.getDimensionPixelSize(R.dimen.margin)
    var border = context.resources.getDimensionPixelSize(R.dimen.border)
    private val paint = Paint()

    init {
        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = border.toFloat()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = margin
        outRect.bottom = margin
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val top = view.bottom + margin
            val bottom = top + border
            canvas.drawLine(left.toFloat(), top.toFloat(), right.toFloat(), top.toFloat(), paint)
            canvas.drawLine(
                left.toFloat(),
                bottom.toFloat(),
                right.toFloat(),
                bottom.toFloat(),
                paint
            )
        }
    }
}