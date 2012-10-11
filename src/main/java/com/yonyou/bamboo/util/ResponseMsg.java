/*
 * Copyright (c) 2012, small-weibo Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yonyou.bamboo.util;

/**
 * bamboo ResponseMsg
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-12
 * @since 
 */
public class ResponseMsg {
	private boolean result;
	private String msg;
	private String code;
	private Object data;
	
	public ResponseMsg success() {
		this.result = true;
		return this;
	}
	public ResponseMsg error() {
		this.result = false;
		return this;
	}
	public ResponseMsg success(String msg) {
		this.result = true;
		this.msg = msg;
		return this;
	}
	public ResponseMsg error(String msg) {
		this.result = false;
		this.msg = msg;
		return this;
	}
	public boolean isResult() {
		return result;
	}
	public ResponseMsg setResult(boolean result) {
		this.result = result;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public ResponseMsg setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getData() {
		return data;
	}
	public ResponseMsg setData(Object data) {
		this.data = data;
		return this;
	}
	public String getCode() {
		return code;
	}
	public ResponseMsg setCode(String code) {
		this.code = code;
		return this;
	}
}
