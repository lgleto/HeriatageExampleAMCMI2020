package ipca.example.pooheratiage

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*



//
// Created by lourencogomes on 2020-03-10.
//
class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle =  intent.extras
        bundle?.let {
            textViewDetailBrand.text = it.getString("brand")
            textViewDetailModel.text = it.getString("model")
            textViewDetailVelocity.text = "" + it.getFloat("speed")
            textViewDetailSailsOn.text = "" + it.getInt("sails_on")
        }
    }
}