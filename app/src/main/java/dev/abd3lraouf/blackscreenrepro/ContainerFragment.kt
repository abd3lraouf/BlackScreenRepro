package dev.abd3lraouf.blackscreenrepro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class ContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add FirstFragment to the container
        childFragmentManager.commit {
            replace(R.id.fragment_container, FirstFragment())
        }

        // Set an OnClickListener for the button to switch fragments
        view.findViewById<Button>(R.id.btn_switch_fragment).setOnClickListener {
            // Check which fragment is currently displayed
            val currentFragment = childFragmentManager.findFragmentById(R.id.fragment_container)

            childFragmentManager.commit {
                // Set custom animations based on the current fragment
                if (currentFragment is FirstFragment) {
                    // First -> Second , second slides from right to left and First slides to left
                    setCustomAnimations(
                        R.anim.slide_in_right, // second slides in from right
                        R.anim.slide_out_left, // first slides out to left
                        R.anim.slide_in_left, // first slides in from left
                        R.anim.slide_out_right // second slides out to right
                    )
                    replace(R.id.fragment_container, SecondFragment())
                } else {
                    // Second -> First, second slides to left, first slides from left to right
                    setCustomAnimations(
                        R.anim.slide_in_left, // first slides in from left
                        R.anim.slide_out_right, // second slides out to right
                        R.anim.slide_in_right, // second slides in from right
                        R.anim.slide_out_left // first slides out to left
                    )
                    replace(R.id.fragment_container, FirstFragment())
                }

                // Add the transaction to the back stack and commit
                addToBackStack(null)
            }
        }
    }
}