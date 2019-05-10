package brocker.ports;

import brocker.Brocker;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import interfaces.MessageI;
import interfaces.PublicationI;
import interfaces.PublicationsImplementationI;

public class PublicationInboudPort 
extends AbstractInboundPort 
implements PublicationI {

	private static final long serialVersionUID = 1L;

	public PublicationInboudPort(ComponentI owner) throws Exception {
		super(PublicationI.class, owner);
		assert owner instanceof Brocker ;
	}

	public PublicationInboudPort(String uri, ComponentI owner) throws Exception {
		super(uri, PublicationI.class, owner);
		assert owner instanceof Brocker ;
	}

	@Override
	public void publish(MessageI m, String topic) throws Exception {
		this.getOwner().handleRequestAsync(
			new AbstractComponent.AbstractService<Void>() {
				@Override
				public Void call() throws Exception {
					((Brocker)this.getOwner()).publish(m, topic) ;
					return null;
				}	
			}
		);
	}

	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		this.getOwner().handleRequestAsync(
			new AbstractComponent.AbstractService<Void>() {
				@Override
				public Void call() throws Exception {
					((Brocker)this.getOwner()).publish(m, topics) ;
					return null;
				}	
			}
		);
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		this.getOwner().handleRequestAsync(
			new AbstractComponent.AbstractService<Void>() {
				@Override
				public Void call() throws Exception {
					((Brocker)this.getOwner()).publish(m, topic) ;
					return null;
				}	
			}
		);
	}

	@Override
	public void publish(MessageI[] m, String[] topic) throws Exception {
		this.getOwner().handleRequestAsync(
			new AbstractComponent.AbstractService<Void>() {
				@Override
				public Void call() throws Exception {
					((Brocker)this.getOwner()).publish(m, topic) ;
					return null;
				}	
			}
		);

	}

}
