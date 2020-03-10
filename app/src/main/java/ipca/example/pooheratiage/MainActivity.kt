package ipca.example.pooheratiage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ipca.example.pooheratiage.entities.Boat
import ipca.example.pooheratiage.entities.Car
import ipca.example.pooheratiage.entities.Moto
import ipca.example.pooheratiage.entities.Vehicle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var vehicles : MutableList<Vehicle> = ArrayList<Vehicle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var car = Car("Citroen", "C3")
        var moto = Moto("Honda", "CBR600")
        var boat = Boat("Amel", "55", 4)
        var deltaWing = object : Vehicle("Delta", "Wing") {
            override fun acelerate() {
                speed = speed!! + 9.8F
            }

        }


        vehicles.add(car)
        vehicles.add(moto)
        vehicles.add(boat)
        vehicles.add(deltaWing)

        for ( index in  0..100){
            val v = object : Vehicle("V$index", "M$index") {
                override fun acelerate() {
                    speed = speed!! + 1.5F
                }
            }
            vehicles.add(v)
        }



        val vehicleAdapter = VehicleAdapter()
        listViewVehicles.adapter = vehicleAdapter

        floatingActionButtonAcelerate.setOnClickListener {
            acelerateAll()
            vehicleAdapter.notifyDataSetChanged()
        }

    }

    fun acelerateAll(){
        for ( v in vehicles ){
            v.acelerate()
        }
    }

    inner class VehicleAdapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = layoutInflater.inflate(R.layout.row_vehicle,parent,false)
            val textViewBrand = view.findViewById<TextView>(R.id.textViewBrand)
            val textViewModel = view.findViewById<TextView>(R.id.textViewModel)
            val textViewVelocity = view.findViewById<TextView>(R.id.textViewVelocity)

            textViewBrand.text = vehicles[position].brand
            textViewModel.text = vehicles[position].model
            textViewVelocity.text = "" + vehicles[position].speed

            view.setOnClickListener{

                val intent = Intent(this@MainActivity,DetailActivity::class.java)

                intent.putExtra("brand", vehicles[position].brand)
                intent.putExtra("model", vehicles[position].model)
                intent.putExtra("speed", vehicles[position].speed)
                if (vehicles[position] is Boat) {
                    intent.putExtra("sails_on", (vehicles[position] as Boat).sailsOn)
                }
                startActivity(intent)
            }
            return view
        }

        override fun getItem(position: Int): Any {
           return vehicles[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return vehicles.size
        }

    }


}
