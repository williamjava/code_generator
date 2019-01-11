package com.code.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author william
 * @email wuhoujian@126.com
 * @date 2019/1/11
 */
@RestControllerAdvice
public class CustomExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(CustomException.class)
	public Result handleRRException(CustomException e){
		Result r = new Result();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Result.error();
	}
}
