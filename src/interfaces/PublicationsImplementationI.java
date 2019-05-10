package interfaces;

public interface PublicationsImplementationI extends PublicationI{
	public void publish(MessageI m, String topic) throws Exception;
	public void publish(MessageI m, String[] topics) throws Exception;
	public void publish(MessageI[] m, String topic) throws Exception;
	public void publish(MessageI[] m, String[] topic) throws Exception;
}
