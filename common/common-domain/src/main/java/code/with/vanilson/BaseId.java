package code.with.vanilson;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class BaseId<T> {
    private final T value;

    public BaseId(T value) {
        this.value = value;
    }
}
