package database;

import model.AirsoftProduct;
import java.util.ArrayList;
import java.util.List;

public final class AirsoftDatabase {
    private final List<AirsoftProduct> produk;

    public  AirsoftDatabase() {
        produk = new ArrayList<>();
    }

    public final void addProduct(AirsoftProduct product) {
        produk.add(product);
    }

    public final AirsoftProduct getProductById(int id) {
        for (AirsoftProduct product : produk) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public final List<AirsoftProduct> getAllProducts() {
        return produk;
    }

    public final void updateProduct(AirsoftProduct updatedProduct) {
        for (int i = 0; i < produk.size(); i++) {
            if (produk.get(i).getId() == updatedProduct.getId()) {
                produk.set(i, updatedProduct);
                break;
            }
        }
    }

    public final void deleteProduct(int id) {
        produk.removeIf(product -> product.getId() == id);
    }
}
