package publisher.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import interfaces.MessageI;
import interfaces.PublicationsImplementationI;
import publisher.Publisher;

public class PublicationOutboundPort 
extends AbstractOutboundPort 
implements PublicationsImplementationI {

	private static final long serialVersionUID = 1L;

	public PublicationOutboundPort(ComponentI owner) 
	throws Exception {
		super(PublicationsImplementationI.class, owner);
		assert	owner instanceof Publisher ;
	}

	public PublicationOutboundPort(String uri, ComponentI owner) 
	throws Exception {
		super(uri, PublicationsImplementationI.class, owner);
		assert	owner instanceof Publisher ;
	}
	@Override
	public void publish(MessageI m, String topic) throws Exception{
		((PublicationsImplementationI)this.connector).publish(m, topic);
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		((PublicationsImplementationI)this.connector).publish(m, topics);		
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		((PublicationsImplementationI)this.connector).publish(m, topic);
	}

	@Override
	public void publish(MessageI[] m, String[] topics) throws Exception {
		((PublicationsImplementationI)this.connector).publish(m, topics);
	}


}
