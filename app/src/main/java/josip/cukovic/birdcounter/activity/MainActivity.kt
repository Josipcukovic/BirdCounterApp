package josip.cukovic.birdcounter.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import josip.cukovic.birdcounter.BirdCounterApplication
import josip.cukovic.birdcounter.R

import josip.cukovic.birdcounter.databinding.ActivityMainBinding
import josip.cukovic.birdcounter.model.BirdCounter

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val birdCounter = BirdCounter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpUi()
    }

    private fun setUpUi() {
        mainBinding.btnBlueBird.setOnClickListener{
            changeToBlue()
            saveCount()
        }
        mainBinding.btnGreenBird.setOnClickListener{
            changeToGreen()
            saveCount()
        }
        mainBinding.btnRedBird.setOnClickListener{
            changeToRed()
            saveCount()
       }
        mainBinding.btnYellowBird.setOnClickListener{
            changeToYellow()
            saveCount()
        }

        mainBinding.btnReset.setOnClickListener{resetValues()}
    }

    private fun resetValues() {
        birdCounter.resetBirdCounter()
        birdCounter.saveBirdColor(ContextCompat.getColor(BirdCounterApplication.ApplicationContext, R.color.white))
        displayWelcomeMessage()
    }

    private fun changeToYellow() {
        birdCounter.saveBirdColor(ContextCompat.getColor(BirdCounterApplication.ApplicationContext, R.color.yellow))
    }

    private fun changeToRed() {
        birdCounter.saveBirdColor(ContextCompat.getColor(BirdCounterApplication.ApplicationContext, R.color.red))
    }

    private fun changeToGreen() {
        birdCounter.saveBirdColor(ContextCompat.getColor(BirdCounterApplication.ApplicationContext, R.color.green))
    }

    private fun changeToBlue() {
        birdCounter.saveBirdColor(ContextCompat.getColor(BirdCounterApplication.ApplicationContext, R.color.blue))
    }

    override fun onResume() {
        super.onResume()
        displayWelcomeMessage()
    }

    private fun displayWelcomeMessage() {
        mainBinding.tvCountValue.text = birdCounter.getCounter().toString()
        mainBinding.tvCountValue.setBackgroundColor(birdCounter.getLastBirdColor())
    }

    private fun saveCount() {
        birdCounter.birdSeen()
        displayWelcomeMessage()
    }

}