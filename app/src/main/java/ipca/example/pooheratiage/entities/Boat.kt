package ipca.example.pooheratiage.entities

//
// Created by lourencogomes on 2020-03-05.
//
class Boat : Vehicle {

    var sailsNumber = 0
    var sailsOn = 0

    constructor(brand:String, model:String, sailsNumber: Int) : super(brand, model) {
        this.sailsNumber = sailsNumber

    }

    override fun acelerate(){
        sailsOn++
        if (sailsOn >= sailsNumber) sailsOn = sailsNumber
        speed = speed!! + 5f*sailsOn
    }



}