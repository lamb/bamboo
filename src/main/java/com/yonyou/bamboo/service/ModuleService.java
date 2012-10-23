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
package com.yonyou.bamboo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.bamboo.model.Module;
import com.yonyou.bamboo.repository.impl.ModuleRepository;

/**
 * bamboo ModuleService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-23
 * @since 
 */
@Service
public class ModuleService {

	@Autowired private ModuleRepository moduleRepository;
	
	public Long save(Module module) {
		return moduleRepository.save(module);
	}
	
	public Module get(Long id) {
		return moduleRepository.get(id);
	}
	
	public List<Module> findByProject(long projectId) {
		return moduleRepository.findByProject(projectId);
	}
	
	public void modify(Module module) {
		module.setModifyDate(Calendar.getInstance().getTime());
		moduleRepository.update(module);
	}
	
	public void deleteById(long id) {
		moduleRepository.deleteById(id);
	}
}
