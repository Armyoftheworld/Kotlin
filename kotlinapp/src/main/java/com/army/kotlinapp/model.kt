package com.army.kotlinapp

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Army on 2017/06/15.
 */

const val BASE_URL = "https://api.github.com/"

data class User(@SerializedName("login") var name: String, var avatar_url: String, var html_url: String,
                var score: Double, var repos_url: String) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readDouble(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(avatar_url)
        dest.writeString(html_url)
        dest.writeDouble(score)
        dest.writeString(repos_url)
    }
}

data class Users(var items: List<User>)

data class Repo(@SerializedName("full_name") var name: String,
                var description: String,
                @SerializedName("stargazers_count") var stargazers: Int)