package TeleTraderProject.model;

import java.util.Optional;

public enum OrderType {
    BUY, SELL;
    public static Optional<OrderType> getOrderTypeFromString(String orderTypeStr) {
        if (orderTypeStr != null && !orderTypeStr.trim().isEmpty()) {
                return Optional.of(OrderType.valueOf(orderTypeStr.toUpperCase()));
        }
        return Optional.empty();
    }

}
