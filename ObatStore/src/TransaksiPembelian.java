

public class TransaksiPembelian extends Transaksi {

    public TransaksiPembelian(Pembeli pembeli, Item item, int jumlah) {
        super(pembeli, item, jumlah);
    }

    @Override
    public double hitungTotalPembayaran() {
        double totalPembayaran = super.hitungTotalPembayaran();

        // Menambahkan percabangan untuk diskon
        if (jumlah > 5) {
            double diskon = totalPembayaran * 0.1;
            totalPembayaran -= diskon;
        }

        // Menambahkan perhitungan pajak
        double pajak = totalPembayaran * 0.05;
        totalPembayaran += pajak;

        return totalPembayaran;
    }

    @Override
    public void prosesPembayaran() {
        super.prosesPembayaran();
    }

    @Override
    public String tampilkanTanggal() {
        return super.tampilkanTanggal();
    }
}
