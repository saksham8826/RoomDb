package com.example.roomdatabase

import android.content.Context
import com.example.roomdatabase.data.fragment.list.listFragment

class PreferencesProvider(context: Context) {

    private val sharedPreferences=context.getSharedPreferences("myPreferences",0)

    fun putBoolean(Key:String,value: Boolean){
        sharedPreferences.edit().putBoolean(Key,value).apply()
    }

    fun putString(Key: String,value: String){
        sharedPreferences.edit().putString(Key,value).apply()
    }

    fun getString(Key: String):String?{
        return sharedPreferences.getString(Key,null)
    }

    fun putInt(Key: String,value: Int){
        sharedPreferences.edit().putInt(Key,value).apply()

    }
    fun getInt(Key: String):Int{
        return sharedPreferences.getInt(Key,0)
    }

    fun clear(){
        sharedPreferences.edit().clear().apply()
    }

////    var username: SharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////    var password: SharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
//
//
//    val preferences = PreferenceManager.getDefaultSharedPreferences(context)
//    val editor = preferences.edit()
//
//    var name = preferences.getString("Name", "")
//
//        fun setUserPassword(value: String) {
//
//            editor.putString("Name", value)
//            editor.apply()
//
//        }
//
//    fun getUserPassword(value: String?):String {
//
//        var name = preferences.getString("Name", "")
//
//
//        return name.toString()
//
//
//    }
//
//
//
//    //        slowRate = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////        fastRate = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////        startRate = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////        endRate = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////        startingDelay = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
////        beatsDelay = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
//
//
////    var slowRate: SharedPreferences
////    var fastRate: SharedPreferences
////    var startRate: SharedPreferences
////    var endRate: SharedPreferences
////    var startingDelay: SharedPreferences
////    var beatsDelay: SharedPreferences
////
////
////    fun setSlowRate(value: Int) {
////        val editor = slowRate.edit()
////        editor.putInt("slow", value)
////        editor.commit()
////    }
////
////    fun loadSlowRate(): Int {
////        return slowRate.getInt("slow", 50)
////    }
////
////    fun setFastRate(value: Int) {
////        val editor = fastRate.edit()
////        editor.putInt("fast", value)
////        editor.commit()
////    }
////
////    fun loadFastRate(): Int {
////        return fastRate.getInt("fast", 100)
////    }
////
////    fun setStartRate(value: Int) {
////        val editor = startRate.edit()
////        editor.putInt("start", value)
////        editor.commit()
////    }
////
////    fun loadStartRate(): Int {
////        return startRate.getInt("start", 50)
////    }
////
////    fun setEndRate(value: Int) {
////        val editor = endRate.edit()
////        editor.putInt("end", value)
////        editor.commit()
////    }
////
////    fun loadEndRate(): Int {
////        return endRate.getInt("end", 100)
////    }
////
////    fun setStartingDelay(value: Int) {
////        val editor = startingDelay.edit()
////        editor.putInt("startingDelay", value)
////        editor.commit()
////    }
////
////    fun loadStartingDelay(): Int {
////        return startingDelay.getInt("startingDelay", 30)
////    }
////
////    fun setBeatsDelay(value: Int) {
////        val editor = beatsDelay.edit()
////        editor.putInt("beatsDelay", value)
////        editor.commit()
////    }
////
////    fun loadBeatsDelay(): Int {
////        return beatsDelay.getInt("beatsDelay", 1000)
////    }
//
//
////    fun setUserName(value: String) {
////        val editor = username.edit()
////        editor.putString("username", value)
////        editor.apply()
////    }
////
////    fun loadUserName(): String? {
////        return username.getString("username", "")
////    }
////
////    fun setUserPassword(value: String) {
////        val editor = password.edit()
////        editor.putString("password", value)
////        editor.apply()
////    }
////
////    fun loadUserPassword(): String? {
////        return password.getString("password", "")
////    }
//
//    fun settempvalue(): String?
//    {
////        return password.getString("password", "")
//        Log.e("THESHAREDCLASS","ECEUTED")
//        return ""
//    }

}


