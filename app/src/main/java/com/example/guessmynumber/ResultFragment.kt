package com.example.guessmynumber

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_result.*
import nl.dionsegijn.konfetti.models.Size
import kotlin.random.Random

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = ResultFragmentArgs.fromBundle(it).guessNumber.toString().toInt()
            val test = ResultFragmentArgs.fromBundle(it).test
            val randomNumber = Random.nextInt(1,5)

            /*                                                                     /
            /      Konfetti code made by Daniel Martinus and edited by John Le       /
            /                                                                     */

            if (safeArgs === randomNumber || test === true){
                result_show.setText("Correct!")

                viewKonfetti.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                    .setDirection(0.0, 359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(nl.dionsegijn.konfetti.models.Shape.Circle, nl.dionsegijn.konfetti.models.Shape.Square)
                    .addSizes(Size(12))
                    .setPosition( 550f ,  550f , -50f, -50f)
                    .streamFor(300, 5000L)

            } else {
                result_show.setText("Incorrect!")
            }

            tv_answer.setText(randomNumber.toString())
            tv_guess.setText(safeArgs.toString())
        }

        button_next.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }
    }
}
