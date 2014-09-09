create table peserta(
    id INT PRIMARY KEY AUTO_INCREMENT,
    kode VARCHAR(20),
    nama VARCHAR(255),
    email VARCHAR(255),
    tanggal_bergabung DATE
) Engine=InnoDB;