package  com.api.payment.logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("Slf4jLogger")
public class Slf4jLogger implements Log{


	@Override
	public void logerror(String msg) {
		LoggerFactory.getLogger(getClass()).error(msg);
		
	}

	@Override
	public void logwarn(String msg) {
		LoggerFactory.getLogger(getClass()).warn(msg);
		
	}

	@Override
	public void loginfo(String msg) {
		LoggerFactory.getLogger(getClass()).info(msg);
		
	}

	@Override
	public void logdebug(String msg) {
		LoggerFactory.getLogger(getClass()).debug(msg);
		
	}

	

}
