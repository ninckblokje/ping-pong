package ninckblokje.ping.pong.javaee.monitor;

public class Health {

    private final HealthStatus status;

    public Health(HealthStatus status) {
        this.status = status;
    }

    public HealthStatus getStatus() {
        return status;
    }
}
