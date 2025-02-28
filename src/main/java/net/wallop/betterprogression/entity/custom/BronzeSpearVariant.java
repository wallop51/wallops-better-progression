package net.wallop.betterprogression.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum BronzeSpearVariant {
    DEFAULT(0),
    CRAFTED(1);

    private static final BronzeSpearVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(BronzeSpearVariant::getId)).toArray(BronzeSpearVariant[]::new);
    private final int id;

    BronzeSpearVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BronzeSpearVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
