package com.neon.dice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainContentFragment : Fragment() {
    lateinit var diceImageView: ImageView
    lateinit var diceTextView: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diceTextView = view.findViewById<TextView>(R.id.dice_roll_result)
        diceImageView = view.findViewById<ImageView>(R.id.dice_image)

        view.findViewById<Button>(R.id.roll_dice_button).setOnClickListener {
            val randomNumber = Random.nextInt(1, 7)
            diceTextView.text = randomNumber.toString()
            diceImageView.setImageResource(convertNumberToDiceResource(randomNumber))
        }
    }

    private fun convertNumberToDiceResource(number: Int) =
            when (number) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> TODO("Able to show only 6 side dice")
            }
}