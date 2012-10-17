package com.yonyou.bamboo.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class AppStartListener implements ApplicationListener<AppStartEvent> {

	private static Logger log = Logger.getLogger(AppStartListener.class);
	@Override
	public void onApplicationEvent(AppStartEvent event) {
		log.info("spring event:" + event);
	}

}
