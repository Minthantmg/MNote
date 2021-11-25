package com.example.mnote.Fragment.Detail

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mnote.R
import com.example.mnote.model.User
import com.example.mnote.viewModel.TextViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.fragment_list.*

class DetailFragment : Fragment() {

    private lateinit var mViewModel : TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        mViewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }


        setHasOptionsMenu(true)
        return view
    }

    private fun insertDataToDatabase() {
        val title = title_et.text.toString()
        val label = label_et.text.toString()
        val text = text_et.text

        if (title.isEmpty() || label.isEmpty()){
            Toast.makeText(requireContext(),"Please fill all Fields!!",Toast.LENGTH_LONG).show()
        }else{
            val texts = User(0,title,label,text.toString())
            mViewModel.addTitle(texts)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if(item.itemId == R.id.detail_dot){

        }
        return super.onOptionsItemSelected(item)
    }
    
}