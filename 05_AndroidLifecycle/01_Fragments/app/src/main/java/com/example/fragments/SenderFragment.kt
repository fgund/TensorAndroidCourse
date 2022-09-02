package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Use the [SenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SenderFragment : Fragment() {

    override fun onAttach(context: Context) {
        Log.i("LifecycleTag", "SenderFragment: onAttach")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "SenderFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleTag", "SenderFragment: onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("LifecycleTag", "SenderFragment: onViewCreated")
        view.findViewById<Button>(R.id.send_button).setOnClickListener {
            val receiverFragment = ReceiverFragment.newInstance(
                "Hello! I am message from the SenderFragment!"
            )
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, receiverFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onStart() {
        Log.i("LifecycleTag", "SenderFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleTag", "SenderFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleTag", "SenderFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleTag", "SenderFragment: onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleTag", "SenderFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.i("LifecycleTag", "SenderFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleTag", "SenderFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleTag", "SenderFragment: onDetach")
        super.onDetach()
    }
}