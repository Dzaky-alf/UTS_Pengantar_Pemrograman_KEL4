import java.util.ArrayList;

public class Hotel {
    private ArrayList<Kamar> daftarKamar;

    public Hotel() {
        daftarKamar = new ArrayList<>();
    }

    public void tambahKamar(Kamar k) {
        daftarKamar.add(k);
    }

    public Kamar cariKamarKosong(String tipe) {
        for (Kamar k : daftarKamar) {
            if (k.getTipeKamar().equalsIgnoreCase(tipe) && !k.getStatus()) {
                return k;
            }
        }
        return null;
    }

    public double hitungTotalBayar(Tamu t, Kamar k) {
        return t.getDurasiMenginap() * k.getHargaPerMalam();
    }

    public void tampilkanDaftarKamar() {
        System.out.println("\n=== Daftar Semua Kamar ===");
        for (Kamar k : daftarKamar) {
            System.out.println(k);
        }
    }

    public void tampilkanKamarKosong() {
        System.out.println("\n=== Kamar Kosong ===");
        for (Kamar k : daftarKamar) {
            if (!k.getStatus()) {
                System.out.println(k);
            }
        }
    }
}
