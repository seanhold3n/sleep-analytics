package website;


public class JSRoute extends PlainResourceRoute {
	
	protected JSRoute(String file) {
		super("/js" + file, "application/javascript");
	}

}
