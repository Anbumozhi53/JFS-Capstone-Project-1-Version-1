@Entity
public class Bus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int availableSeats;
}
