package cl.sportapp.evaluation.config.Pay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payload <T>{

    private T resource;

    public static <T> Payload<T> of(T resource) {
        return new Payload<>(resource);
    }
}
