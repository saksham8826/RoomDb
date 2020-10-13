package com.example.roomdatabase.data.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.model.User
import com.example.roomdatabase.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = editTextPersonFirstName.text.toString()
        val lastName=editTextPersonLastName.text.toString()
        val age = editTextPersonAge.text

        if (inputCheck(firstName,lastName,age)){
            //user obj
            val user = User(0,firstName,lastName,Integer.parseInt(age.toString()))

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Added Successfully", Toast.LENGTH_SHORT).show()
            //navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else
        {
            Toast.makeText(requireContext(), "Please Enter Data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName : String,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName) && age.isEmpty())

    }


}