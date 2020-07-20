package com.example.guessmynumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_guess.*
import kotlinx.android.synthetic.main.fragment_result.*

class GuessFragment : Fragment() {

    var numGuess = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guess, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var options = arrayOf("1", "2", "3", "4", "5")

        spinner_guess.adapter = ArrayAdapter<String>(view.context, R.layout.support_simple_spinner_dropdown_item, options)

        spinner_guess.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                numGuess = options[position].toInt()
            }
        }



        button_guess.setOnClickListener {

            if (numGuess > 0){
                val nextAction = GuessFragmentDirections.nextAction()
                nextAction.setGuessNumber(numGuess)
                Navigation.findNavController(it).navigate(nextAction)
            } else {
                Toast.makeText(it.context, "Empty", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
