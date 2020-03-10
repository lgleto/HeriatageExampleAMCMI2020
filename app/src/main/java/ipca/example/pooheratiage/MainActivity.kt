package ipca.example.pooheratiage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ipca.example.pooheratiage.entities.Boat
import ipca.example.pooheratiage.entities.Car
import ipca.example.pooheratiage.entities.Moto
import ipca.example.pooheratiage.entities.Vehicle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        var vehicles : List<Vehicle> = arrayListOf(car, moto,boat,deltaWing)

        buttonAcelerate.setOnClickListener {
            for ( v in vehicles ){
                v.acelerate()
            }
            for ( v in vehicles ){
                textViewLog.text = textViewLog.text.toString()+"\n" +
                                    v.modelAndBrand()+" "+v.speed
                if (v is Boat){
                    textViewLog.text = textViewLog.text.toString() +"\n"+
                            "Active Sails "+v.sailsOn

                    (v as Boat).sailsOn
                }
            }
        }

    }
}
