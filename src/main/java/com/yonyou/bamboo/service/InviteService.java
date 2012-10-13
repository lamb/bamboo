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

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.yonyou.bamboo.repository.impl.InviteRepository;

/**
 * bamboo InviteService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-14
 * @since 
 */
@Service
public class InviteService {

	@Autowired private InviteRepository inviteRepository;
	@Autowired private JavaMailSender mailSender;
	@Autowired private FreeMarkerConfigurer freemarkerConfig;
	
	public void invite(final String email) {
		if(inviteRepository.checkEmailValid(email)) {
			throw new RuntimeException("");// TODO 自定义异常
		}
		String no = UUID.randomUUID().toString();
		inviteRepository.save(email, no);
		// TODO send email
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(email);
				message.setFrom("admin@noday.net");
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("url", "");
				message.setText(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getConfiguration().getTemplate("template"), model), true);
			}
		});
	}
}
