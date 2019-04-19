package com.kodilla.stream.invoice.simple;

public final class SimpleProduct {
    private final String productName;
    private final double productPriize;

    public SimpleProduct(String productName, double productPriize) {
        this.productName = productName;
        this.productPriize = productPriize;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPriize() {
        return productPriize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProduct that = (SimpleProduct) o;

        return getProductName() != null ? getProductName().equals(that.getProductName()) : that.getProductName() == null;
    }
}
