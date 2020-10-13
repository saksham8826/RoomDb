package com.example.roomdatabase.data.fragment.list

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.Constants
import com.example.roomdatabase.PreferencesProvider
import com.example.roomdatabase.R
import com.example.roomdatabase.Login
import com.example.roomdatabase.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class listFragment : Fragment() {

    private lateinit var mUserViewModel : UserViewModel
    private var preferencesProvider: PreferencesProvider? =null
   // SharedPreferences preferences = getSharedPreferences("pref", Context.MODE_PRIVATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        Log.e("THEVALUE","IN listFragment"+Constants.KEY_FIRST_NAME);

        //Recyclerview
        val adapter=ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
            adapter.setData(user)
        })


        view.recyclerView_button.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        view.reset_button.setOnClickListener {
            preferencesProvider?.clear()
            startActivity(Intent(context,Login::class.java))
            Log.e("Value of Keyuser",Constants.KEY_FIRST_NAME)
            Toast.makeText(requireContext(), "Login Data Cleared", Toast.LENGTH_SHORT).show()



        }
//
////
////            var editor = sharedPreference.edit()
////            editor.putString("username","Anupam")
////
////            editor.commit()
//
////            var token: SharedPreferences? = null
//            val intent = Intent(context, login::class.java)
//
////            val token =  getDefaultSharedPreferences(
////                "",
////                Context.MODE_PRIVATE
////            )
////            var editor = token?.edit()
////            editor?.putString("loginusername","")
////            editor?.apply()
////            editor?.commit()
//            activity?.startActivity(intent)
//            activity?.finish()
////            startActivity(Intent(context,login::class.java))
//////            val intent = Intent(context, login::class.java)
//////            intent?.putExtra("token","reset")
//////          activity?.startActivity(intent)
////            activity?.finish()
//            Log.e("Main","hello")
//
//        }

        setHasOptionsMenu(true)

        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){ _, _ ->
            mUserViewModel.deleteAllUser()
            Toast.makeText(requireContext(), "SuccessFully Removed Everything", Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }

        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete EveryThing?")
        builder.setMessage("Are you sure you want to Delete EveryThing?")
        builder.create().show()
    }


    }

