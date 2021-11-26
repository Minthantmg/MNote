package com.example.mnote.Fragment.Edit

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mnote.R
import com.example.mnote.model.User
import com.example.mnote.viewModel.TextViewModel
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_edit.view.*

class EditFragment : Fragment() {

    private val args by navArgs<EditFragmentArgs>()
    private lateinit var mUserViewModel : TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit, container, false)
        mUserViewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        view.edit_text_txt.setText(args.currentText.body)

        view.edit_btn.setOnClickListener {
            updateText()
        }
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete){
            deleteMenu()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteMenu() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mUserViewModel.deleteText(args.currentText)
            Toast.makeText(requireContext(),"Successfully Deleted ${args.currentText.title}!",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_editFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete ${args.currentText.title}?")
        builder.setMessage("Are u sure you want to delete ${args.currentText.title}?")
        builder.create().show()
    }

    private fun updateText() {
        val body = edit_text_txt.text.toString()

        val updateText = User(args.currentText.id,args.currentText.title,args.currentText.label,body)
        mUserViewModel.updateText(updateText)
        findNavController().navigate(R.id.action_editFragment_to_listFragment)
    }

}