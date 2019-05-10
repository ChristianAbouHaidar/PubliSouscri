package connectors;

import fr.sorbonne_u.components.connectors.AbstractConnector;
import interfaces.MessageI;
import interfaces.PublicationI;
import interfaces.PublicationsImplementationI;

public class PublicationsConnector 
extends AbstractConnector 
implements PublicationI {

	@Override
	public void publish(MessageI m, String topic) throws Exception {
		((PublicationI)this.offering).publish(m,topic) ;
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		((PublicationI)this.offering).publish(m,topics) ;
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		((PublicationI)this.offering).publish(m,topic) ;
	}

	@Override
	public void publish(MessageI[] m, String[] topic) throws Exception {
		((PublicationI)this.offering).publish(m,topic) ;
	}

}
