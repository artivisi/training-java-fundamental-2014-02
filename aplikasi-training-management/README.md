# Studi Kasus #

Aplikasi untuk mengelola kegiatan training

## Fitur ##

* Registrasi Peserta
* Materi Training
* Buka Kelas / Batch
* Start kelas
* Finish kegiatan training
* Absensi Peserta
* Catatan selama training
* Ujian / Tes
* Foto dan Dokumentasi training

## Domain Class ##

* Institusi

    - id
    - kode
    - nama
    - alamat
    - telepon
    - website

* Peserta

    - id
    - kode
    - nama
    - email
    - id_institusi
    - tanggal_bergabung

* Materi

    - id
    - kode
    - nama

* Batch

    - id
    - id_materi
    - tanggal_mulai
    - tanggal_selesai
    - status : belum mulai, sedang berjalan, sudah selesai

* PesertaBatch

    - id
    - id_batch
    - id_peserta

* Kehadiran

    - id
    - tanggal
    - id_peserta
    - id_batch

* Catatan

    - id
    - id_peserta
    - id_batch
    - isi
    - judul
    - no_urut
    - terakhir_update

* Ujian

    - id
    - id_materi
    - tanggal_diselenggarakan

* PesertaUjian

    - id
    - id_ujian
    - id_peserta

* Pertanyaan

    - id
    - isi
    - id_materi
    - tingkat_kesulitan : mudah, menengah, sulit

* Opsi

    - id
    - id_pertanyaan
    - no_urut
    - isi
    - benar

* Jawaban

    - id
    - id_peserta_ujian
    - id_pertanyaan
    - id_opsi
