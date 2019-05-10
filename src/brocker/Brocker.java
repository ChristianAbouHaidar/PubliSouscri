package brocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import brocker.ports.PublicationInboudPort;
import fr.sorbonne_u.components.AbstractComponent;
import interfaces.MessageI;
import interfaces.PublicationsImplementationI;

public class Brocker extends AbstractComponent {
	
	private Map<String, List<String>> topicsSub = new HashMap<String, List<String>>();
	private PublicationInboudPort port;
	public Brocker(String portURI) throws Exception {
		super(portURI, 1, 0);
		this.addRequiredInterface(PublicationsImplementationI.class);
		this.port = new PublicationInboudPort(portURI, this) ;
		this.addPort(this.port);
		this.port.publishPort() ;
	}

	public void publier(MessageI m, String topic) throws Exception {
		if (!isTopic(topic)) 
			createTopic(topic);
		this.traceMessage("les topics = " + getTopics()) ;
		System.out.println("les topics : ");
		Stream.of(topicsSub.keySet().toString()).forEach(System.out::println);
		// TODO -> envoyer aux sub
	}

	
	public void publier(MessageI m, String[] topics) throws Exception {
		for(String t: topics) publier(m,t);
	}

	
	public void publier(MessageI[] m, String topic) throws Exception {
		for(MessageI mes: m) publier(mes,topic);
	}

	
	public void publier(MessageI[] m, String[] topics) throws Exception {
		for(MessageI mes: m)
			for(String t: topics)
				publier(mes,t);
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
}
