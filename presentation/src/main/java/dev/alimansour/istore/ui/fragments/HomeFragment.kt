package dev.alimansour.istore.ui.fragments


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import dev.alimansour.istore.R
import dev.alimansour.istore.adapter.CategoryAdapter
import dev.alimansour.istore.daomain.model.DataSource
import kotlinx.android.synthetic.main.activity_main.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class HomeFragment : Fragment(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var param1: String? = null
    private var param2: String? = null
    var navController: NavController? = null
    private lateinit var mAuth : FirebaseAuth

    private val gridLayoutManager by lazy { GridLayoutManager(activity, 2) }

    private val linearLayoutManager by lazy { LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false) }

    private  val CAdapter by lazy { CategoryAdapter(requireActivity()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false)
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        navController = Navigation.findNavController(view)

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.setOnNavigationItemSelectedListener (this)

            initRecyclePopular()
            initializeRecycleCategory()
            addDataSet()




        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun addDataSet(){
        val source = DataSource.createDataSet()
        CAdapter.submitList(source)
    }

    private fun initializeRecycleCategory(){

        recycle_category.layoutManager = gridLayoutManager
        recycle_category.adapter = CAdapter
    }

    private fun initRecyclePopular(){

        recycle_popular.layoutManager = linearLayoutManager
        recycle_popular.adapter = CAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.bottom_nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.action_logout ->{
               Toast.makeText(
                   activity, "logging Out",
                   Toast.LENGTH_SHORT)
                   .show()

               logOutUser()

           }

       }
        return true
    }

    private fun logOutUser() {
        mAuth = FirebaseAuth.getInstance()
        mAuth.signOut()
    }


}