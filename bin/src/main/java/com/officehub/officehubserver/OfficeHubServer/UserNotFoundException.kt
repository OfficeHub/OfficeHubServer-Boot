package com.officehub.officehubserver.OfficeHubServer

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "user not found")
class UserNotFoundException : RuntimeException()