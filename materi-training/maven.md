# Java Build Tools #

Memproses dari source code hingga menjadi produk akhir.

Aktivitas Build:

* Resolve Dependency
* Download Dependency
* Compile
* Package (jar,war)
* Run
* Generate Dokumentasi
* Generate Website

Macam-macam aplikasi build di Java

* Ant
* Maven
* Gradle

## Apache Maven ##

Build tools yang paling mainstream di Java untuk saat ini (2014).

### Instalasi ###

1. Download di websitenya
2. Extract
3. Daftarkan ke dalam environment variabel PATH
4. Test, jalankan `mvn -version` di command line

### Why Maven ###

* Portability : project bisa dibuka dengan berbagai editor.
* Dependency Management : cari dan donlod dependensi, mudah naik versi, transitive dependency.
* Trend jaman sekarang : store untuk semua apps.

### Perintah Maven ###

* Compile : mvn package
* Clean : mvn clean
* Clean + Compile : mvn clean package
* Run : mvn exec:java -Dexec.mainClass=nama.lengkap.ClassYangMauDijalankan

