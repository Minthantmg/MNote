package com.example.mnote.Fragment.Detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mnote.R

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.detail_fav){
            findNavController().navigate(R.id.action_detailFragment_to_favouriteFragment)
        }else if(item.itemId == R.id.detail_search){
            findNavController().navigate(R.id.action_detailFragment_to_searchFragment)
        }else if (item.itemId == R.id.detail_dot){

        }
        return super.onOptionsItemSelected(item)
    }


}