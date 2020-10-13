package com.example.roomdatabase.data.fragment.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabase.R
import com.example.roomdatabase.model.User
import com.example.roomdatabase.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.UpdateFirstName.setText(args.UpdateUser.firstName)
        view.UpdateLastName.setText(args.UpdateUser.lastName)
        view.UpdatePersonAge.setText(args.UpdateUser.age.toString())

          view.Update_add_button.setOnClickListener {
                updateItem()
          }

        //add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val firstName = UpdateFirstName.text.toString()
        val lastName = UpdateLastName.text.toString()
        val age = Integer.parseInt(UpdatePersonAge.text.toString())

        if (inputCheck(firstName, lastName, UpdatePersonAge.text)) {
            //updated user object
            val updateUser = User(args.UpdateUser.id, firstName, lastName, age)

            //update current user
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_SHORT).show()
            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else
        {
            Toast.makeText(requireContext(), "Please Fill the Details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName : String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName) && age.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){_,_->
            mUserViewModel.deleteUser(args.UpdateUser)
            Toast.makeText(requireContext(), "SuccessFully Removed ${args.UpdateUser.firstName}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }

        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete ${args.UpdateUser.firstName}")
        builder.setMessage("Are you sure you want to delete ${args.UpdateUser.firstName}")
        builder.create().show()
    }
}