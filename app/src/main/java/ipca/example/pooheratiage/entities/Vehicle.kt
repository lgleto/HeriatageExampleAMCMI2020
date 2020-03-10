package ipca.example.pooheratiage.entities

//
// Created by lourencogomes on 2020-03-05.
//
abstract class Vehicle  {

    var brand : String = ""
    var model : String = String()
    var speed : Float? = null

    constructor(brand:String, model:String){
        this.brand = brand
        this.model =  model
        speed = 0f
    }

    abstract fun acelerate()

    fun modelAndBrand():String{
        var nb = model + " " + brand
        return nb
    }

}