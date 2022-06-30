package com.dgioto.sunset

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator

private lateinit var sceneView: View
private lateinit var sunView: View
private lateinit var skyView: View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получение ссылок на представления
        sceneView = findViewById(R.id.scene)
        sunView = findViewById(R.id.sun)
        skyView = findViewById(R.id.sky)

        //Запуск анимации по нажатию
        sceneView.setOnClickListener {
            startAnimation()
        }
    }

    //Получение верхних координат представлений
    private fun startAnimation() {
        val sunYStart = sunView.top.toFloat()
        val sunYEnd = skyView.height.toFloat()

        //Создание анимации солнца
        val heightAnimator = ObjectAnimator
            .ofFloat(sunView, "y", sunYStart, sunYEnd)
            .setDuration(3000)
        //Добавление ускорения
        heightAnimator.interpolator = AccelerateInterpolator()

        heightAnimator.start()
    }
}