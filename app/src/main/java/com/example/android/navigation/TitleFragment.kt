package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val bind = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)

        //when click on the button navigate to gameFragment(swap between fragment)
        // So give Navigation control to is  navigate between fragments inside the activity using it's own fragment Host
        // NavHostFragment.

        bind.playButton.setOnClickListener{ view:View->

            // Set navigation control
            Navigation.findNavController(view).navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())

            // also you can do the code above in another way like :
            //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }
        setHasOptionsMenu(true)

        return bind.root;
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val navControl = findNavController()
        return NavigationUI.onNavDestinationSelected(item,navControl)||super.onOptionsItemSelected(item)
    }
}