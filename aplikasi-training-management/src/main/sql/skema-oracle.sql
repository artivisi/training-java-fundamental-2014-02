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

-- skema tabel materi

-- skema tabel opsi

-- skema tabel pertanyaan

-- skema tabel peserta_batch

-- skema tabel peserta_ujian

-- skema tabel ujian
