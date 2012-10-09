/*
 * Copyright (c) 2012, *** Team
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
package com.yonyou.bamboo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * bamboo InviteController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-9
 * @since 
 */
@Controller @RequestMapping("/invite")
public class InviteController {

	/**
	 * 邀请页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String invite() {
		
		return null;
	}
	/**
	 * 发出邀请
	 * @param email
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView invite(@RequestParam("email") String email) {
		
		return null;
	}
	/**
	 * 接受邀请并去注册页面
	 * @param inviteNo
	 * @param m
	 * @return
	 */
	@RequestMapping("/{inviteNo}")
	public ModelAndView register(@PathVariable("inviteNo") String inviteNo, ModelAndView m) {
		// TODO 验证邀请码并找到email放到页面里
		m.addObject("inviteNo", inviteNo);
		m.addObject("email", "at1943@gmail.com");
		m.setViewName("inviteRegist");
		return m;
	}
}
