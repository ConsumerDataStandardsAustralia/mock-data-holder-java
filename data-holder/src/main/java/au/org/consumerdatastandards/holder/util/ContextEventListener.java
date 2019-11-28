package au.org.consumerdatastandards.holder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.ServletContextListener;

@Component
public class ContextEventListener implements ApplicationListener<ContextRefreshedEvent>, ServletContextListener {

    @Autowired
    CdsDataLoader dataLoader;

    
    private static final Logger LOG = LogManager.getLogger(ContextEventListener.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            LOG.info("Service setup in progress, performing boot time operations");
            dataLoader.loadAll();
        } catch (IOException e) {
            LOG.error("IOException received while performing ContextEventListener based startup execution");            
            throw new RuntimeException(e);
        }
    }
}
