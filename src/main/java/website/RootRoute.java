package website;

import java.io.IOException;
import java.io.Writer;

import spark.Request;
import spark.Response;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;

public class RootRoute extends FreemarkerBasedRoute{

	public RootRoute(Configuration cfg) throws IOException {
		super("/", "home_template.ftl", cfg);
	}
	
	@Override
	public void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
		SimpleHash root = new SimpleHash();
		template.process(root, writer);
	}
	
}
