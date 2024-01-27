package com.chinenyeakukalia.mynoteapp.app.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth

class AuthViewModel: ViewModel() {
    var isUserAuthenticated = mutableStateOf(false)
    var errorMessage = mutableStateOf("")
    fun loginUser(email: String, password: String){
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    isUserAuthenticated.value = true
                }else
                {
                    errorMessage.value = task.exception?.message.toString()
                    Log.e("Sign In Not Successful", task.exception.toString())
                }
            }
    }
    fun resetPassword(email: String){
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task->
            if(task.isSuccessful){
                isUserAuthenticated.value = true
            }else
            {
                errorMessage.value = task.exception?.message.toString()
                Log.e("Sign In Not Successful", task.exception.toString())
            } }
    }
    fun signInUserWithGoogle(){

    }
    fun signInUserWithApple(){

    }
    fun logOut() {
        Firebase.auth.signOut()
        isUserAuthenticated.value = false // Update the user authentication state
    }
    fun registerUser(username: String, email: String, password: String){
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    isUserAuthenticated.value = true
                    val user = Firebase.auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(username)
                        .build()
                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { profileUpdateTask ->
                          if(profileUpdateTask.isSuccessful) {
                              Log.d("Profile Update", "Profile updated successfully")
                         } else {
                              errorMessage.value = profileUpdateTask.exception?.message ?: "Profile update failed"
                              Log.e("Profile Update", "Profile update failed: ${profileUpdateTask.exception}")
                          }
                     }
                }else
                {
                    errorMessage.value = task.exception?.message.toString()
                    Log.e("Registration Not Successful", task.exception.toString())
                }
            }
    }
    fun clearErrorMessage(){
        errorMessage.value = ""
    }
}
