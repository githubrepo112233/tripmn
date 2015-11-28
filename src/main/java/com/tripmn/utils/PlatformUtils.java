package com.tripmn.utils;

import java.util.Date;

import com.tripmn.dto.BaseResponse;
import com.tripmn.enums.PlatformErrorInterface;

public class PlatformUtils {

	public static void addError(BaseResponse response,
			PlatformErrorInterface error) {
		response.setErrorCode(error.getCode());
		response.setErrorDescription(error.getDescription());
	}

	public static void addError(BaseResponse response, int code,
			String description) {
		response.setErrorCode(code);
		response.setErrorDescription(description);
	}

	public static boolean isSuccess(BaseResponse response) {
		if (response != null && response.getErrorCode() != 0) {
			return false;
		}
		return true;
	}
	
	public static void addError(BaseResponse response,
			BaseResponse sourceResponse) {
		response.setErrorCode(sourceResponse.getErrorCode());
		response.setErrorDescription(sourceResponse.getErrorDescription());
	}
	
	public static long dateDiffSeconds(Date startDate, Date endDate){
		return (endDate.getTime() - startDate.getTime()) / 1000;
	}
}