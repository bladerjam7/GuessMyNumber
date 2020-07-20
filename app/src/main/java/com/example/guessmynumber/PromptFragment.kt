package com.example.guessmynumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_prompt.*
import kotlin.system.exitProcess

class PromptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prompt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_restart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }

        button_exit.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.home_action)
        }

        btn_test.setOnClickListener {
            val testKonfetti = true;
            val nextAction = PromptFragmentDirections.actionPromptFragmentToResultFragment()
            nextAction.setTest(testKonfetti)
            Navigation.findNavController(it).navigate(nextAction)
        }
    }


}
