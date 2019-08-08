package com.senasoft.consumogetandpost.model;

public class Producto {
    private String nameProduct;
    private String volumeProduct;
    private String valueProduct;
    private String stockProduct;
    private String urlImageProduct;

    public Producto() {
    }

    public Producto(String nameProduct, String volumeProduct, String valueProduct, String stockProduct, String urlImageProduct) {
        this.nameProduct = nameProduct;
        this.volumeProduct = volumeProduct;
        this.valueProduct = valueProduct;
        this.stockProduct = stockProduct;
        this.urlImageProduct = urlImageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getVolumeProduct() {
        return volumeProduct;
    }

    public void setVolumeProduct(String volumeProduct) {
        this.volumeProduct = volumeProduct;
    }

    public String getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(String valueProduct) {
        this.valueProduct = valueProduct;
    }

    public String getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.stockProduct = stockProduct;
    }

    public String getUrlImageProduct() {
        return urlImageProduct;
    }

    public void setUrlImageProduct(String urlImageProduct) {
        this.urlImageProduct = urlImageProduct;
    }
}
