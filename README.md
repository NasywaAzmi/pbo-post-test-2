Nama: Akhmad Nasywa Azmi 
NIM: 2209116099 
Kelas: Sistem Informasi 2022 B2

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
-Ini adalah kelas entitas yang mewakili produk produk di toko airsoft. Setiap produk memiliki tiga atribut: id, nama, dan harga
-Disediakan konstruktor untuk membuat objek produk dan metode getters untuk mengakses atribut-atribut ini

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
-Ini adalah kelas yang bertanggung jawab atas manajemen data produk airsoft. Data produk disimpan dalam ArrayList yang disebut "produk"
-Metode addProduct digunakan untuk menambahkan produk baru ke dalam database
-Metode getProductById digunakan untuk mencari produk berdasarkan ID
-Metode getAllProducts digunakan untuk mengambil semua produk dalam database
-Metode updateProduct digunakan untuk memperbarui produk yang ada
-Metode deleteProduct digunakan untuk menghapus produk berdasarkan ID

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
-Ini adalah kelas utama yang berfungsi sebagai titik masuk program
-Program berjalan menggunakan loop
-Pengguna diberikan beberapa pilihan, seperti menambahkan produk, menampilkan produk, memperbarui produk, dan menghapus produk.
-Pengguna memasukkan pilihan yang mereka inginkan dan program akan menjalankan fungsi yang sesuai dengan pilihan para pengguna
-Ada validasi input sederhana untuk memastikan bahwa pengguna memasukkan data yang sesuai
