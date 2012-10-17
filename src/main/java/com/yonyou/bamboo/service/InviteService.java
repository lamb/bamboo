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
package com.yonyou.bamboo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.bamboo.repository.impl.InviteRepository;
import com.yonyou.bamboo.util.MailSender;

/**
 * bamboo InviteService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-14
 * @since 
 */
@Service
public class InviteService {

	private Logger log = Logger.getLogger(InviteService.class);
	
	@Autowired private InviteRepository inviteRepository;
	@Autowired private MailSender mailSender;
	
	@Transactional
	public void addInvite(final String email) {
		if(!inviteRepository.checkEmailValid(email)) {
			throw new RuntimeException("邮件已经注册过");// TODO 自定义异常
		}
		final String no = UUID.randomUUID().toString().replace("-", "");
		inviteRepository.save(email, no);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("url", "http://127.0.0.1:8080/bamboo/invite/"+no);
		mailSender.send(email, "bamboo 邀请注册", "mail/invite.html", model);
		log.info("邀请" + email);
	}
	
	public String findEmailByInviteNo(String inviteNo) {
		String email = inviteRepository.getEmail(inviteNo);
		if (email == null) {
			throw new RuntimeException("无效");
		}
		return email;
	}
}
