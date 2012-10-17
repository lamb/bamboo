/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yonyou.bamboo.model;

import java.io.Serializable;

/**
 * bamboo AppConfiguration
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-16
 * @since 
 */
public class AppConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String KEY_APPTITLE = "appTitle";
	public static String KEY_APPHOST = "appHost";
	public static String KEY_ADMINEMAIL = "adminEmail";
	public static String KEY_APPOWNER = "appOwner";
	public static String KEY_year = "year";
	public static String KEY_staticresourceversion = "staticResourceVersion";
	public static String KEY_staticservepath = "staticServePath";
	public static String KEY_servepath = "servePath";
	
	private String appTitle;
	private String appHost;
	private String adminEmail;
	private String appOwner;
	public AppConfiguration() {
		super();
	}
	public String getAppTitle() {
		return appTitle;
	}
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	public String getAppHost() {
		return appHost;
	}
	public void setAppHost(String appHost) {
		this.appHost = appHost;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAppOwner() {
		return appOwner;
	}
	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}
}
