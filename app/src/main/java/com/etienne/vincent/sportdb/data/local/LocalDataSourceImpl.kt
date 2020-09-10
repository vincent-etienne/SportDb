package com.etienne.vincent.sportdb.data.local

import android.content.SharedPreferences
import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam


class LocalDataSourceImpl(private val sharedPref: SharedPreferences) : LocalDataSource{
    //there is no local on this project, but here I can add Database etc...
}