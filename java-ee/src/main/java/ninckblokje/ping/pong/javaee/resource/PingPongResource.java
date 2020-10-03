package ninckblokje.ping.pong.javaee.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/ping")
public class PingPongResource {

    private final Logger logger = Logger.getLogger(PingPongResource.class.getName());

    String getCurrentDateTime() {
        return OffsetDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }
    }

    @GET
    @Produces(TEXT_PLAIN)
    public String ping(@Context HttpServletRequest req) {
        var clientIp = req.getRemoteHost();
        var dateTime = getCurrentDateTime();
        var hostName = getHostName();
        var osArch = System.getProperty("os.arch");
        var osName = System.getProperty("os.name");

        logger.log(Level.INFO, "{0} request from {1}", new Object[]{
                dateTime,
                clientIp
        });
        return String.format("%s on %s (running %s/%s)", dateTime, hostName, osName, osArch);
    }
}
