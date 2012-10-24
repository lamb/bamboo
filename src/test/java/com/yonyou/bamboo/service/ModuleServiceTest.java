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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.bamboo.model.Module;

/**
 * bamboo ModuleServiceTest
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-23
 * @since 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bamboo-context.xml")
public class ModuleServiceTest {

	@Autowired private ModuleService moduleService;
	private long id;
	
	@Before public void setUp() {
		Module m = new Module();
		m.setName("xx模块");
		m.setProjectId(1l);
		m.setCreateBy(2l);
		m.setCreateDate(Calendar.getInstance().getTime());
		id = moduleService.save(m);
	}
	
	@Test @Rollback public void testSave() {
		Module m = new Module();
		m.setName("xx模块2");
		m.setProjectId(1l);
		m.setCreateBy(2l);
		m.setCreateDate(Calendar.getInstance().getTime());
		moduleService.save(m);
	}
	
	@Test public void testGet() {
		moduleService.get(id);
	}
	
	@Test public void testFindByProject() {
		moduleService.findByProject(1);
	}
	
	@Test public void testModify() {
		Module m = new Module();
		m.setId(id);
		m.setName("xx模块修改");
		m.setModifyBy(1l);
		moduleService.modify(m);
	}
	
	@Test public void testDelete() {
		moduleService.deleteById(id);
	}
}
