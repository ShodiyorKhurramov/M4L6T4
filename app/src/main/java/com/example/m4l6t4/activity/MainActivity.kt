package com.example.m4l6t4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m4l6t4.R


import android.content.Context
import android.content.Intent

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l6t4.Member
import com.example.m4l6t4.adapter.MainAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refleshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.rv_main_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refleshAdapter(members: List<Member>) {
        val adapter = MainAdapter(this, members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..15) members.add(Member(R.drawable.img_user, getString(R.string.shodiyor_xurramov), getString(R.string.shodiyor)))
        return members
    }

    fun openIntent(intent: Intent) {
        startActivity(intent)
    }

}