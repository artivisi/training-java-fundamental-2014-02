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

-- skema tabel institusi

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
create sequence materi_id_seq start with increment by 1;
create table materi (
    id INT PRIMARY KEY,
    kode VARHCAR2 (30),
    nama VARCHAR (255)
)

-- skema tabel opsi
create sequence opsi_id_seq start with 1 increment by 1;
create table opsi(
    id INT PRIMARY KEY,
    id_pertanyaan INT,
    nomer_urut INT,
    isi VARCHAR2(255),
    benar_salah Boolean,
    FOREIGN KEY (id_pertanyaan) REFERENCES pertanyaan(id),
);
-- skema tabel opsi

-- skema tabel pertanyaan

-- skema tabel peserta_batch

-- skema tabel peserta_ujian

-- skema tabel ujian
