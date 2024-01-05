import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaksi implements Pembayaran {
    protected Pembeli pembeli;
    protected Item item;
    protected int jumlah;
    protected Date tanggal;

    public Transaksi(Pembeli pembeli, Item item, int jumlah) {
        this.pembeli = pembeli;
        this.item = item;
        this.jumlah = jumlah;
        this.tanggal = new Date();
    }

    @Override
    public double hitungTotalPembayaran() {
        return item.getHarga() * jumlah;
    }

    @Override
    public void prosesPembayaran() {
        double totalPembayaran = hitungTotalPembayaran();
        System.out.println("Total Pembayaran: Rp " + totalPembayaran);

        // Menambahkan percabangan untuk diskon
        if (jumlah > 5) {
            double diskon = totalPembayaran * 0.1;
            totalPembayaran -= diskon;
            System.out.println("Diskon 10% diterapkan. Total Pembayaran setelah diskon: Rp " + totalPembayaran);
        }

        // Menambahkan perhitungan pajak
        double pajak = totalPembayaran * 0.05;
        totalPembayaran += pajak;
        System.out.println("Pajak 5% diterapkan. Total Pembayaran setelah pajak: Rp " + totalPembayaran);

        System.out.println("Pembayaran berhasil diproses. Terima kasih!");
    }

    // Menambahkan metode untuk manipulasi Date
    public String tampilkanTanggal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            Date parsedDate = dateFormat.parse(dateFormat.format(tanggal));
            return "Tanggal Transaksi: " + dateFormat.format(parsedDate);
        } catch (ParseException e) {
            return "Gagal mengonversi tanggal transaksi.";
        }
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public Item getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }
}
