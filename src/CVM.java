import brocker.Brocker;
import connectors.PublicationsConnector;
import fr.sorbonne_u.components.cvm.AbstractCVM;
import publisher.Publisher;

public class CVM extends AbstractCVM {

	protected static final String URI1 = "iport" ;
	protected static final String URI2 = "oportP" ;
	protected static final String URI3 = "oportR" ;
	
	public CVM() throws Exception {
		super();
	}

	@Override
	public void deploy() throws Exception {
		Brocker calc = new Brocker(URI1,URI2) ;
		Publisher v = new Publisher(URI3) ;
		v.toggleTracing() ;

		v.doPortConnection(
			URI2, URI1,
			PublicationsConnector.class.getCanonicalName());

		super.deploy();
	}

	public static void main(String[] args) {
		try {
			CVM cvm = new CVM() ;
			cvm.startStandardLifeCycle(2000L) ;
			Thread.sleep(10000L);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

