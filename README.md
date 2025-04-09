Kelompok R
Disusun oleh :
Revan Permana Hakim Saputra (102062400134)
Bryan Zefanya Maitimu ( )


**Game Petualangan Berbasis OOP**

Deskripsi Umum 
: Game ini adalah game petualangan berbasis teks di mana pemain akan menjelajahi dunia misterius yang penuh dengan pilihan. Game ini dibangun menggunakan prinsip Object Oriented Programming(OOP) dengan 3 class utama : Character, Scene, dan Story.
Pemain akan membuat keputusan di setiap adegan(scene) yang akan mempengaruhi kesehatan, XP, dan item yang dimiliki. Setiap keputusan dapat membawa pemain ke akhir cerita yang berbeda.


**ALUR CERITA**
: Alur ceritanya adalah kamu berperan sebagai seorang pahlawan yang terbangun di tengah hutan misterius. Dari sana, kamu akan menjelajahi gua, jembatan, menara tua, sungai, dan akhirnya sampai ke pintu bercahaya yang akan menentukan akhir dari petualanganmu.
Dalam game ini terdapat 3 ending :
1. Good Ending : Jika kamu berhasil keluar dengan XP tinggi.
2. Neutral Ending : Jika kamu hanya duduk merenung
3. Bad Ending : Jika kamu kabur dan tersesat selamanya.


**PENJELASAN SETIAP SCENE DAN HUBUNGANNYA :** 
Scene 1 - Hutan Gelap 
Pilihan : 
- Masuk gua -> Scene 2
- Ikuti Jalan Setapak -> Scene 3
- Panjat Pohon -> Scene 4

Scene 2 - Gua
Pilihan : 
- Dekati cahaya -> Scene 5
- Serang bayangan -> Scene 5
- Kabur -> Kembali ke Scene 1

Scene 3 - Jembatan Rapuh
Pilihan :
- Seberangi -> Scene 6
- Cari Alternatif -> Scene 7
- Kembali -> Scene 1

Scene 4 -> Atas Pohon 
Pilihan : 
- Tandai arah -> Scene 6
- Lompat -> Scene 3
- Terjun -> Scene 1


Scene 5 -> Roh Penjaga
Pilihan
-Jawab Teka Teki -> Scene 8
- Serang Roh -> Scene 8
- Diam -> Scene 1

Scene 6 -> Menara dan makhluk Batu
Pilihan : 
- Bicara -> Scene 9
- Serang -> Scene 9
- Gunakan Lentera -> Scene 9

Scene 7 -> Sungai
Pilihan :
-Berenang -> Scene 6
- Buat Rakit -> Scene 6
- Istirahat -> Scene 6

Scene 8 -> Tiga Tombol 
Pilihan :
- Tombol Merah -> Scene 10
- Tombol Hijau -> Scene 10
- Tombol Biru -> Scene 10

Scene 9 -> Pedang Legendaris
Pilihan : 
-Ambil Pedang -> SCene 10
- Istirahat -> Scene 10
- Baca Buku -> Scene 10

Scene 10 ->  Pintu Cahaya (Final Scene)
pilihan
- Masuk Cahaya -> Good Ending
- Duduk Diam -> Neutral Ending
- Balik Kabur -> Bad ending


  **DIAGRAM ALUR(Pseudocode)**
  [Scene1]
  |-> [Scene2] -> [Scene5] -> [Scene8] -> [Scene10] -> Ending
  |-> [Scene3] -> [Scene6] -> [Scene9] -> [Scene10] -> Ending
  |-> [Scene 4] -> [Scene 3/6/1] -> Lanjut..
  |-> [Scene 7] -> [Scene 6] -> [Scene 9] -> [Scene 10] -> Ending


  **REFLEKSI**
Dalam membuat game ini mengajarkan kita banyak hal tentang :
1. Penerapan OOP yang nyata : Kita belajar bagaimana menyusun program besar menjadi beberapa class kecil yang punya tanggung jawab masing masing
2. Logika alur bercabang : Kita Menyusun struktur cerita bercabang (Branching Narrative) secara modular
3. Error Handling dan interaksi user : Kita belajar menangani input tidak valid dan memberikan umpan balik yang jelas
4. Modularisasi : Membuat sistem yang bisa dengan mudah ditambah scene baru tanpa mengubah struktur utama.

Secara keseluruhan, proyek ini menguatkan kemampuan saya dalam membangun sistem OOP dan meningkatkan pemahaman tentang struktur game interaktif
