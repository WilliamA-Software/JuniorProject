package com.example.juniorprojectapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juniorprojectapplication.BeerProvider
import com.example.juniorprojectapplication.data.model.Beer
import com.example.juniorprojectapplication.ui.fragments.DetailsBeerFragment
import com.example.juniorprojectapplication.PrincipalAux
import com.example.juniorprojectapplication.ui.adapters.BeerAdapter
import com.example.juniorprojectapplication.R
import com.example.juniorprojectapplication.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity(), PrincipalAux {

    private lateinit var mBinding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setToolbar()
        setListeners()
        setupRecyclerView()
    }

    fun showError(){
        Toast.makeText(this,getString(R.string.message_common_error),Toast.LENGTH_SHORT).show()
    }

    private fun setToolbar() {
        val bundle = intent.extras
        val username = bundle?.getString("username")
        supportActionBar?.title = username
    }

    private fun setListeners(){

    }

    // Menu logout button
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Click menu logout button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_logout -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun launchDetailsFragment(args:Bundle?){
        val fragment = DetailsBeerFragment()

        args.let { fragment.arguments = it }

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.clMain, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun setupRecyclerView() {
        mBinding.rvBeer.layoutManager = LinearLayoutManager(this)
        mBinding.rvBeer.adapter = BeerAdapter(BeerProvider.beerMutableList) { beer ->
            onItemSelected(beer)
        }
    }

    private fun onItemSelected(beer:Beer){
        Toast.makeText(this, beer.name, Toast.LENGTH_SHORT).show()
        val args = Bundle()
        args.putString(getString(R.string.arg_image), beer.imageUrl)
        args.putString(getString(R.string.arg_name), beer.name)
        args.putLong(getString(R.string.arg_id), beer.id)
        args.putString(getString(R.string.arg_tagline), beer.tagline)
        args.putString(getString(R.string.arg_abv), beer.abv.toString().trim())
        args.putString(getString(R.string.arg_ph), beer.ph.toString().trim())
        args.putString(getString(R.string.arg_attenuation_level), beer.attenuationLevel.toString())
        args.putString(getString(R.string.arg_description), beer.description)

        launchDetailsFragment(args)
    }

    override fun detailsBeer(beer: Beer) {
        TODO("Not yet implemented")
    }
}