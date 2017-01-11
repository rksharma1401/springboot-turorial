/**
 * 
 */
package springboot.servcie;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

/**
 * @author ravikant.sharma 10-Jan-2017
 */
@Service
public class GreetingService {

	private final AtomicLong counter = new AtomicLong();
	private ResourceBundle bundle;
	private Locale locale;

	public GreetingService() {
		this.locale = Locale.US;
		setBundle();
	}

	public GreetingService(Locale locale) {
		this.locale = locale;
		setBundle();
	}

	public Greeting greet(String name) {
		String template = bundle.getString("greeting_template");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));

	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		setBundle();
	}

	public Locale getLocale() {
		return locale;
	}

	private void setBundle() {
		bundle = ResourceBundle.getBundle("MessageBundle", this.locale);
	}
 
	public String askName() {
		return bundle.getString("askName");
	}
}
