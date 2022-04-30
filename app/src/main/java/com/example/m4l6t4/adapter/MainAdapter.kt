package com.example.m4l6t4.adapter



import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l6t4.Member
import com.example.m4l6t4.R
import com.example.m4l6t4.activity.MainActivity
import com.example.m4l6t4.helper.CallActivities

class MainAdapter(private val context: MainActivity, private val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = this.context.packageName

    private val intent = CallActivities()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item: LinearLayout = view.findViewById(R.id.ll_item)
        val userPhoto: ImageView = view.findViewById(R.id.iv_item_photo)
        val userFullName: TextView = view.findViewById(R.id.tv_item_name)
        val userUserName: TextView = view.findViewById(R.id.tv_item_job_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if (holder is ItemViewHolder) {
            holder.apply {
                userPhoto.setImageResource(member.image)
                userFullName.text = member.name
                userUserName.text = member.username
                item.setOnClickListener {
                    context.openIntent(intent.openProfileActivityWithData(context, member))
                }
            }
        }
    }



    override fun getItemCount(): Int {
        return members.size
    }
}