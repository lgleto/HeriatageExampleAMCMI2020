package ipca.example.pooheratiage.entities

//
// Created by lourencogomes on 2020-03-05.
//
class Moto : Vehicle {

    var stand  : Boolean

    constructor(brand:String, model:String) : super(brand, model) {
        stand = false
    }

    override fun acelerate(){
        speed = speed!! + 20f
    }

}