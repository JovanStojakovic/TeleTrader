package TeleTraderProject.dto;

import TeleTraderProject.model.OrderType;
import TeleTraderProject.model.StockSymbol;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class OrderDTO {
    private int id;
    @NotNull(message = "OrderType must not be null")
    private OrderType orderType;

    @NotNull(message = "Amount must not be null")
    @Positive(message = "Amount be a positive value")
    private BigDecimal price;

    @NotNull(message = "amount must not be null")
    @Positive(message = "Amount must be a positive value")
    private int amount;

    @NotNull(message = "Stock Symbol must not be null")
    private StockSymbol stockSymbol;

    private LocalTime localTime;

    private LocalDate localDate;

    @NotNull(message = "Trader name must not be null")
    private String traderName;
}
