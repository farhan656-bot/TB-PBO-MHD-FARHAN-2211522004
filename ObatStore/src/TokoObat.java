import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class TokoObat {
    private List<Item> daftarItem;
    private List<Transaksi> daftarTransaksi;
    private Map<Pembeli, List<Transaksi>> riwayatTransaksi;

    public TokoObat() {
        this.daftarItem = new ArrayList<>();
        this.daftarTransaksi = new ArrayList<>();
        this.riwayatTransaksi = new HashMap<>();
    }

    public void tambahItem(Item item) {
        daftarItem.add(item);
    }

    public void tampilkanDaftarItem() {
        System.out.println("Daftar Item:");
        for (Item item : daftarItem) {
            System.out.println(item.getNama() + " - Rp " + item.getHarga());
        }
    }

    public List<Item> getDaftarItem() {
        return daftarItem;
    }

    public void prosesTransaksi(Pembeli pembeli, Item item, int jumlah) {
        // Menambahkan implementasi konkret dari Transaksi
        Transaksi transaksi = new TransaksiPembelian(pembeli, item, jumlah);
        daftarTransaksi.add(transaksi);

        // Menambahkan transaksi ke riwayat pembeli
        if (riwayatTransaksi.containsKey(pembeli)) {
            riwayatTransaksi.get(pembeli).add(transaksi);
        } else {
            List<Transaksi> transaksiList = new ArrayList<>();
            transaksiList.add(transaksi);
            riwayatTransaksi.put(pembeli, transaksiList);
        }

        System.out.println("Transaksi berhasil! Terima kasih, " + pembeli.getNama() + "!");
        System.out.println("Rincian Transaksi:");
        System.out.println("Item: " + item.getNama());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: Rp " + transaksi.hitungTotalPembayaran());
    }

    public void tampilkanRiwayatTransaksi(Pembeli pembeli) {
        System.out.println("Riwayat Transaksi untuk " + pembeli.getNama() + ":");
        if (riwayatTransaksi.containsKey(pembeli)) {
            for (Transaksi transaksi : riwayatTransaksi.get(pembeli)) {
                System.out.println("Tanggal: " + transaksi.tampilkanTanggal());
                System.out.println("Item: " + transaksi.getItem().getNama());
                System.out.println("Jumlah: " + transaksi.getJumlah());
                System.out.println("Total Harga: Rp " + transaksi.hitungTotalPembayaran());
                System.out.println("------");
            }
        } else {
            System.out.println("Tidak ada riwayat transaksi.");
        }
    }
}
