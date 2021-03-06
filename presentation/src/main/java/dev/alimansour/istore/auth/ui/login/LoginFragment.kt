package dev.alimansour.istore.auth.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dev.alimansour.istore.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var mAuth : FirebaseAuth
    private lateinit var mAuthListener : FirebaseAuth.AuthStateListener
    private val  TAG = "HostActivity"
    var navController:NavController? = null
    private val mLinkTextView : Int = R.id.link_signup

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.findViewById<TextView>(R.id.link_signup).setOnClickListener(this)
        view.findViewById<TextView>(R.id.btn_login).setOnClickListener(this)

        signInUser()

//        checkAuthState()
    }
    /*
    --------------------------------------FIREBASE--------------------------------
     */

    private fun signInUser() {
        mAuth = FirebaseAuth.getInstance()
       btn_login.setOnClickListener{

            if (login_email.text.toString().isNotEmpty()
                && login_password.text.toString().isNotEmpty()){

                showDialog()

                loginUser(

                    login_email.text.toString(),
                    login_password.text.toString()
                )

            }
           hideSoftKeyboard()

        }



    }

private fun loginUser( email: String, password: String) {
    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->


            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                Toast.makeText(
                    activity, "Authentication success.",
                    Toast.LENGTH_SHORT
                ).show()
                val user: FirebaseUser? = mAuth.currentUser

                //navigate to home fragment
                navController?.navigate(R.id.action_loginFragment_to_homeFragment)

                //updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(
                    activity, "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
                // updateUI(null)
            }
        }

}

    //check authState and allow access
private fun checkAuthState() {
    mAuthListener = FirebaseAuth.AuthStateListener{
        val user = FirebaseAuth.getInstance().currentUser
        if (user !=null) {

            //check if email is verified
            if (user.isEmailVerified) {
                Log.d(
                    TAG,
                    "onAuthStateChanged:signed_in:" + user.uid
                )
                Toast.makeText(
                    activity,
                    "Authenticated with: " + user.email,
                    Toast.LENGTH_SHORT
                ).show()

                  //navigate to home fragment
                navController?.navigate(R.id.action_loginFragment_to_homeFragment)


            }else{
                Toast.makeText(
                    activity,
                    "Email is not Verified\nCheck your Inbox",
                    Toast.LENGTH_SHORT
                ).show()
                FirebaseAuth.getInstance().signOut()
            }

        }else{
            // User is signed out

            // User is signed out
            Log.d(
                TAG,
                "onAuthStateChanged:signed_out"
            )
        }
    }
}

private fun showDialog() {
//    progressBar.hide()

}

override fun onStart() {
    super.onStart()

    // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser: FirebaseUser? = mAuth.currentUser
//        if (currentUser != null){
//            startActivity(Intent(this))
//        }
//    FirebaseAuth.getInstance().addAuthStateListener(mAuthListener)


}

override fun onStop() {
    super.onStop()

//    if (mAuthListener != null) {
//        FirebaseAuth.getInstance().removeAuthStateListener { mAuthListener }
//    }
}

    override fun onClick(view: View?) {
        if(view != null){
            when(view.id){
                R.id.link_signup->{
                    navController!!.navigate(R.id.action_loginFragment_to_signUpFragment)
                }
                R.id.btn_login ->{
                    navController!!.navigate(R.id.action_loginFragment_to_signUpFragment)

                }

            }

      }

   }

    private fun hideSoftKeyboard() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }


}
