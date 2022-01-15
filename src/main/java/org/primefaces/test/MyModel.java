package org.primefaces.test;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jasper
 */
@Data
@Builder
@EqualsAndHashCode(of = {"id"})
public class MyModel implements Serializable {

    private String id;
    private String name;
    private Integer integer;
    private LocalDateTime localDateTime;

    @SuppressWarnings(
            "java:S5977" // Tests should use fixed data instead of randomized data
    )
    public static MyModel random() {
        return MyModel.builder()
                .id(UUID.randomUUID().toString())
                .name(UUID.randomUUID().toString().substring(0, 8))
                .integer(new SecureRandom().nextInt())
                .localDateTime(LocalDateTime.now().minusSeconds(new SecureRandom().nextLong(9999999)))
                .build();
    }

}
