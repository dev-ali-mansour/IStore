package dev.alimansour.istore.auth.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import dev.alimansour.istore.R
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment : Fragment(), OnClickListener {

    private val TAG = "SignUpFragment"
    private var navController: NavController? = null

//    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        link_login.setOnClickListener(this)

        //check for null values EditText fields
        btn_register.setOnClickListener {
            Log.d(TAG, "onClick: attempting to register.")

            //check for null valued EditText fields
            if (input_name.text.toString().isNotEmpty()
                && input_email.text.toString().isNotEmpty()
                && input_password.text.toString().isNotEmpty()
                && input_confirm_password.text.toString().isNotEmpty()
            ) {

                    //check if passwords match
                    if (doStringsMatch(
                            input_password.text.toString(),
                            input_confirm_password.text.toString()
                        )
                    ) {

                        //Initiate registration task
                        registerNewEmail(
                            input_email.text.toString(),
                            input_password.text.toString()
                        )
                    } else {
                        Toast.makeText(
                            activity,
                            "Passwords do not Match",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

            } else {
                Toast.makeText(
                    activity,
                    "You must fill out all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

           hideSoftKeyboard()
    }

    private fun registerNewEmail(email: String?, password: String?) {
        showDialog()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener { task ->
                Log.d(
                    TAG,
                    "createUserWithEmail:onComplete:" + task.isSuccessful
                )
                if (task.isSuccessful) {
                    Log.d(
                        TAG,
                        "onComplete: AuthState: " + (FirebaseAuth.getInstance().currentUser
                            ?.uid)
                    )

                    //send email verification
//                    sendVerificationEmail()
                    FirebaseAuth.getInstance().signOut()

                    //redirect the user to the login screen
                    redirectLoginScreen()
                }
                if (!task.isSuccessful) {
                    Toast.makeText(
                        activity, "Unable to Register",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                hideDialog()


            }
    }

    private fun redirectLoginScreen() {
        navController?.navigate(R.id.action_signUpFragment_to_loginFragment)
    }


    private fun sendVerificationEmail() {
        val user = FirebaseAuth.getInstance().currentUser
        user?.sendEmailVerification()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(activity, "Sent Verification Email", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(
                    activity,
                    "Couldn't Verification Send Email",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun doStringsMatch(s1: String, s2: String): Boolean {
        return s1 == s2
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.link_login ->{
                    navController?.navigate(R.id.action_signUpFragment_to_loginFragment)
                }

            }
        }
    }

    private fun showDialog() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideDialog() {
        if (progressBar.visibility == View.VISIBLE) {
            progressBar.visibility = View.INVISIBLE
        }
    }

    private fun hideSoftKeyboard() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

}