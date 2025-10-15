import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Tambah beberapa kamar
        hotel.tambahKamar(new Kamar(111, "Standard", 600000));
        hotel.tambahKamar(new Kamar(112, "Deluxe", 800000));
        hotel.tambahKamar(new Kamar(113, "Suite", 1000000));
        hotel.tambahKamar(new Kamar(114, "Suite", 1000000));
        hotel.tambahKamar(new Kamar(115, "Standard", 600000));
        hotel.tambahKamar(new Kamar(116, "Deluxe", 800000));

        System.out.print("Berapa jumlah tamu yang ingin memesan? ");
        int jumlahTamu = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahTamu; i++) {
            System.out.println("\n=== Data Tamu ke-" + (i + 1) + " ===");
            System.out.print("Nama tamu: ");
            String nama = input.nextLine();

            System.out.print("Durasi menginap (malam): ");
            int durasi = input.nextInt();
            input.nextLine();

            System.out.print("Pilih tipe kamar (Standard/Deluxe/Suite): ");
            String tipe = input.nextLine();

            Tamu tamu = new Tamu(nama, durasi);
            Kamar kamarDipilih = hotel.cariKamarKosong(tipe);

            if (kamarDipilih != null) {
                kamarDipilih.pesanKamar();
                double total = hotel.hitungTotalBayar(tamu, kamarDipilih);
                System.out.println("\n✅ Pemesanan berhasil!");
                System.out.println("Tamu: " + tamu.getNama());
                System.out.println("Nomor Kamar: " + kamarDipilih.getNomorKamar());
                System.out.println("Tipe: " + kamarDipilih.getTipeKamar());
                System.out.println("Total Bayar: Rp " + total);
            } else {
                System.out.println("\n❌ Maaf, tidak ada kamar kosong untuk tipe tersebut.");
            }
        }

        hotel.tampilkanDaftarKamar();
        hotel.tampilkanKamarKosong();

        input.close();
    }
}
