package com.example.planetquiz
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.planetquiz.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment(R.layout.fragment_questions) {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentQuestionsBinding.bind(view)

        val navigateToAnswers = { questionId: Int ->
            val bundle = Bundle().apply { putInt("QUESTION_ID", questionId) }
            findNavController().navigate(R.id.action_questionsFragment_to_answersFragment, bundle)
        }

        binding.btnQ1.setOnClickListener { navigateToAnswers(1) }
        binding.btnQ2.setOnClickListener { navigateToAnswers(2) }
        binding.btnQ3.setOnClickListener { navigateToAnswers(3) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
