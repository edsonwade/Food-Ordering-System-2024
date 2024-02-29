package code.with.vanilson.product;

import code.with.vanilson.Money.Money;
import code.with.vanilson.entity.BaseEntity;
import lombok.Getter;

@Getter
public class Product extends BaseEntity<ProductId> {
    private Money productName;
    private Money price;

    public Product() {
        //default constructors
    }

    public Product(Money productName, Money price) {
        super.setId(getId());
        this.productName = productName;
        this.price = price;
    }

}
