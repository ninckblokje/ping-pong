
package ninckblokje.ping.pong.helidon.se;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import io.helidon.config.Config;
import io.helidon.health.HealthSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import ninckblokje.ping.pong.PingPongService;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        startServer();
    }

    static WebServer startServer() throws IOException {
        setupLogging();

        var config = Config.create();

        var server = WebServer.builder(createRouting())
            .config(config.get("server"))
            .build();

        server.start().thenAccept(ws -> {
            System.out.println("Server is up! http://localhost:" + ws.port() + "/ping");
            ws.whenShutdown().thenRun(() -> System.out.println("Server is down. Good bye!"));
        }).exceptionally(t -> {
            System.err.println("Startup failed: " + t.getMessage());
            t.printStackTrace(System.err);
            return null;
        });

        return server;
    }

    private static Routing createRouting() {
        var pingPongService = new PingPongService();
        var health = HealthSupport.builder()
            .build();

        return Routing.builder()
            .register(health)
            .register("/ping", pingPongService)
            .build();
    }

    private static void setupLogging() throws IOException {
        try (InputStream is = Main.class.getResourceAsStream("/logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        }
    }
}
