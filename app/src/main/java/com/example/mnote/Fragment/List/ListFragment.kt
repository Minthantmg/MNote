package com.example.mnote.Fragment.List

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mnote.R
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.add_floating_btn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_fav){
                findNavController().navigate(R.id.action_listFragment_to_favouriteFragment)
        }else if(item.itemId == R.id.menu_search){
                findNavController().navigate(R.id.action_listFragment_to_searchFragment)
        }
        return super.onOptionsItemSelected(item)
    }


}