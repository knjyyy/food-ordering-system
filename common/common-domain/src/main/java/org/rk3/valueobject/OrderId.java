package org.rk3.valueobject;

import org.rk3.entity.BaseEntity;

import java.util.UUID;

public class OrderId extends BaseId<UUID> {
    public OrderId(UUID value) {
        super(value);
    }
}
