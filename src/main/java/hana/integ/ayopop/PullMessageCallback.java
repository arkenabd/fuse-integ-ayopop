package hana.integ.ayopop;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PullMessageCallback implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String url = (String) exchange.getProperty("fileRespPay");
		// "file://<<File-Location from JMS-Queue>>?noop=true"
//		String callbackUrl = exchange.getIn().getBody(String.class);

		ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
		// This is like your second "from". Use 2 second timeout (2000 ms).
		Exchange fileExchange = template.receive(url, 50000);
		exchange.getOut().setBody(fileExchange.getIn().getBody());
		System.out.println("Get message from callback :" + fileExchange.getIn().getBody());
		template.doneUoW(fileExchange);
	}
}
