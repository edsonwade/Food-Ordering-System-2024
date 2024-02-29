package code.with.vanilson.order;

import code.with.vanilson.Money.Money;
import code.with.vanilson.customer.CustomerId;
import code.with.vanilson.entity.Address;
import code.with.vanilson.entity.AggregateRoot;
import code.with.vanilson.entity.TrackingId;
import code.with.vanilson.exception.OrderDomainException;
import code.with.vanilson.product.ProductId;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order extends AggregateRoot<OrderId> {
    private final CustomerId customerId;

    private final ProductId productId;

    private final Address address;

    private final Money money;

    private final List<OrderItem> orderItem;

    private TrackingId trackingId;

    private OrderStatus orderStatus;

    private List<String> failureMessages;

    public void initializeOrder() {
        setId(new OrderId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        orderStatus = OrderStatus.PENDING;
        initializeOrderItems();
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order is not in correct state for pay operation!");
        }
        orderStatus = OrderStatus.PAID;
    }

    public void approve() {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for approve operation!");
        }
        orderStatus = OrderStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for initCancel operation!");
        }
        orderStatus = OrderStatus.CANCELLING;
        updateFailureMessages(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw new OrderDomainException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
        updateFailureMessages(failureMessages);
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    private void validateInitialOrder() {
        if (orderStatus != null || getId() != null) {
            throw new OrderDomainException("Order is not in correct state for initialization!");
        }
    }

    private void validateTotalPrice() {
        if (money == null || !money.isGreaterThanZero()) {
            throw new OrderDomainException("Total price must be greater than zero!");
        }
    }

    private void validateItemsPrice() {
        Money orderItemsTotal = orderItem
                .stream()
                .map(orderItems -> {
                    validateItemPrice(orderItems);
                    return orderItems.getSubTotal();
                }).reduce(Money.ZERO, Money::add);

        if (!money.equals(orderItemsTotal)) {
            throw new OrderDomainException("Total price: " + money.getAmount()
                    + " is not equal to Order items total: " + orderItemsTotal.getAmount() + "!");
        }
    }

    private void validateItemPrice(OrderItem orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new OrderDomainException("Order item price: " + orderItem.getPrice().getAmount() +
                    " is not valid for product " + orderItem.getProduct().getId().getValue());
        }
    }

    private void initializeOrderItems() {
        long itemId = 1;
        for (OrderItem orderItem1 : orderItem) {
            orderItem1.initializeOrderItem(super.getId(), new OrderItemId(itemId++));
        }
    }

    private Order(Builder builder) {
        super.setId(builder.orderId);
        customerId = builder.customerId;
        productId = builder.productId;
        address = builder.address;
        money = builder.money;
        orderItem = builder.orderItem;
        trackingId = builder.trackingId;
        orderStatus = builder.orderStatus;
        failureMessages = builder.failureMessage;
    }

    public static final class Builder {
        private OrderId orderId;
        private CustomerId customerId;
        private ProductId productId;
        private Address address;
        private Money money;
        private List<OrderItem> orderItem;
        private TrackingId trackingId;
        private OrderStatus orderStatus;
        private List<String> failureMessage;

        private Builder() {}

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderId(OrderId id) {
            orderId = id;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder money(Money val) {
            money = val;
            return this;
        }

        public Builder orderItem(List<OrderItem> val) {
            orderItem = val;
            return this;
        }

        public Builder trackingId(TrackingId val) {
            trackingId = val;
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder failureMessage(List<String> val) {
            failureMessage = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
