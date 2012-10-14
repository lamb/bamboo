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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yonyou.bamboo.model.User;
import com.yonyou.bamboo.service.InviteService;
import com.yonyou.bamboo.service.UserService;

/**
 * bamboo UserController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-9
 * @since 
 */

@Controller @RequestMapping("/u")
public class UserController {

	@Autowired private UserService userService;
	@Autowired private InviteService inviteService;
	/**
	 * 提交注册
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView regist(User user) {
		
		return null;
	}
	/**
	 * 提交邀请注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	public ModelAndView inviteRegist(User user, @RequestParam("inviteNo") String inviteNo) {
		user.setEmail(inviteService.findEmailByInviteNo(inviteNo));
		userService.saveUser(user);
		return new ModelAndView("message");
	}
	
}
