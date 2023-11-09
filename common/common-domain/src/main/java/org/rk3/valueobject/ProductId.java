package org.rk3.valueobject;

import java.util.UUID;

public class ProductId extends BaseId<UUID>{

    public ProductId(UUID value) {
        super(value);
    }
}
