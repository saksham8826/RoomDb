package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {


    var Username = "saksham"
    var Password = "123"
    private lateinit var preferencesProvider: PreferencesProvider

//    //    var tokenname: SharedPreferences? = null
////    var tokenpwd: SharedPreferences? =null
////    var token: SharedPreferences? = null
//     var sharedPref: SharedPref = SharedPref(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferencesProvider = PreferencesProvider(applicationContext)

        buttonRegister.setOnClickListener {
            var username = nameEt.text.toString()
            var pass = passwordEt.text.toString()

            if (username == Username && pass == Password) {
                var intent = Intent(this, MainActivity::class.java)
                preferencesProvider.putString(Constants.KEY_FIRST_NAME,nameEt.text.toString())
                preferencesProvider.putInt(Constants.KEY_PASS,passwordEt.text.toString().toInt())
                nameEt.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))
                passwordEt.setText(preferencesProvider.getInt(Constants.KEY_PASS).toString())
                startActivity(intent)

                finish()
                Toast.makeText(this, "SuccessFully Registered", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid Entry", Toast.LENGTH_SHORT).show()
            }

//            preferencesProvider.putString(Constants.KEY_FIRST_NAME,nameEt.text.toString())
//            preferencesProvider.putInt(Constants.KEY_PASS,passwordEt.text.toString().toInt())




        }

//        if (Username == sharedPref.loadUserName() && Password == sharedPref.loadUserPassword())
//        {
//            Log.e("log", sharedPref.loadUserName()!!)
//            Log.e("Log", sharedPref.loadUserPassword()!!)
//            startActivity(Intent(this, MainActivity::class.java))
//        }


//        Log.e("THESHAREDCLASS",""+sharedPref.settempvalue())

//        tokenname = getSharedPreferences("loginusername", Context.MODE_PRIVATE)
//        tokenpwd = getSharedPreferences("pwdusername", Context.MODE_PRIVATE)

//        if (tokenname?.getString("loginusername", " ") == " ")
//        {
//            var intent = Intent(this, login::class.java)
//            startActivity(intent)
//            finish()
//        }


        //var value: String? = intent.getStringExtra("reset")

//        if (token?.getString("username"," ")== "reset") {
//            var intent = Intent(this, login::class.java)
//            startActivity(intent)
//            finish()
//            var editor = token?.edit()
//            editor?.putString("username"," ")
//            editor?.apply()
//            editor?.commit()
//        }

        //       val token: SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
//        if (sharedPref.getBoolean(PREF_NAME, false)) {
//            val homeIntent = Intent(this, HomeActivity::class.java)
//            startActivity(homeIntent)
//            finish()
//        } else {
//            setContentView(R.layout.activity_main)
//            setViewPager()
//            val editor = sharedPref.edit()
//            editor.putBoolean(PREF_NAME, true)
//            editor.apply()
//        }
        Log.e("Start", "login activity started")


//        if (token.getBoolean()){
//            //onClear(this)
//            var intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }


//        buttonRegister.setOnClickListener {   //shared prefrence to nahi hogi phir
//            var username = nameEt.text.toString()
//            var pass = passwordEt.text.toString()
//
//            //onSave(this)
//
////            val preferences = PreferenceManager.getDefaultSharedPreferences(this)
////            val editor = preferences.edit()
//
//
////            if (username == Username && pass == Password) {
////                var intent = Intent(this, MainActivity::class.java)
////                sharedPref.setUserName(username)
////                sharedPref.setUserPassword(pass)
////                startActivity(intent)
////
////                finish()
////                Toast.makeText(this, "SuccessFully Registered", Toast.LENGTH_SHORT).show()
////            } else {
////                Toast.makeText(this, "Invalid Entry", Toast.LENGTH_SHORT).show()
////            }
//
//
//
//            getvalue()
//        }
//    }
//
//            fun getvalue(){
////                val preferences = PreferenceManager.getDefaultSharedPreferences(this)
//
//            }
//
//
//
//    fun onSave(context: Context) {
//        val pref = getPreferences(Context.MODE_PRIVATE)
//        val editor = pref.edit()
//        editor.putString("loginusername", nameEt.text.toString())
//        editor.putInt("pwd", passwordEt.text.toString().toInt())
//        editor.commit()
//        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show()
//
//    }
//
//    fun onClear(context: Context) {
//        val pref = getPreferences(Context.MODE_PRIVATE)
//        val editor = pref.edit()
//        editor.clear()
//        editor.commit()
//        nameEt.setText(" ")
//        passwordEt.setText(0)
//    }

    }
}