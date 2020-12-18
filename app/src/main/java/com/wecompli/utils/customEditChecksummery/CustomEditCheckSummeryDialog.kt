package com.wecompli.utils.customEditChecksummery

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.wecompli.R
import com.wecompli.apiresponsemodel.home.LoginUserDetailsModel
import com.wecompli.apiresponsemodel.login.SiteList
import com.wecompli.screeen.summery.SummeryCheckOnclick
import com.wecompli.utils.customalert.Alert
import com.wecompli.utils.custompopupdialogforsite.CustomEditStartCheckDialogSiteList
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent
import java.text.SimpleDateFormat
import java.util.*

class CustomEditCheckSummeryDialog(
    val checkSummeryActivity: Activity?,
    val userData: LoginUserDetailsModel?,
    val summeryCheckOnclick: SummeryCheckOnclick,
    val sidename: String,
    val tvsiteName: TextView,
    val tvdateval: TextView,
    val date:String
) : Dialog(checkSummeryActivity!!) {
    var tv_Selected_company:TextView?=null
    var formattedDate:String?=null
    var tv_check_date:TextView?=null
    var tv_select_site:TextView?=null
    var site_list:List<SiteList>? = null
    var btn_submit:Button?=null
   // public  var userData:LoginUserDetailsModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCanceledOnTouchOutside(true)
        setContentView(R.layout.custom_edit_check_layout)

       getWindow()!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv_Selected_company=findViewById(R.id.tv_Selected_company)
        tv_check_date=findViewById(R.id.tv_check_date)
        tv_select_site=findViewById(R.id.tv_select_site);
        btn_submit=findViewById(R.id.btn_submit)
        tv_Selected_company!!.text=AppSheardPreference(checkSummeryActivity!!).getvalue_in_preference(PreferenceConstent.UserCompany)
        val c = Calendar.getInstance()
        val df = SimpleDateFormat("dd/MM/yyyy")
        formattedDate = df.format(c.time)
        tv_check_date!!.setText(date)
        // summeryCheckOnclick.checkSummeryFragment!!.date=formattedDate!!
         tv_select_site!!.setText(sidename)

        tv_select_site!!.setOnClickListener {
        var customEditStartCheckDialogSiteList=   CustomEditStartCheckDialogSiteList(checkSummeryActivity,summeryCheckOnclick,userData!!.site_list,tv_select_site!!);
            customEditStartCheckDialogSiteList.show()
        }
        tv_check_date!!.setOnClickListener(View.OnClickListener {
            datepickerdefault()
        })
        btn_submit!!.setOnClickListener {
            if (!tv_select_site!!.getText().toString().equals("")) {
               //summeryCheckOnclick.checkSummeryFragment!!.summerryViewBind.tvsiteName.setText()
                tvsiteName.setText(tv_select_site!!.getText().toString())
                tvdateval.setText(tv_check_date!!.text.toString())
                summeryCheckOnclick.checkSummeryFragment!!.callApiforchecksummery()
                dismiss()
            } else
                Alert.showalert(checkSummeryActivity!!, checkSummeryActivity!!.getResources().getString(R.string.select_site_))
        }
    }


    fun datepickerdefault() {
        val c = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(checkSummeryActivity!!, R.style.DialogThemedatepicker,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val choosedate = padnumber(dayOfMonth) + "/" + padnumber(monthOfYear + 1) + "/" + year.toString()
                val checkdate = year.toString() + "-" + padnumber(monthOfYear + 1) + "-" + padnumber(dayOfMonth)
                val listcheckdate = padnumber(monthOfYear + 1) + "/" + padnumber(dayOfMonth) + "/" + year.toString()
                tv_check_date!!.setText(choosedate)
                summeryCheckOnclick.checkSummeryFragment!!.date=choosedate
                // formattedDate = choosedate
                //  foramttedmonthyear = padnumber(monthOfYear + 1) + "/" + year.toString()
                //  formattedyear = year.toString()
                //  appSheardPreference.setvalue_in_preference(PreferenceConstent.search_date, formattedDate)
                //  appSheardPreference.setvalue_in_preference(PreferenceConstent.check_date, checkdate)
                // appSheardPreference.setvalue_in_preference(PreferenceConstent.checked_list_date, listcheckdate)

            }, mYear, mMonth, mDay
        )
        //  datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show()

    }

    fun padnumber(n: Int): String {
        val num: String
        if (n > 10 || n == 10)
            num = n.toString()
        else
            num = "0$n"
        return num
    }
}