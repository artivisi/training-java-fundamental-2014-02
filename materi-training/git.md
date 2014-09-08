# Version Control dengan Git #

Daftar Fitur

* aplikasi untuk mengelola file dan folder
* history perubahan
* mengambil file di versi yang lalu
* melihat perbedaan antar versi
* mengedit satu file secara bersamaan
* menggabungkan perubahan yang dibuat secara bersamaan
* tagging : memberi tanda/nama di versi tertentu
* penyimpanan terpusat

## Aplikasi Version Control ##

* Terpusat

    - CVS
    - Subversion

* Terdistribusi

    - [Git](http://git-scm.com/)
    - [Mercurial](http://mercurial.selenic.com)
    - [Bazaar](bazaar.canonical.com)

## Deployment ##

* Hosting Sendiri

    - [Gitblit](http://www.gitblit.com/)
    - [Gitolite](http://gitolite.com)
    - [Gitorious](https://gitorious.org/)

* Cloud Services

    - [Github](https://github.com)
    - [Bitbucket](https://bitbucket.org)
    - [Google Code](https://code.google.com/)
    - [Sourceforge](http://sourceforge.net)

## Instalasi ##

1. Donlod di websitenya
2. Install
3. Set user dan email

## Perintah Git ##

* Download repository yang sudah ada (existing)

        git clone <url-repository>
        git clone https://github.com/artivisi/training-java-fundamental-2014-02.git

* Mendaftarkan perubahan yang **akan** disimpan

        git add <namafile>
        git add .

* Simpan perubahan

        git commit -m "keterangan perubahan"

* Hal-hal yang disimpan:

    - nama dan email yang melakukan perubahan
    - waktu dan tanggal terjadinya perubahan
    - keterangan
    - isi perubahan

* Melihat status perubahan

        git status

* Beberapa status perubahan :

    - merah : untracked, belum terdaftar untuk disimpan
    - hijau : sudah didaftarkan (changes to be committed), tapi belum disimpan

* Melihat isi perubahan

        git diff
        git diff --staged

* Upload perubahan ke server

        git push

* Download perubahan dari server

        git pull
        
* Konfigurasi user name dan email

        git config --global user.name "Endy Muhardin"
        git config --global user.email endy.muhardin@gmail.com

## Beberapa Konsep Penting ##

* Merge : menggabungkan dua atau lebih perubahan terhadap satu file
