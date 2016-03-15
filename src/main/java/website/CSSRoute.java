package website;


public class CSSRoute extends PlainResourceRoute {
	
	protected CSSRoute(String file) {
		super("/css/" + file, "text/css");
	}

}
