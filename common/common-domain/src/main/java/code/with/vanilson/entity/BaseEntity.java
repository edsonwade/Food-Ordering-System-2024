package code.with.vanilson.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
abstract class BaseEntity<ID> {

    private ID id;

}
