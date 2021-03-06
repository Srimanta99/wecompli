package com.wecompli.screeen.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.Gravity
import android.view.View
import androidx.core.view.GravityCompat
import com.wecompli.R
import com.wecompli.screeen.accidentreport.AccidentReportActivity
import com.wecompli.screeen.adhocfault.AdHocFaultActivity
import com.wecompli.screeen.docmanagment.DocManagmentActivity
import com.wecompli.screeen.fixfault.FixFaultActivity
import com.wecompli.screeen.login.LoginActivity
import com.wecompli.utils.customalert.Alert
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent
import kotlinx.android.synthetic.main.home_header.view.*

class HomeOnClick: View.OnClickListener {
    var homeViewBind: HomeViewBind?=null
    var homeActivity:HomeActivity?=null
    constructor(homeActivity: HomeActivity, homeViewBind: HomeViewBind){
        this.homeViewBind=homeViewBind
        this.homeActivity=homeActivity
        setonclick(homeViewBind)
    }

    private fun setonclick(homeViewBind: HomeViewBind) {
        homeViewBind.img_menu!!.setOnClickListener(this)
        homeViewBind.ll_logout!!.setOnClickListener(this)
        homeViewBind.ll_repair!!.setOnClickListener(this)
        homeViewBind.ll_startcheck!!.setOnClickListener(this)
        homeViewBind.ll_incidenreport!!.setOnClickListener(this)
        homeViewBind.ll_docmangment!!.setOnClickListener(this)
        homeViewBind.ll_adhocfault!!.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.img_menu->{
                homeViewBind!!.drawer_layout!!.openDrawer(Gravity.LEFT)
            }
            R.id.ll_startcheck->{
                homeActivity!!.showStartCheckFragment()
            }
            R.id.ll_adhocfault->{
                if (homeViewBind!!.drawer_layout!!.isDrawerOpen(GravityCompat.START))
                    homeViewBind!!.drawer_layout!!.closeDrawer(Gravity.LEFT)
                if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserCompany).equals("")){
                    if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserSite).equals("")){
                        val docManagmentActivity=Intent(homeActivity!!, AdHocFaultActivity::class.java)
                        homeActivity!!.startActivity(docManagmentActivity)
                    }else
                        Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_site_))
                }else
                    Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_company))
            }
            R.id.ll_docmangment->{
                if (homeViewBind!!.drawer_layout!!.isDrawerOpen(GravityCompat.START))
                    homeViewBind!!.drawer_layout!!.closeDrawer(Gravity.LEFT)
                if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserCompany).equals("")){
                    if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserSite).equals("")){
                        val docManagmentActivity=Intent(homeActivity!!,DocManagmentActivity::class.java)
                        homeActivity!!.startActivity(docManagmentActivity)
                    }else
                        Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_site_))
                }else
                    Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_company))
            }
            R.id.ll_incidenreport->{
                if (homeViewBind!!.drawer_layout!!.isDrawerOpen(GravityCompat.START))
                    homeViewBind!!.drawer_layout!!.closeDrawer(Gravity.LEFT)
                if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserCompany).equals("")){
                    if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserSite).equals("")){

                        val accidentReportActivity=Intent(homeActivity!!,AccidentReportActivity::class.java)
                        homeActivity!!.startActivity(accidentReportActivity)
                    }else
                        Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_site_))
                }else
                    Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_company))

            }
            R.id.ll_logout->{
            // showalertforlogout()
                Alert.showyesnoalert(homeActivity!!,homeActivity!!.getResources().getString(R.string.sureto_logout))
            }
            R.id.ll_repair->{
                if (homeViewBind!!.drawer_layout!!.isDrawerOpen(GravityCompat.START))
                    homeViewBind!!.drawer_layout!!.closeDrawer(Gravity.LEFT)
                if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserCompany).equals("")){
                    if (!AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.UserSite).equals("")){
                        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.Category_name,"")
                        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.CheckName,"")
                        val fixFaultActivity=Intent(homeActivity!!,FixFaultActivity::class.java)
                        fixFaultActivity.putExtra(PreferenceConstent.FaultType,"normal")
                        homeActivity!!.startActivity(fixFaultActivity)
                    }else
                        Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_site_))
                }else
                    Alert.showalert(homeActivity!!,homeActivity!!.getString(R.string.select_company))

            }


        }

    }

    private fun showalertforlogout() {
        val builder = AlertDialog.Builder(homeActivity)
        builder.setTitle(homeActivity!!.getResources().getString(R.string.app_name))
        builder.setMessage(homeActivity!!.getResources().getString(R.string.sureto_logout))
        builder.setPositiveButton(homeActivity!!.getResources().getString(R.string.yes),
            DialogInterface.OnClickListener { dialog, which ->
                // Code that is executed when clicking YES
                dialog.dismiss()
                val uname = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.username_key)
                val pass = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.password_key)
                val ischeck =AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.iS_Checked_login)
                var laaguage = "en"

                if (AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage) == null || AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage).equals(""))
                    laaguage = "en"
                else
                    laaguage = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage)

                AppSheardPreference(homeActivity!!).clerpreference()
                AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.showintropage, "1")
                AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.username_key, uname)
                AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.password_key, pass)
                AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.iS_Checked_login,ischeck)
                AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.selectedlanagage, laaguage)
                val login = Intent(homeActivity, LoginActivity::class.java)
                login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                homeActivity!!.startActivity(login)
                homeActivity!!.finish()
            })

        builder.setNegativeButton(homeActivity!!.getResources().getString(R.string.no),
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        val alert = builder.create()
        alert.show()

    }

    public fun logoutyes(){
        val uname = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.username_key)
        val pass = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.password_key)
        val ischeck =AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.iS_Checked_login)
        var laaguage = "en"

        if (AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage) == null || AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage).equals(""))
            laaguage = "en"
        else
            laaguage = AppSheardPreference(homeActivity!!).getvalue_in_preference(PreferenceConstent.selectedlanagage)

        AppSheardPreference(homeActivity!!).clerpreference()
        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.showintropage, "1")
        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.username_key, uname)
        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.password_key, pass)
        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.iS_Checked_login,ischeck)
        AppSheardPreference(homeActivity!!).setvalue_in_preference(PreferenceConstent.selectedlanagage, laaguage)
        val login = Intent(homeActivity, LoginActivity::class.java)
        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        homeActivity!!.startActivity(login)
        homeActivity!!.finish()
    }
}