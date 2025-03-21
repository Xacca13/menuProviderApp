package com.example.menuprovider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider

class MainFragment : Fragment(), MenuProvider {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this, viewLifecycleOwner)
    }


    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.chat -> {
                Toast.makeText(requireContext(), "CHAT", Toast.LENGTH_SHORT).show()
            }
            R.id.cold -> {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.host, AlarmFragment.newInstance())
                    .commit()
            }
            R.id.alarm -> {
                Toast.makeText(requireContext(), "ALARM", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}