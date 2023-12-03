package com.example.quran.data.pojo;

import java.util.Objects;

public class ZekrType {
    private String zekrName;

    public ZekrType(String zekrName) {
        this.zekrName = zekrName;
    }



    public String getZekrName() {
        return zekrName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZekrType zekrType = (ZekrType) o;
        return zekrName.equals(zekrType.zekrName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zekrName);
    }
}
