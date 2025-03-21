package com.ibm.watson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HelpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find Help Button
        val helpButton: Button = view.findViewById(R.id.helpButton)

        // Set Click Listener to Show Bottom Sheet
        helpButton.setOnClickListener {
            val bottomSheet = HelpBottomSheetFragment()
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }
    }
}