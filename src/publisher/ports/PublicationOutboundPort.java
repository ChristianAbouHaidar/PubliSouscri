package publisher.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import interfaces.MessageI;
import interfaces.PublicationI;
import interfaces.PublicationsImplementationI;
import publisher.Publisher;

public class PublicationOutboundPort 
extends AbstractOutboundPort 
implements PublicationI {

	private static final long serialVersionUID = 1L;

	public PublicationOutboundPort(ComponentI owner) 
	throws Exception {
		super(PublicationI.class, owner);
		assert	owner instanceof Publisher ;
	}

	public PublicationOutboundPort(String uri, ComponentI owner) 
	throws Exception {
		super(uri, PublicationI.class, owner);
		assert	owner instanceof Publisher ;
	}
	@Override
	public void publish(MessageI m, String topic) throws Exception{
		((PublicationI)this.connector).publish(m, topic);
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		((PublicationI)this.connector).publish(m, topics);		
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		((PublicationI)this.connector).publish(m, topic);
	}

	@Override
	public void publish(MessageI[] m, String[] topics) throws Exception {
		((PublicationI)this.connector).publish(m, topics);
	}


}
