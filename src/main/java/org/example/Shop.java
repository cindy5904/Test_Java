package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {
        if ("Normal".equals(product.getType())) {
            if (product.getSellIn() > 0) {
                product.setQuality(product.getQuality() - 1);
            } else {
                product.setQuality(product.getQuality() - 2);
            }
        } else if ("Brie Vieilli".equals(product.getType())) {

            product.setQuality(product.getQuality() + 1);
        } else if ("Produit Laitier".equals(product.getType())) {

            if (product.getSellIn() > 0) {
                product.setQuality(product.getQuality() - 2);
            } else {
                product.setQuality(product.getQuality() - 4);
            }
        } else {
            throw new NotFoundException("Type de produit : " + product.getType());
        }

        product.setSellIn(product.getSellIn() - 1);

        if (product.getQuality() < 0) {
            product.setQuality(0);
        } else if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }
    }

