package com.etienne.vincent.sportdb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}