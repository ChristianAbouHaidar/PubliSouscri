package connectors;

import fr.sorbonne_u.components.connectors.AbstractConnector;
import interfaces.MessageI;
import interfaces.PublicationsImplementationI;

public class PublicationsConnector 
extends AbstractConnector 
implements PublicationsImplementationI {

	@Override
	public void publish(MessageI m, String topic) throws Exception {
		((PublicationsImplementationI)this.offering).publish(m,topic) ;
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		((PublicationsImplementationI)this.offering).publish(m,topics) ;
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		((PublicationsImplementationI)this.offering).publish(m,topic) ;
	}

	@Override
	public void publish(MessageI[] m, String[] topic) throws Exception {
		((PublicationsImplementationI)this.offering).publish(m,topic) ;
	}

}
