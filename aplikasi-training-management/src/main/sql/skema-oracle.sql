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

-- skema tabel institusi

-- skema tabel catatan

-- skema tabel materi

-- skema tabel opsi

-- skema tabel pertanyaan

-- skema tabel peserta_batch

-- skema tabel ujian
