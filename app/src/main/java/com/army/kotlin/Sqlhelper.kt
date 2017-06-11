package com.army.kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Army on 2017/06/11.
 */
val database: Sqlhelper get() = Sqlhelper.getInstance()

class Sqlhelper(ctx: Context = MyApplication.getInstance(), name: String? = "data.db",
                factory: SQLiteDatabase.CursorFactory? = null, version: Int = 1) : ManagedSQLiteOpenHelper(ctx, name, factory, version) {

    companion object {
        @Volatile private var helper: Sqlhelper? = null

        fun getInstance(): Sqlhelper {
            if (helper == null) {
                synchronized(Sqlhelper::class) {
                    if (helper == null) {
                        helper = Sqlhelper()
                    }
                }
            }
            return helper!!
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Gps.TABLE_NAME, true)
        onCreate(db)
    }

    /**
     *     private long _id;
    private String systime;
    private long loctime;
    private double lon;
    private double lat;
    private String provider;
    private int accuracy;
    private double speed;
    private int bearing;

     */
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(Gps.TABLE_NAME, true,
                Gps._ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Gps.SYSTIME to TEXT,
                Gps.LOCTIME to INTEGER,
                Gps.LON to REAL,
                Gps.LAT to REAL,
                Gps.PROVIDER to TEXT,
                Gps.ACCURACY to REAL,
                Gps.SPEED to REAL,
                Gps.BEARING to REAL
        )
    }

    fun saveAll(list: List<Gps>) {
        use {
            transaction {
                list.forEach {
                    insert(Gps.TABLE_NAME,
                            Gps.SPEED to it.speed,
                            Gps.PROVIDER to it.provider,
                            Gps.LAT to it.lat,
                            Gps.ACCURACY to it.accuracy,
                            Gps.BEARING to it.bearing,
                            Gps.LOCTIME to it.loctime,
                            Gps.LON to it.lon,
                            Gps.SYSTIME to it.systime
                    )
                }

            }
        }
    }

    fun queryAll(): List<Gps> = use {
        select(Gps.TABLE_NAME).exec {
            parseList(classParser<Gps>())
        }
    }

    fun queryLng(id: Long): List<Double> = use {
        select(Gps.TABLE_NAME, Gps.LON).whereArgs("${Gps._ID} > {id}", "id" to id).exec {
            parseList(DoubleParser)
        }
    }

    fun deleteById(id: Long){
        use {
            delete(Gps.TABLE_NAME, "${Gps._ID} = {id}", "id" to id)
        }
    }

    fun updateById(id: Long){
        use {
            update(Gps.TABLE_NAME, Gps.PROVIDER to "baidu").whereArgs("${Gps._ID} = {id}", "id" to id).exec()
        }
    }
}