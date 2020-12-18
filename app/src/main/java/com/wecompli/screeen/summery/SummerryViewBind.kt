package com.wecompli.screeen.summery

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution
import com.wecompli.R
import com.wecompli.screeen.checksummery.CheckSummeryActivity
import com.wecompli.screeen.home.HomeActivity

class SummerryViewBind(val homeactivity: HomeActivity, val view: View) {

    var img_back: ImageView?=null
    var tv_checksummery: TextView?=null
    var tv_select_check: TextView?=null
    var recview_check_list: RecyclerView?=null
    var tv_total_fault_count: TextView?=null
    var checkSummeryActivity: CheckSummeryActivity?=null
    var deviceResolution:DeviceResolution?=null
    var tvComayselected: TextView?=null
    var tvComayName: TextView?=null
    var tvsiteselected: TextView?=null
    var tvsiteName: TextView?=null
    var tvdate: TextView?=null
    var tvdateval: TextView?=null
    var btnedit:Button?=null
    var tv_total_fault:TextView?=null

    init {

        img_back=view!!.findViewById(R.id.img_back)
        tv_checksummery=view!!.findViewById(R.id.tv_checksummery)
        tv_select_check=view!!.findViewById(R.id.tv_select_check)
        recview_check_list=view!!.findViewById(R.id.recview_check_list)
        tv_total_fault_count=view!!.findViewById(R.id.tv_total_fault_count)
        btnedit=view!!.findViewById(R.id.btnedit)
        tvComayselected=view!!.findViewById(R.id.tvComayselected)
        tvComayName=view!!.findViewById(R.id.tvComayName)
        tvsiteselected=view!!.findViewById(R.id.tvsiteselected)
        tvsiteName=view!!.findViewById(R.id.tvsiteName)
        tvdate=view!!.findViewById(R.id.tvdate)
        tvdateval=view!!.findViewById(R.id.tvdateval)
        deviceResolution= DeviceResolution(homeactivity)
        tv_total_fault=view.findViewById(R.id.tv_total_fault)
        settypeface()
    }

    private fun settypeface() {
      //  tv_checksummery!!.typeface=getgothmlight(checkSummeryActivity)
       // tv_select_check!!.typeface=getgothmXlight(checkSummeryActivity)
        tvComayselected!!.typeface=deviceResolution!!.getwhitneybook(homeactivity)
        tvComayName!!.typeface=deviceResolution!!.getwhitneysemibold(homeactivity)
        tvsiteselected!!.typeface=deviceResolution!!.getwhitneybook(homeactivity)
        tvsiteName!!.typeface=deviceResolution!!.getwhitneysemibold(homeactivity)
        tvdate!!.typeface=deviceResolution!!.getwhitneybook(homeactivity)
        tvdateval!!.typeface=deviceResolution!!.getwhitneysemibold(homeactivity)
        tv_total_fault!!.typeface=deviceResolution!!.getwhitneybook(homeactivity)
        tv_total_fault_count!!.typeface=deviceResolution!!.getwhitneysemibold(homeactivity)



    }
}