package com.artem.pinpointview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class PinPointView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var size = 1920
    var radius = (6.5).toPx
    var paint = Paint()
     var state:PinState

    init {
        var attributeArray: TypedArray? = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.pinpointview, 0, 0
        )
        paint.color = attributeArray?.getColor(
            R.styleable.pinpointview_colorPins,
            ContextCompat.getColor(context, android.R.color.holo_green_light)
        ) ?: android.R.color.black

       var typedArray=context.obtainStyledAttributes(attrs,R.styleable.pinpointview)
        state=PinState.values()[typedArray.getInt(R.styleable.pinpointview_colorPinsState,0)]
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size = Math.min(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(size, size)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()


        when(state){
            PinState.NONE->{
                paint.color=Color.WHITE
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }

            PinState.ONE->{
                paint.color=Color.GREEN
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                paint.color=Color.WHITE
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }
            PinState.TWO->{
                paint.color=Color.GREEN
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                paint.color=Color.WHITE

                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }
            PinState.THREE->{
                paint.color=Color.GREEN
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                paint.color=Color.WHITE
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }
            PinState.FOUR->{
                paint.color=Color.GREEN
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }
            PinState.ERROR->{
                paint.color=Color.RED
                canvas?.drawCircle(centerX - 9 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX - 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 3 * radius, centerY, radius.toFloat(), paint)
                canvas?.drawCircle(centerX + 9 * radius, centerY, radius.toFloat(), paint)

            }


        }
        invalidate()
        //super.onDraw(canvas)
    }
    enum class PinState() {
        NONE(),
        ONE(),
        TWO(),
        THREE(),
        FOUR(),
        ERROR()
    }
}
