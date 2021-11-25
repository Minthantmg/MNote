package com.example.mnote.Fragment.List

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mnote.R
import com.example.mnote.viewModel.TextViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mTextViewModel : TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = view.recyclerView
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mTextViewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        mTextViewModel.readAllData.observe(viewLifecycleOwner, Observer { text ->
            adapter.setData(text)
        })

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
        if(item.itemId == R.id.menu_search){
                findNavController().navigate(R.id.action_listFragment_to_searchFragment)
        }else if(item.itemId == R.id.menu_delete){
            deleteAllTexts()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllTexts() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mTextViewModel.deleteAllTexts()
            Toast.makeText(requireContext(),"Successfully Deleted everything!", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete Everything?")
        builder.setMessage("Are u sure you want to delete Everything?")
        builder.create().show()
    }


}