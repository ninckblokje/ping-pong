package ninckblokje.ping.pong.javaee.monitor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static ninckblokje.ping.pong.javaee.monitor.HealthStatus.UP;

@Path("/health")
public class HealthResource {

    @GET
    @Produces("application/json")
    public Health getHealth() {
        return new Health(UP);
    }

}
