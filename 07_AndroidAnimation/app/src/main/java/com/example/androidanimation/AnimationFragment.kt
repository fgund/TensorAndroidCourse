package com.example.androidanimation

import android.animation.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment

class AnimationFragment : Fragment() {

    private lateinit var squareView: View
    private lateinit var rectView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        squareView = view.findViewById(R.id.square_view)
        rectView = view.findViewById(R.id.rectangle_view)

        view.findViewById<Button>(R.id.animate_button).setOnClickListener {
            val startColor = resources.getColor(R.color.square_initial_color)
            val endColor = resources.getColor(R.color.square_final_color)

            val startSquareSize = resources.getDimension(R.dimen.square_initial_size).toInt()
            val finalSquareSize = resources.getDimension(R.dimen.square_final_size).toInt()

            val startRectHeight = resources.getDimension(R.dimen.rectangle_initial_height).toInt()
            val finalRectHeight = resources.getDimension(R.dimen.rectangle_final_height).toInt()

            val colorHolder = PropertyValuesHolder.ofInt("color", startColor, endColor)
            val viewSizeHolder = PropertyValuesHolder.ofInt("square_size", startSquareSize, finalSquareSize)
            val rectHeightHolder = PropertyValuesHolder.ofInt("rect_height", startRectHeight, finalRectHeight)
            colorHolder.setEvaluator(ArgbEvaluator())

            ValueAnimator.ofPropertyValuesHolder(viewSizeHolder, colorHolder, rectHeightHolder).apply {
                duration = 400
                interpolator = LinearInterpolator()
                addUpdateListener { valueAnimator: ValueAnimator ->
                    val viewSize = valueAnimator.getAnimatedValue("square_size") as Int
                    squareView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        width = viewSize
                        height = viewSize
                    }
                    val color = valueAnimator.getAnimatedValue("color") as Int
                    squareView.setBackgroundColor(color)

                    val rectHeight = valueAnimator.getAnimatedValue("rect_height") as Int
                    rectView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        height = rectHeight
                    }
                }
                start()
            }
            // Сбрасываем обработчик нажатия.
            it.setOnClickListener{}
        }
    }
}