package com.wecompli.screeen.checktaptosign

import android.Manifest
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.core.app.ActivityCompat
import com.wecompli.R
import com.wecompli.utils.ApplicationConstant
import com.wecompli.utils.customalert.Alert
import com.wecompli.utils.customalert.TapToSignDialog

class CheckTaptoSignOnClick(
    val checkTapToSignActivity: CheckTapToSignActivity,
    val tapToSignViewBind: CheckTapToSignViewBind) : View.OnClickListener {
    init {
        tapToSignViewBind.btn_submit_input!!.setOnClickListener(this)
        tapToSignViewBind.tv_tap_to_sign!!.setOnClickListener(this)
        tapToSignViewBind.img_sign!!.setOnClickListener(this)
        tapToSignViewBind.rl_back_temptails!!.setOnClickListener(this)

    }
    override fun onClick(p0: View?) {
      when(p0!!.id){
          R.id.tv_tap_to_sign->{
              TapToSignDialog(checkTapToSignActivity).show()
          }
          R.id.btn_submit_input->{
              if (!tapToSignViewBind.et_input!!.text.toString().equals("")) {
                  if (checkTapToSignActivity.imagesignAvaliable!!)
                      checkTapToSignActivity.taptosign()
                  else
                      Alert.showalert(checkTapToSignActivity!!,checkTapToSignActivity.getString(R.string.signinhere))

              }else
                  Alert.showalert(checkTapToSignActivity!!,checkTapToSignActivity.getString(R.string.enter_patient_name))
          }
          R.id.img_sign->{

              if (Build.VERSION.SDK_INT >= 23) {
                  if (checkTapToSignActivity.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) === android.content.pm.PackageManager.PERMISSION_GRANTED) {
                      //  Toast.makeText(this@CheckTapToSignActivity, "Permission grand.", Toast.LENGTH_LONG).show()
                      TapToSignDialog(checkTapToSignActivity).show()
                  } else {
                      // Log.v(TAG,"Permission is revoked2");
                      //Toast.makeText(this@CheckTapToSignActivity, "Permission not grand.", Toast.LENGTH_LONG).show()
                      ActivityCompat.requestPermissions(checkTapToSignActivity, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE), 3)

                  }
              } else { //permission is automatically granted on sdk<23 upon installation
                  //Log.v(TAG,"Permission is granted2");
                  TapToSignDialog(checkTapToSignActivity).show()

              }

          }
          R.id.rl_back_temptails->{

              checkTapToSignActivity.finish()
          }


      }

    }
}