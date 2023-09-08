package com.zerobase.api.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {
    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "E001", errorMessage = "result not found"),
    DUPLICATED(HttpStatus.BAD_REQUEST, "E002", errorMessage = "duplicated"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "E003", errorMessage = "bad request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E004", errorMessage = "internal server error"),
}