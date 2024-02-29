package code.with.vanilson.product;

import code.with.vanilson.BaseId;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}
