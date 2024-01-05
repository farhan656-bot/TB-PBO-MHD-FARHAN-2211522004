import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek pembeli
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        Pembeli pembeli = new Pembeli(namaPembeli);

        // Membuat objek toko obat
        TokoObat toko = new TokoObat();

        // Membuat beberapa objek obat
        Obat obat1 = new Obat("Paracetamol", 5000);
        Obat obat2 = new Obat("Amoxicillin", 10000);
        Obat obat3 = new Obat("Panadol",6000);
        Obat obat4 = new Obat("Betadin",5000);
        Obat obat5 = new Obat("CTM",10000);

        // Menambahkan obat ke dalam toko
        toko.tambahItem(obat1);
        toko.tambahItem(obat2);
        toko.tambahItem(obat3);
        toko.tambahItem(obat4);
        toko.tambahItem(obat5);

        // Menampilkan daftar obat
        toko.tampilkanDaftarItem();

        // Proses transaksi
        System.out.print("Masukkan nama obat yang ingin dibeli: ");
        String namaObat = scanner.nextLine();
        System.out.print("Masukkan jumlah obat yang ingin dibeli: ");
        int jumlahObat = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline

        // Cari obat berdasarkan nama
        Item obatDipilih = null;
        for (Item item : toko.getDaftarItem()) {
            if (item.getNama().equalsIgnoreCase(namaObat)) {
                obatDipilih = item;
                break;
            }
        }

        if (obatDipilih != null) {
            // Proses transaksi
            toko.prosesTransaksi(pembeli, obatDipilih, jumlahObat);

            // Menampilkan riwayat transaksi
            toko.tampilkanRiwayatTransaksi(pembeli);
        } else {
            System.out.println("Obat tidak ditemukan.");
        }

        // Menutup Scanner
        scanner.close();
    }
}
