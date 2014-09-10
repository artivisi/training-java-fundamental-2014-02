create table institusi(
    id INT PRIMARY KEY AUTO_INCREMENT,
    kode VARCHAR(30),
    nama VARCHAR(100),
    alamat VARCHAR(255),
    telepon VARCHAR(50),
    website VARCHAR(100)
) Engine=InnoDB;

create table peserta(
    id INT PRIMARY KEY AUTO_INCREMENT,
    kode VARCHAR(20),
    nama VARCHAR(255),
    email VARCHAR(255),
    tanggal_bergabung DATE,
    id_institusi INT NOT NULL,
    CONSTRAINT fk_institusi
    FOREIGN KEY(id_institusi)
    REFERENCES institusi(id)
) Engine=InnoDB;