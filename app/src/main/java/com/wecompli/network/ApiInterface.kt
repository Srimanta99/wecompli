package com.wecompli.network

import com.google.gson.JsonObject
import com.wecompli.apiresponsemodel.checkelementdetails.CheckElementDetailsResponse
import com.wecompli.apiresponsemodel.checksubmitresponse.Checksubmitresponse
import com.wecompli.apiresponsemodel.checksummery.CheckSummeryResponse
import com.wecompli.apiresponsemodel.faultapi.FaultApiResponse
import com.wecompli.apiresponsemodel.faultdetails.FaultDetailsByScanModel
import com.wecompli.apiresponsemodel.faultdetails.FaultadetailsModel
import com.wecompli.apiresponsemodel.faultstatuslist.FaultStatusListModel
import com.wecompli.apiresponsemodel.faultstatusmessagechange.FaultStatusMessageChange
import com.wecompli.apiresponsemodel.login.LoginResponse
import com.wecompli.apiresponsemodel.regeratetokenresponse.RegenerateTokenResponse
import com.wecompli.apiresponsemodel.seasonlist.SeasonListApiresponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


   // @Headers("Content-Type: application/json")
    /*@POST(NetworkUtility.LOG_IN)
    fun callLogInApi(@Field("user_email") email:String,
                     @Field("password") pass:String,
                     @Field("identification_id_token") identification_id_token:String,
                     @Field("device_model") device_model:String,
                     @Field("device_os") device_os:String): Call<LoginResponse>
*/

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.LOG_IN)
    fun callLogInApi(@Body body: JsonObject): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.TODAYSEASON)
    fun calltodayseason(@Header("Authorization") token:String,@Body body: JsonObject): Call<SeasonListApiresponse>

   @Headers("Content-Type: application/json")
   @POST(NetworkUtility.REGENERATE_TOKEN)
   fun regeratetoken(@Body body: JsonObject) : Call<RegenerateTokenResponse>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.COMPONENTCHECKLIST)
    fun callcomponetChecklist(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<CheckSummeryResponse>


    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.COMPONENT_CHECK_ELEMENTDE_DETAILS)
    fun callcomponetChecklelementdetails(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<CheckElementDetailsResponse>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.COMPONENET_CHECK_SUBMIT)
    fun callcomponetCheckSubmit(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULT_LIST)
    fun callApiforfaultlist(@Header("Content-Type") contenttype:String, @Header("Authorization") token:String, @Header("site_id") site_id:String, @Body body: JsonObject): Call<FaultApiResponse>


    @Multipart
    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.COMPONENET_CHECK_SUBMIT)
    fun callApifaultsubmitusingImsage(@Header("Authorization") token:String,
                                      @Header("site_id") site_id:String,
                                      @Part("check_id") check_id:RequestBody,
                                      @Part("season_id") season_id:RequestBody,
                                      @Part("check_type_id") check_type_id:RequestBody,
                                      @Part("check_type_values_id") check_type_values_id:RequestBody,
                                      @Part("check_process_type") check_process_type:RequestBody,
                                      @Part("check_date") check_date:RequestBody,
                                      @Part("process_remark") process_remark:RequestBody,
                                      @Part("process_status") process_status:RequestBody,
                                      @Part process_file: MultipartBody.Part):Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULTCREATE)
    fun callcreatefaultApi(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULTDETAILS)
    fun callfaultdetailsapi(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<FaultadetailsModel>

    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULSTATUSLIST)
    fun callfaultstatuslist(@Header("Authorization") token:String,@Header("site_id") site_id:String): Call<FaultStatusListModel>


    @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULTSTATUSMESSAGE_CHANGE)
    fun callfaultstatusmessagechange(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<FaultStatusMessageChange>

   // @Headers("Content-Type: application/json")
    @POST(NetworkUtility.FAULTBYSCAN)
    fun callfaultdetailsbyscan(@Header("Authorization") token:String,@Header("site_id") site_id:String, @Body body: JsonObject): Call<FaultDetailsByScanModel>


}