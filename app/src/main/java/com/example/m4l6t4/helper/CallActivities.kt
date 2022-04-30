package com.example.m4l6t4.helper



import android.content.Context
import android.content.Intent
import com.example.m4l6t4.Member
import com.example.m4l6t4.activity.ProfileActivity


class CallActivities {

    fun openProfileActivityWithData(context: Context, member: Member): Intent {
        val intent = Intent(context, ProfileActivity::class.java)
        intent.putExtra("member", member)
        return intent
    }

}