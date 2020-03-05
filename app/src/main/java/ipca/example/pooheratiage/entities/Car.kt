package ipca.example.pooheratiage.entities

//
// Created by lourencogomes on 2020-03-05.
//
class Car : Vehicle {

    var handBrake : Boolean
    var temperatureCabin :  Int
        get() = this.temperatureCabin
        private set(value){
            temperatureCabin = value
            if (temperatureCabin > 30) {
                temperatureCabin = 30
            }else if (temperatureCabin < 15) {
                temperatureCabin = 15
            }
        }


    constructor(brand:String, model:String) : super(brand, model) {
        handBrake = false
    }

}