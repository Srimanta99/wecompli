package com.wecompli.screeen.home

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution
import com.wecompli.R
import de.hdodenhof.circleimageview.CircleImageView

class HomeViewBind:DeviceResolution {
    var img_menu:ImageView?=null
    var tv_header_text:TextView?=null
    var content_frame:FrameLayout?=null
    var cirecularimageview: CircleImageView?=null
    var tv_user_type:TextView?=null
    var tv_user_name:TextView?=null
    var tv_user_email:TextView?=null
    var rec_sidemenu:RecyclerView?=null
    var drawer_layout:DrawerLayout?=null
    var ll_logout:LinearLayout?=null
    var tv_lagout:TextView?=null

    constructor(homeActivity: HomeActivity, view: View):super(homeActivity){
        viewbinds(view)
        settypeface(homeActivity)

    }

    private fun settypeface(homeActivity: HomeActivity) {
        tv_header_text!!.typeface=getbebas(homeActivity)
        tv_user_type!!.typeface=getbebas(homeActivity)
        tv_user_name!!.typeface=getgothmlight(homeActivity)
        tv_user_email!!.typeface=getgothmlight(homeActivity)
        tv_lagout!!.typeface=getbebas(homeActivity)

    }

    private fun viewbinds(view: View) {
        img_menu=view.findViewById(R.id.img_menu)
        tv_header_text=view.findViewById(R.id.tv_header_text)
        cirecularimageview=view.findViewById(R.id.profile_image)
        tv_user_type=view.findViewById(R.id.tv_user_type)
        tv_user_name=view.findViewById(R.id.tv_user_name)
        tv_user_email=view.findViewById(R.id.tv_user_email)
        rec_sidemenu=view.findViewById(R.id.rec_sidemenu)
        drawer_layout=view.findViewById(R.id.drawer_layout)
        ll_logout=view.findViewById(R.id.ll_logout)
        tv_lagout=view.findViewById(R.id.tv_lagout)

    }
}