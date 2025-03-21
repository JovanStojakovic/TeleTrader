package TeleTraderProject.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "orderType")
    @NotNull(message = "Order Type must not be null")
    private OrderType orderType;
    @Column(name = "price")
    @NotNull(message = "price must not be null")
    @Positive(message = "Price must be a positive value")
    private BigDecimal price;
    @Column(name = "amount")
    @NotNull(message = "Amount must not be null")
    @Positive(message = "Amount be a positive value")
    private int amount;
    @Column(name = "stockSymbol")
    @NotNull(message = "Stock Symbol must not be null")
    private StockSymbol stockSymbol;
    private LocalTime localTime;
    private LocalDate localDate;
    @Column(name = "traderName")
    @NotNull(message = "Trader name must not be null")
    private String traderName;

}
