package com.officehub.officehubserver.OfficeHubServer.utils;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiError;
import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;

public class ApiUtils {
    public static <T>ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(String message, int status) {
        return new ApiResult<>(false, null, new ApiError(message, status));
    }
}
