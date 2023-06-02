package com.fengzhiwei.photo.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String message = "";

	/**
	 * 返回代码
	 */
	private Integer code = 0;

	/**
	 * 返回数据对象 data
	 */
	private T result;

	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public Result() {
	}

	public static<T> Result<T> OK() {
		return OK(null);
	}

	public static<T> Result<T> OK(T data) {
		return OK(2000, null, data);
	}

	public static<T> Result<T> OK(int code, String msg) {
		return OK(code, msg, null);
	}

	public static<T> Result<T> OK(int code, String msg, T data) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(code);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> error(String msg) {
		return error(5000, msg);
	}

	public static<T> Result<T> error(int code, String msg) {
		return error(code, msg, null);
	}

	public static<T> Result<T> error(int code, String msg, T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(false);
		r.setCode(code);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}
}