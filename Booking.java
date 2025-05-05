@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;

    @ManyToOne
    private Bus bus;

    private int seatsBooked;
    private double totalPrice;
    private LocalDate bookingDate;
}
