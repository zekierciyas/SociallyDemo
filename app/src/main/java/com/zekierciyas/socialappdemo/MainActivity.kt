package com.zekierciyas.socialappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var progressState: ProgressState = ProgressState.FirstState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val button = findViewById<Button>(R.id.button_next_v1)
        val progressVar = findViewById<ImageView>(R.id.progress_bar)
        val imageHero = findViewById<ImageView>(R.id.image_view_hero)


        button.setOnClickListener {
            when (progressState) {
              is ProgressState.FirstState -> {
                  imageHero.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_hero_img_v2))
                  button.setBackgroundResource(R.drawable.ic_button_next_v2)
                   progressState = ProgressState.SecondState
                    progressVar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_progress_bar_second))
               }

               is ProgressState.SecondState -> {
                   button.setBackgroundResource(R.drawable.ic_button_next_v1)
                   progressState = ProgressState.LastState
                    progressVar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_progress_bar_third))
               }

                is ProgressState.LastState -> {
                    Toast.makeText(this, "Navigate time", Toast.LENGTH_SHORT).show()
                }
            }
        }*/
    }

    sealed class ProgressState {
        object FirstState: ProgressState()
        object SecondState: ProgressState()
        object LastState: ProgressState()
    }
}