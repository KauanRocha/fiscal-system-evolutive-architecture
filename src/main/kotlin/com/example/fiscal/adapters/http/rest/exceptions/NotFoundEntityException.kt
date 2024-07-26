package com.example.fiscal.adapters.http.rest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundEntityException(message: String) : RuntimeException(message)