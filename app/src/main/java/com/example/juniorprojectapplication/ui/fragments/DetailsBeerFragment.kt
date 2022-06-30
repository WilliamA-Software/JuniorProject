package com.example.juniorprojectapplication.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.juniorprojectapplication.R
import com.example.juniorprojectapplication.core.Constants
import com.example.juniorprojectapplication.data.model.Beer
import com.example.juniorprojectapplication.databinding.FragmentDetailsBeerBinding
import com.example.juniorprojectapplication.remote.beer.BeerApiInterface
import com.example.juniorprojectapplication.ui.activities.PrincipalActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsBeerFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailsBeerBinding
    private var mActivity: PrincipalActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentDetailsBeerBinding.inflate(inflater,container,false)

        return mBinding.root
    }


    private fun getBeersRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*
    private fun searchById(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<Beer> = getBeersRetrofit().create(BeerApiInterface::class.java).getBeers("$query")
            val beers : Beer? = call.body()

            mActivity!!.runOnUiThread {
                if(call.isSuccessful){
                    val image : String? = beers?.imageUrl ?: null
                    val title: String? = beers?.name?: null

                    mBinding.tvTitleDescriptionBeer.text = title

                }else{
                    mActivity!!.showError()
                }
            }

        }
    }

     */



    // Configuration Actionbar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getLong(getString(R.string.arg_id),0)
        val name = arguments?.getString(getString(R.string.arg_name),null)
        val image = arguments?.getString(getString(R.string.arg_image), null)
        val tagline = arguments?.getString(getString(R.string.arg_tagline), null)
        val ph = arguments?.getString(getString(R.string.arg_ph), null)
        val abv = arguments?.getString(getString(R.string.arg_abv), null)
        val description = arguments?.getString(getString(R.string.arg_description), null)
        val attenuationLevel = arguments?.getString(getString(R.string.arg_attenuation_level), null)

        if(id!=null && id!=0L){
            Toast.makeText(activity,id.toString(),Toast.LENGTH_SHORT).show()
            mBinding.tvValueId.text = id.toString()
            mBinding.tvTitleDescriptionBeer.text = name
            mBinding.tvValueTagline.text = tagline
            mBinding.tvValueAbv.text = abv
            mBinding.tvValueAttenuationLevel.text = attenuationLevel
            mBinding.tvValuePh.text = ph
            mBinding.tvValueDescription.text = description
            Glide.with(mBinding.ivDetailsBeer.context).load(image).into(mBinding.ivDetailsBeer)
        }else{
            Toast.makeText(activity,getString(R.string.message_common_error),Toast.LENGTH_SHORT).show()
        }

        mActivity = activity as? PrincipalActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // link Actionbar control
        setHasOptionsMenu(true)
    }

    // When click in each option menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            //Back
            android.R.id.home -> {
                mActivity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Configuration default menu
    override fun onDestroy() {
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(false)
        super.onDestroy()
    }

}