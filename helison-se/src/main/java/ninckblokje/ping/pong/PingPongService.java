package ninckblokje.ping.pong;

import io.helidon.webserver.Routing.Rules;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class PingPongService implements Service {

    private final Logger logger = Logger.getLogger(PingPongService.class.getName());

    @Override
    public void update(Rules rules) {
        rules.get("/", this::getPingPongHandler);
    }
    
    void getPingPongHandler(ServerRequest request, ServerResponse response) {
        var clientIp = request.remoteAddress();
        var dateTime = getCurrentDateTime();
        var hostName = getHostName();
        var osArch = System.getProperty("os.arch");
        var osName = System.getProperty("os.name");

        logger.log(Level.INFO, "{0} request from {1}", new Object[]{
                dateTime,
                clientIp
        });

        response.send(String.format("%s on %s (running %s/%s)", dateTime, hostName, osName, osArch));
    }

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
}
