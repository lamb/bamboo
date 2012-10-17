package com.yonyou.bamboo.listener;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yonyou.bamboo.model.AppConfiguration;
import com.yonyou.bamboo.repository.IAppRepository;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
public class StartupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(StartupListener.class);
	
	private ServletContext context;
	private ApplicationContext ctx;
    /**
     * Default constructor. 
     */
    public StartupListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context = sce.getServletContext());
    	log.info("get spring ApplicationContext");
    	setAppProperty();
    	setSysProperty();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    private void setAppProperty() {
    	IAppRepository configRepo = ctx.getBean(IAppRepository.class);
    	AppConfiguration config = configRepo.getConfig();
    	if (config != null) {
    		setAttribute(AppConfiguration.KEY_APPTITLE, config.getAppTitle());
    		setAttribute(AppConfiguration.KEY_APPHOST, config.getAppHost());
    		setAttribute(AppConfiguration.KEY_ADMINEMAIL, config.getAdminEmail());
    		setAttribute(AppConfiguration.KEY_APPOWNER, config.getAppOwner());
        	setAttribute(AppConfiguration.KEY_staticresourceversion, Calendar.getInstance().toString());
        	Resource r = new ClassPathResource("web.properties");
        	Properties p = new Properties();
        	try {
				p.load(r.getInputStream());
				setAttribute(AppConfiguration.KEY_staticservepath, p.get(AppConfiguration.KEY_staticservepath));
				setAttribute(AppConfiguration.KEY_servepath, p.get(AppConfiguration.KEY_servepath));
			} catch (IOException e) {
				log.error("配置读取失败", e);
				// TODO 应该启动失败才行
			}
		}
    }
    
    private void setSysProperty() {
    	setAttribute(AppConfiguration.KEY_year, Calendar.getInstance().toString());
    }
    private void setAttribute(String key, Object value) {
    	context.setAttribute(key, value);
    	log.info("ServletContext add " + key + ":" + value);
    }
}
