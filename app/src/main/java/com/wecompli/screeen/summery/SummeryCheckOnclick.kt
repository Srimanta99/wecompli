package com.wecompli.screeen.summery

import android.app.Activity
import android.content.Intent
import android.view.View
import com.wecompli.R
import com.wecompli.screeen.totalfault.TotalFaultActivity
import com.wecompli.utils.customEditChecksummery.CustomEditCheckSummeryDialog

class SummeryCheckOnclick : View.OnClickListener{
    var checkSummeryActivity: Activity?=null
   public var checkSummeryViewBind: SummerryViewBind?=null
    var  checkSummeryFragment: CheckSummeryFragment?=null
    override fun onClick(p0: View?) {
        when(p0!!.id){
            /*R.id.img_back->{
                // val homeActivity=
               // checkSummeryActivity!!.finish()
            }*/
            R.id.btnedit->{
               var customEditCheckSummeryDialog= CustomEditCheckSummeryDialog(checkSummeryActivity,checkSummeryFragment!!.userData,this,checkSummeryViewBind!!.tvsiteName!!.text.toString(),checkSummeryViewBind!!.tvsiteName!!,checkSummeryViewBind!!.tvdateval!!,checkSummeryViewBind!!.tvdateval!!.text.toString());
                 customEditCheckSummeryDialog.show()
            }
            R.id.tv_total_fault_count->{
                val intent= Intent(checkSummeryActivity, TotalFaultActivity::class.java)
                //val selectedSiteSessionForCheck= SelectedSiteSessionForCheck(checkSummeryActivity!!.userData!!.company_id,checkSummeryActivity!!.sideid.toString(),checkSummeryActivity!!.checkcomponent.toString(),checkSummeryActivity!!.listvalue!!.get(position).categoryName,listvalue!!.get(position).id,checkdate!!)
                // intent.putExtra(ApplicationConstant.INTENT_COMPONENETDETAILS,selectedSiteSessionForCheck as Serializable)
                intent.putExtra("componet",checkSummeryFragment!!.componet)
                intent.putExtra("date",checkSummeryFragment!!.date)
                intent.putExtra("sideid",checkSummeryFragment!!.sideid)
                intent.putExtra("companyid",checkSummeryFragment!!.userData!!.company_id)
                // intent.putExtra("cat_id",checkSummeryActivity!!.userData!!.company_id)
                checkSummeryActivity!!.startActivity(intent)
                //  Toast.makeText(checkSummeryActivity,"Under Development",Toast.LENGTH_LONG).show()
            }


        }
    }

    constructor(
        checkSummeryActivity: Activity,
        checkSummeryViewBind: SummerryViewBind,
        checkSummeryFragment: CheckSummeryFragment){
        this.checkSummeryActivity=checkSummeryActivity;
        this.checkSummeryViewBind=checkSummeryViewBind
        this.checkSummeryFragment=checkSummeryFragment
        setonclicklistner()
    }

    private fun setonclicklistner() {
        //checkSummeryViewBind!!.img_back!!.setOnClickListener(this)
        checkSummeryViewBind!!.tv_total_fault_count!!.setOnClickListener(this)
        checkSummeryViewBind!!.btnedit!!.setOnClickListener(this)
    }
}