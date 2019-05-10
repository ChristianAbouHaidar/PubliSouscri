package brocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import brocker.ports.PublicationInboudPort;
import brocker.ports.ReceptionOutboudPort;
import fr.sorbonne_u.components.AbstractComponent;
import interfaces.MessageI;
import interfaces.PublicationI;
import interfaces.PublicationsImplementationI;
import interfaces.ReceptionI;

public class Brocker 
extends AbstractComponent 
implements PublicationI, ReceptionI {
	
	private Map<String, List<String>> topicsSub = new HashMap<String, List<String>>();
	private PublicationInboudPort portPubli;
	private ReceptionOutboudPort portRecep;
	
	
	public Brocker(String portURIP, String portURIR) throws Exception {
		super(1, 0);
		this.addOfferedInterface(PublicationI.class);
		this.addRequiredInterface(ReceptionI.class);
		this.portPubli = new PublicationInboudPort(portURIP, this) ;
		this.portRecep = new ReceptionOutboudPort(portURIR, this) ;
		this.addPort(this.portPubli);
		this.addPort(portRecep);
		this.portPubli.publishPort() ;
		this.portRecep.publishPort();
	}

	@Override
	public void publish(MessageI m, String topic) throws Exception {
		if (!isTopic(topic)) 
			createTopic(topic);
		this.traceMessage("les topics = " + getTopics()) ;
		System.out.println("les topics : ");
		Stream.of(topicsSub.keySet().toString()).forEach(System.out::println);
		// TODO -> envoyer aux sub
	}
	
	@Override
	public void publish(MessageI m, String[] topics) throws Exception {
		for(String t: topics) publish(m,t);
	}

	@Override
	public void publish(MessageI[] m, String topic) throws Exception {
		for(MessageI mes: m) publish(mes,topic);
	}

	@Override
	public void publish(MessageI[] m, String[] topics) throws Exception {
		for(MessageI mes: m)
			for(String t: topics)
				publish(mes,t);
	}

	public void createTopic(String topic) {
		if(!isTopic(topic)) 
			topicsSub.put(topic, new ArrayList<String>());
		else System.out.println("'Create' -> Le topic : " + topic + " existe déjà.");		
	}

	public void createTopics(String[] topics) {
		for(String t: topics) createTopic(t);
	}

	public void destroyTopic(String topic) {
		if(isTopic(topic)) 
			topicsSub.remove(topic);
		else System.out.println("'Destroy' -> Le topic : " + topic + " existe pas.");
			
	}

	public boolean isTopic(String topic) {
		return topicsSub.containsKey(topic);
	}

	public String[] getTopics() {
		Set<String> set = topicsSub.keySet();
        String arr[] = new String[set.size()];  
        return set.toArray(arr); 
	}

	@Override
	public void acceptMessage(MessageI m) throws Exception {
		this.portRecep.acceptMessage(m);
	}

	@Override
	public void acceptMessage(MessageI[] m) throws Exception {
		this.portRecep.acceptMessage(m);
	}
}
