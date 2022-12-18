package rowing.user.domain.user;

public class AvailabilityNotFoundException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public AvailabilityNotFoundException(AvailabilityIntervals interval) {
        super(interval.toString() + "was not found");
    }
}
