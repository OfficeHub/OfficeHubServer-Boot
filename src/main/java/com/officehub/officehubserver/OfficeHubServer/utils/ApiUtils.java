package com.officehub.officehubserver.OfficeHubServer.utils;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiError;
import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;

public class ApiUtils {
    public static <T>ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static <T extends RuntimeException>ApiResult<?> error(T exceptionType, int status) {
        return new ApiResult<>(false, null, new ApiError<>(exceptionType, exceptionType.getMessage(), status));
    }
}
