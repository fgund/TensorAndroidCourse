package com.example.fragments

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ReceiverFragment : Fragment() {

    companion object {

        const val FRAGMENT_MESSAGE_KEY = "FRAGMENT_MESSAGE_KEY"

        fun newInstance(message: String): Fragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putString(FRAGMENT_MESSAGE_KEY, message)
                arguments = bundle
            }
    }

    private lateinit var viewModel: ReceiverViewModel
    private lateinit var textView: TextView

    override fun onAttach(context: Context) {
        Log.i("LifecycleTag", "ReceiverFragment: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "ReceiverFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleTag", "ReceiverFragment: onCreateView")
        return inflater.inflate(R.layout.receiver_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("LifecycleTag", "ReceiverFragment: onViewCreated")
        val messageText = requireArguments().getString(
            FRAGMENT_MESSAGE_KEY,
            "Empty message"
        )
        view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.teal_200))
        textView  = view.findViewById<TextView>(R.id.message_text_view)
        viewModel = ViewModelProvider(requireActivity()).get(ReceiverViewModel::class.java)
        viewModel.messageLiveData.observe(requireActivity()) { message ->
            textView.text = message
        }
        viewModel.setMessage(messageText)
        view.findViewById<Button>(R.id.read_button).setOnClickListener {
            viewModel.setIsRead()
        }
    }

    override fun onStart() {
        Log.i("LifecycleTag", "ReceiverFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleTag", "ReceiverFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleTag", "ReceiverFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleTag", "ReceiverFragment: onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleTag", "ReceiverFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.i("LifecycleTag", "ReceiverFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleTag", "ReceiverFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleTag", "ReceiverFragment: onDetach")
        super.onDetach()
    }
}