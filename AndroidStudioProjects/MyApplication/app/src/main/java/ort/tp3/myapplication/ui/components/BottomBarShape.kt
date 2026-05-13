package ort.tp3.myapplication.ui.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomBarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            val width = size.width
            val height = size.height
            val centerX = width / 2

            val sideHeight = 65f
            val peakY = 0f
            val cradleDepth = 125f
            val radius = 145f

            moveTo(0f, sideHeight)

            lineTo(centerX - radius, peakY)


            cubicTo(
                x1 = centerX - radius + 35f, y1 = peakY,
                x2 = centerX - radius + 35f, y2 = cradleDepth,
                x3 = centerX, y3 = cradleDepth
            )

            cubicTo(
                x1 = centerX + radius - 35f, y1 = cradleDepth,
                x2 = centerX + radius - 35f, y2 = peakY,
                x3 = centerX + radius, y3 = peakY
            )

            lineTo(width, sideHeight)

            lineTo(width, height)
            lineTo(0f, height)
            close()
        })
    }
}