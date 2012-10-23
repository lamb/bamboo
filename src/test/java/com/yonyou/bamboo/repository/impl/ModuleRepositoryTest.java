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
package com.yonyou.bamboo.repository.impl;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.yonyou.bamboo.model.Module;

/**
 * bamboo ModuleRepositoryTest
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-23
 * @since 
 */
public class ModuleRepositoryTest {

	@Autowired private ModuleRepository moduleRepository;
	
	@Test public void testSave() {
		Module m = new Module();
		m.setName("xx模块");
		m.setProjectId(1l);
		m.setCreateBy(2l);
		m.setCreateDate(Calendar.getInstance().getTime());
		Long id = moduleRepository.save(m);
		Assert.notNull(id);
	}
	
	@Test public void testGet() {
		Module m = moduleRepository.get(1);
		Assert.notNull(m);
	}
	
	@Test public void testFindAll() {
		List<Module> list = moduleRepository.findAll();
		Assert.notEmpty(list);
	}
	
	@Test public void testFindByProject() {
		List<Module> list = moduleRepository.findByProject(1);
		Assert.notEmpty(list);
	}
	
	@Test public void testUpdate() {
		Module m = new Module();
		m.setName("xx模块");
		m.setProjectId(1l);
		m.setCreateBy(2l);
		m.setCreateDate(Calendar.getInstance().getTime());
		moduleRepository.update(m);
	}
	
	@Test public void testDelete() {
		Module m = new Module();
		moduleRepository.delete(m);
	}
	
	@Test public void testdeleteById() {
		moduleRepository.deleteById(1l);
	}
}
