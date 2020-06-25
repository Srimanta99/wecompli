package com.wecompli.network

class NetworkUtility {
    companion object{
        val BASE_URL = "http://rest.wecompli.io/api/mobile/"
        const val  LOG_IN = "user/login"
        const val TODAYSEASON="today/season/list"
        const val REGENERATE_TOKEN="token/genarate"
        const val COMPONENTCHECKLIST="category/list"
        const val COMPONENT_CHECK_ELEMENTDE_DETAILS="checks/list"
        const val COMPONENET_CHECK_SUBMIT="checking/process"
        const val FAULT_LIST="checks/fault/list"
        const val FAULTCREATE="checks/fault/create"
        const val FAULTDETAILS="checks/fault/details"
        const val FAULSTATUSLIST="fault/status/list"
        const val FAULTSTATUSMESSAGE_CHANGE="checks/fault/status/change"
        const val FAULTREPAIR="fault/repair"



    }
}