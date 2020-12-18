package com.wecompli.screeen.notifywho

import android.text.Html
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution
import com.wecompli.R

class NotifyWhoViewBind(
    val notifyWhoActivity: NotifyWhoActivity,
    val view: View
):DeviceResolution(notifyWhoActivity) {
    var tv_notifywho:TextView?=null
    var rl_back_notifywho:RelativeLayout?=null
    var tv_notifysubmit:TextView?=null
    var rv_notifywho:RecyclerView?=null
    var rl_noemail:RelativeLayout?=null
    var tv_noemail:TextView?=null
    var tv_note:TextView?=null
    init {
        tv_notifywho=view.findViewById(R.id.tv_fixfaulthader)
        rv_notifywho=view.findViewById(R.id.rv_notifywho)
        rl_back_notifywho=view.findViewById(R.id.rl_back_notifywho)
        rl_noemail=view.findViewById(R.id.rl_noemail);
        tv_noemail=view.findViewById(R.id.tv_noemail)
        tv_note=view.findViewById(R.id.tv_note)
        tv_notifysubmit=view.findViewById(R.id.tv_notifysubmit)
        tv_noemail!!.typeface=getwhitneybold(notifyWhoActivity)
        tv_note!!.typeface=getgothmlight(notifyWhoActivity)
        tv_notifywho!!.setTypeface(getbebas(notifyWhoActivity))
        tv_notifysubmit!!.setTypeface(getbebas(notifyWhoActivity))

        val text = "<font color=#FB0101>Note :</font> <font color=#000000> Please add notify who emails from your admin dashboard.</font>"
        tv_note!!.setText(Html.fromHtml(text))
    }
}