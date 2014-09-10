-- skema tabel peserta
create sequence peserta_id_seq start with 1 increment by 1;
create table peserta (
    id INT PRIMARY KEY,
    kode VARCHAR2(30),
    nama VARCHAR2(255),
    email VARCHAR2(255),
    id_institusi INT,
    tanggal_bergabung DATE
);

-- skema tabel batch
create sequence batch_id_seq start with 1 increment by 1;
create table batch (
    id INT PRIMARY KEY,
    tanggalMulai DATE,
    tanggalSelesai DATE,
    status VARCHAR2(32) ,
    FOREIGN KEY (id_materi) REFERENCES materi(id)
);
-- skema tabel catatan
create sequence catatan_id_seq start with 1 increment by 1;
create table catatan (
    id INT PRIMARY KEY,
    isi VARCHAR2(255),
    judul VARCHAR2(255),
    no_urut INT,
    terakhir_update DATE
    FOREIGN KEY (id_peserta) REFERENCES peserta(id),
    FOREIGN KEY (id_batch) REFERENCES batch(id)
);
-- skema tabel institusi
create sequence institusi_id_seq start with 1 increment by 1;
create table institusi(
    id INT PRIMARY KEY,
    kode VARCHAR2(30),
    nama VARCHAR2(100),
    alamat VARCHAR2(255),
    telepon VARCHAR2(50),
    website VARCHAR2(100)
);

-- skema tabel jawaban

-- skema tabel kehadiran
create sequence kehadiran_id_seq start with 1 increment by 1;
create table kehadiran(
    id INT PRIMARY KEY,
    tanggal DATE,
    id_peserta INT,
    id_batch INT,
    FOREIGN KEY (id_peserta) REFERENCES peserta(id),
    FOREIGN KEY (id_batch) REFERENCES batch(id)
);

-- skema tabel materi
create sequence materi_id_seq start with 1 increment by 1;
create table materi (
    id INT PRIMARY KEY,
    kode VARCHAR2 (30),
    nama VARCHAR2 (255)
)

-- skema tabel opsi
create sequence opsi_id_seq start with 1 increment by 1;
create table opsi(
    id INT PRIMARY KEY,
    id_pertanyaan INT,
    nomer_urut INT,
    isi VARCHAR2(255),
    benar_salah number(1) check(benar_salah in (0, 1)) 
    FOREIGN KEY (id_pertanyaan) REFERENCES pertanyaan(id),
);
-- skema tabel opsi

-- skema tabel pertanyaan

-- skema tabel peserta_batch
create sequence peserta_batch_id_seq start with 1 increment by 1;
create table peserta_batch(
    id INT PRIMARY KEY,
    id_ujian INT,
    id_peserta INT,
    FOREIGN KEY (id_peserta) REFERENCES peserta(id),
    FOREIGN KEY (id_batch) REFERENCES batch(id)
);

-- skema tabel peserta_ujian
create sequence peserta_ujian_id_seq start with 1 increment by 1;
create table peserta_ujian(
    id INT PRIMARY KEY,
    id_peserta INT,
    id_ujian INT,
    FOREIGN KEY (id_peserta) REFERENCES peserta(id),
    FOREIGN KEY (id_ujian) REFERENCES ujian(id)
);

-- skema tabel ujian
create sequence ujian_id_seq start with 1 increment by 1;
create table ujian(
    id INT PRIMARY KEY,
    id_materi INT,
    tanggal_diselenggarakan DATE,
    FOREIGN KEY (id_materi) REFERENCES materi(id)
);
