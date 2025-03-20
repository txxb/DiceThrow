package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    val ROLL_VALUE = "rollvalue"
    var currentRoll = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    lateinit var dieViewModel : DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.getCurrentRoll().observe(viewLifecycleOwner){
            dieTextView.text = it.toString()
        }

        if( dieViewModel.getCurrentRoll().value == null){
            throwDie()
        }

        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        currentRoll = Random.nextInt(1, dieSides+1)
        dieViewModel.setCurrentRoll(currentRoll)
    }
}