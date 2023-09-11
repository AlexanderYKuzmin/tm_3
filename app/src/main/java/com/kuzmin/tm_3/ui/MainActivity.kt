package com.kuzmin.tm_3.ui

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.MenuCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kuzmin.tm_3.R
import com.kuzmin.tm_3.TmApp
import com.kuzmin.tm_3.databinding.ActivityMainBinding
import com.kuzmin.tm_3.extensions.dpToIntPx
import com.kuzmin.tm_3.ui.nav_constructions.NavSitesListFragment.Companion.BUILDING_LIST
import com.kuzmin.tm_3.ui.util.AuthValidation
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
    }

    private val appComponent by lazy {
        (application as TmApp).component
    }

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment_activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        val navView: BottomNavigationView = binding.navView
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_objects,
                R.id.navigation_measurements,
                R.id.navigation_report
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //val startFragmentBundle = Bundle()

        val startFragmentBundle = bundleOf(BUILDING_LIST to viewModel.getConstructionList())
        navController.setGraph(navController.graph, startFragmentBundle)

        viewModel.loadAuthUser()
        viewModel.authUserData.observe(this) {
            if (AuthValidation.isTokenValid(it.token, it.dateToken)) {
                //TODO message network resources available
                //show everything
            }
            else launchAuthFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu, true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mm_new -> {
                //supportFragmentManager.popBackStack()
               // viewModel.handleSearchPanelOnShow()
            }
            R.id.mm_load_local -> {
                //supportFragmentManager.popBackStack()
                //viewModel.handleNew()
            }
            R.id.mm_load_server -> {
                viewModel.handleLoadSitesFromServer()
            }
            R.id.mm_save_local -> {
                //viewModel.handleSave()

                /*val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra(FINISH, true)
                finish()*/
            }
            R.id.mm_save_server -> {

            }
            R.id.mm_sync -> {

            }
            R.id.mm_quit -> {

            }
        }
        return true
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val logo = if (binding.toolbar.childCount > 1) binding.toolbar.getChildAt(1) as ImageView else null
        logo?.scaleType = ImageView.ScaleType.CENTER_INSIDE
        //logo?.background = getDrawable(R.drawable.ic_launcher_background)
        Log.d("Setup toolbar", "logo = $logo")
        val lp = logo?.layoutParams as? Toolbar.LayoutParams
        lp?.let {
            it.width = dpToIntPx(40)
            it.height = dpToIntPx(40)
            it.marginEnd = dpToIntPx(16)
            logo.layoutParams = it
        }

        val title = binding.toolbar.getChildAt(0) as TextView
        val titleTypeFace: Typeface = Typeface.createFromAsset(assets, "fonts/gost_clan_gradient.ttf")
        title.typeface = titleTypeFace
        title.textSize = 24f
        title.setTextColor(ContextCompat.getColor(this, R.color.color_title))
    }

    private fun launchAuthFragment() {
        Log.d(TAG, "Launch login fragment")

        /*val bundle = Bundle().apply {
            putParcelable("auth_user", viewModel.authUserData.value)
        }*/
        navController.navigate(R.id.navigation_login)
    }
    companion object {
        const val TAG = "MainActivity"
    }
}