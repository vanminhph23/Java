package vn.isofh.test;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
 
@Path("/test")
public class TestServer {
	@GET
	@Produces("application/json")
	public Response test() {
		JSONObject o = new JSONObject();
		o.put("name", "John");
		o.put("age", "20");
		return Response.status(200).entity(o.toString()).build(); 
	}
}