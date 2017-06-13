package com.army.kotlin

/**
 * Created by Army on 2017/06/11.
 */

class Gps(
        /**
         * systime : 2016-03-31 11:27:20
         * loctime : 1459394840666
         * lon : 116.302013
         * lat : 39.982823
         * provider : gps
         * accuracy : 0
         * speed : 5.099999904632568
         * bearing : 90
         */
        var _id: Long, var systime: String?, var loctime: Long, var lon: Double, var lat: Double, var provider: String?, var accuracy: Double, var speed: Double, var bearing: Double) {

    override fun toString(): String {
        return "Gps{" +
                "_id=" + _id +
                ", systime='" + systime + '\'' +
                ", loctime=" + loctime +
                ", lon=" + lon +
                ", lat=" + lat +
                ", provider='" + provider + '\'' +
                ", accuracy=" + accuracy +
                ", speed=" + speed +
                ", bearing=" + bearing +
                '}'
    }

    companion object {
        val TABLE_NAME = "GPS"
        val SYSTIME = "systime"
        val LOCTIME = "loctime"
        val LON = "lon"
        val LAT = "lat"
        val PROVIDER = "provider"
        val ACCURACY = "accuracy"
        val SPEED = "speed"
        val BEARING = "bearing"
        val _ID = "_id"
    }
}
