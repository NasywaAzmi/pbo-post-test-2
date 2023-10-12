package model;

public final class AirsoftProduct {
    private final int id;
    private final String nama;
    private final double harga;

    public AirsoftProduct(int id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
