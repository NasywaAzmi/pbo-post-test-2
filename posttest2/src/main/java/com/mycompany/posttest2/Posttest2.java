package com.mycompany.posttest2;

import database.AirsoftDatabase;
import model.AirsoftProduct;

import java.util.List;
import java.util.Scanner;

public final class Posttest2 {
    public final static void main(String[] args) {
        AirsoftDatabase database = new AirsoftDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Toko Airsoft Osama ===");
            System.out.println("1. Tambahkan Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Update Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("0. logout");
            System.out.print("Pilih (1/5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Produk: ");
                    int id = scanner.nextInt();
                    System.out.print("Masukkan Nama Produk: ");
                    String name = scanner.next();
                    System.out.print("Masukkan Harga Produk: ");
                    double price = scanner.nextDouble();
                    AirsoftProduct product = new AirsoftProduct(id, name, price);
                    database.addProduct(product);
                    break;
                case 2:
                    List<AirsoftProduct> products = database.getAllProducts();
                    System.out.println("Daftar Produk Airsoft:");
                    for (AirsoftProduct p : products) {
                        System.out.println("ID: " + p.getId() + ", Nama: " + p.getNama() + ", Harga: " + p.getHarga());
                    }
                    break;
                case 3:
                    System.out.print("Masukkan ID Produk yang akan diupdate: ");
                    int updateId = scanner.nextInt();
                    AirsoftProduct existingProduct = database.getProductById(updateId);
                    if (existingProduct != null) {
                        System.out.print("Masukkan Nama Produk baru: ");
                        String newName = scanner.next();
                        System.out.print("Masukkan Harga Produk baru: ");
                        double newPrice = scanner.nextDouble();
                        AirsoftProduct updatedProduct = new AirsoftProduct(updateId, newName, newPrice);
                        database.updateProduct(updatedProduct);
                    } else {
                        System.out.println("ID tersebut tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID Produk yang akan dihapus: ");
                    int deleteId = scanner.nextInt();
                    database.deleteProduct(deleteId);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
