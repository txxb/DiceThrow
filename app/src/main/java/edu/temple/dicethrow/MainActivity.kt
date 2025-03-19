package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView2, DieFragment.newInstance(20))
            .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as DieFragment)
                .throwDie()

            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2) as DieFragment)
                .throwDie()
        }
    }
}