package publisher;

import concrateObjects.Message;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import interfaces.MessageI;
import interfaces.PublicationsImplementationI;
import publisher.ports.PublicationOutboundPort;

public class Publisher 
extends AbstractComponent 
implements PublicationsImplementationI
{

	protected PublicationOutboundPort	publiPort;

	public Publisher(String portURI) throws Exception{
		super(1, 0);
		this.publiPort = new PublicationOutboundPort(portURI,this) ;
		this.addPort(this.publiPort) ;
		this.publiPort.publishPort() ;
	}

	@Override
	public void publish(MessageI m, String topic) throws Exception {
		this.publiPort.publish(m,topic);
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		this.publiPort.publish(m,topics);

	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		this.publiPort.publish(m,topic);

	}

	@Override
	public void publish(MessageI[] m, String[] topics) throws Exception {
		this.publiPort.publish(m,topics);
	}


	@Override
	public void execute() throws Exception {
		super.execute();
		String[] lesTopics = {"tpoic1", "tpoic2", "tpoic3", "tpoic1"};
		publish(new Message("hello World"), lesTopics);
	}


	@Override
	public void finalise() throws Exception {
		this.doPortDisconnection(this.publiPort.getPortURI());
		super.finalise();
	}


	@Override
	public void shutdown() throws ComponentShutdownException {
		try {
			this.publiPort.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e) ;
		}
		super.shutdown();
	}
	
	

}
