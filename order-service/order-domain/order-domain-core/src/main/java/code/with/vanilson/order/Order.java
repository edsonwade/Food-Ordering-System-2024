package code.with.vanilson.order;

import code.with.vanilson.Money.Money;
import code.with.vanilson.customer.CustomerId;
import code.with.vanilson.entity.Address;
import code.with.vanilson.entity.AggregateRoot;
import code.with.vanilson.entity.TrackingId;
import code.with.vanilson.product.ProductId;
import lombok.Getter;

import java.util.List;

@Getter
public class Order extends AggregateRoot<OrderId> {
    private final CustomerId customerId;

    private final ProductId productId;

    private final Address address;

    private final Money money;

    private final List<OrderItem> orderItem;

    private TrackingId trackingId;

    private OrderStatus orderStatus;

    private List<String> failureMessage;

    private Order(Builder builder) {
        super.setId(builder.orderId);
        customerId = builder.customerId;
        productId = builder.productId;
        address = builder.address;
        money = builder.money;
        orderItem = builder.orderItem;
        trackingId = builder.trackingId;
        orderStatus = builder.orderStatus;
        failureMessage = builder.failureMessage;
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
