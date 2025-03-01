package com.yooshyasha.mvpbussinescrm.dto.controller

data class ResponseLogin (
    var success: Boolean = true,
    var status: Int = 200,
    var message: String = "",
    var username: String,
    var jwtToken: String,
)