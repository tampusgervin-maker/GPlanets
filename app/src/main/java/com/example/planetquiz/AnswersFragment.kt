package com.example.planetquiz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.planetquiz.databinding.FragmentAnswersBinding

class AnswersFragment : Fragment(R.layout.fragment_answers) {
    private var _binding: FragmentAnswersBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnswersBinding.bind(view)

        val questionId = arguments?.getInt("QUESTION_ID") ?: 1

        val (questionText, correctAnswer, answerDetail) = when (questionId) {
            1 -> Triple(getString(R.string.q1), "JUPITER", getString(R.string.ans1_detail))
            2 -> Triple(getString(R.string.q2), "SATURN", getString(R.string.ans2_detail))
            else -> Triple(getString(R.string.q3), "URANUS", getString(R.string.ans3_detail))
        }

        binding.tvQuestion.text = questionText

        // Close floating card tag on 'X' button tap
        binding.btnCloseResult.setOnClickListener {
            binding.cardResult.visibility = View.GONE
        }

        val checkAnswer = { selectedPlanet: String ->
            if (selectedPlanet == correctAnswer) {
                binding.tvResult.text = "CORRECT! $answerDetail"
                binding.tvResult.setTextColor(android.graphics.Color.parseColor("#2E7D32"))
                binding.cardResult.setCardBackgroundColor(android.graphics.Color.parseColor("#E8F5E9"))
            } else {
                binding.tvResult.text = "WRONG! $answerDetail"
                binding.tvResult.setTextColor(android.graphics.Color.parseColor("#C62828"))
                binding.cardResult.setCardBackgroundColor(android.graphics.Color.parseColor("#FFEBEE"))
            }
            binding.cardResult.visibility = View.VISIBLE
        }

        binding.btnMercury.setOnClickListener { checkAnswer("MERCURY") }
        binding.btnVenus.setOnClickListener { checkAnswer("VENUS") }
        binding.btnEarth.setOnClickListener { checkAnswer("EARTH") }
        binding.btnMars.setOnClickListener { checkAnswer("MARS") }
        binding.btnJupiter.setOnClickListener { checkAnswer("JUPITER") }
        binding.btnSaturn.setOnClickListener { checkAnswer("SATURN") }
        binding.btnUranus.setOnClickListener { checkAnswer("URANUS") }
        binding.btnNeptune.setOnClickListener { checkAnswer("NEPTUNE") }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
