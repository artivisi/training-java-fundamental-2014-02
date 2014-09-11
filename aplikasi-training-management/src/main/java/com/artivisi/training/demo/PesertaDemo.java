package com.artivisi.training.demo;

import com.artivisi.training.domain.Peserta;

import java.math.BigDecimal;

public class PesertaDemo {
    public static void main(String[] args) {
        // Deklarasi
        String nama;
        
        // Inisialisasi : mengisi data ke dalam variabel untuk pertama kali
        nama = "endy";
        
        BigDecimal harga = new BigDecimal("100000.99");
        
        Peserta.setJumlah(10);
        System.out.println("Jumlah : "+Peserta.getJumlah());
        
        // Deklarasi
        Peserta p;
        
        // Inisialisasi
        p = new Peserta();
        
        // Assignment : mengisi data ke dalam variabel
        nama = "Jimmy";
        
        p.setKode("P-001");
        p.setNama("Endy");
        p.setJumlah(1);

        Peserta p2 = new Peserta();
        p2.setNama("Adi");
        p2.setJumlah(2);
        
        System.out.println("Nama p : "+p.getNama());
        System.out.println("Jumlah p : "+p.getJumlah());
        
        System.out.println("Nama p2 : "+p2.getNama());
        System.out.println("Jumlah p2 : "+p2.getJumlah());
        
        coba("Halo");
        
        panjang = nama.length();
        
        System.out.println("================");
        for(int i = 0; i<panjang; i++){
            System.out.println(nama);
        }
        
        coba("Halo", "Ini", "Percobaan");
    }
    
    static Integer panjang;
    
    public static void coba(String x, String... y){
        System.out.println("Panjang : "+panjang);
        System.out.println("X : "+x);
        System.out.println("Jumlah y : "+y.length);
    }
}
