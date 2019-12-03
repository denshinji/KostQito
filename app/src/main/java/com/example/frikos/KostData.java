package com.example.frikos;

import java.util.ArrayList;

public class KostData {

    private static String[][] data = new String[][]{
            {"KOS PUTRA KHORIANIZA", "https://i2.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Putra-Khorianiza.png?resize=1024%2C1024&ssl=1","Rp.7 Jt/Tahun","3 X 4","Dalam","Tunggul Hitam","-","-"},
            {"KOS PUTRA KHARISMA", "https://i2.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Putra-Kharisma.png?resize=1024%2C1024&ssl=1","Rp.15 Jt/Tahun","3 X 3","Dalam","Pasar Baru","Ada","Ada"},
            {"KOS PUTRA DELLTA", "https://i0.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Putra-Dellta.png?resize=1024%2C1024&ssl=1","Rp.7 Jt/ Tahun","3,5 X 3,5","Dalam","Gerbang Unand","-","-"},
            {"KOS PONDOKAN Hj MAK TUO", "https://i2.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Pondokan-Hj-Mak-Tuo.png?resize=1024%2C1024&ssl=1","Rp.8 Jt/ Tahun","3 X 4","Dalam","Sekitar Unand","Ada","-"},
            {"KOS PONDOKAN FADHILLA", "https://i0.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Pondokan-Fadhilla-6.png?resize=1024%2C1024&ssl=1","Rp.7 Jt/ Tahun","3 X 4","Dalam","Sekitar Unand","Ada","-"},
            {"KOS PAK YOF", "https://i2.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Pak-Yof.png?resize=1024%2C1024&ssl=1","Rp.6,5 Jt/ Tahun","3 X 4","Dalam","Pasar Baru","-","-"},
            {"KOS PAK UJANG PAUH","https://i1.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Pak-Ujang-Pauh.png?resize=1024%2C1024&ssl=1","Rp.3 Jt/ Tahun","3 X 3","Luar","Ambacang","-","-"},
            {"KOS PAK UJANG 2","https://i0.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Pak-Ujang-2.png?resize=1024%2C1024&ssl=1","Rp.7 Jt/ Tahun","3,5 X 3,5","Luar","Pasar Baru","-","-"},
            {"KOS PUTRA DA YAN", "https://i1.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Da-Yan.png?resize=1024%2C1024&ssl=1","Rp.2,5 Jt/ Tahun","3 X 3","Luar","Pasar Baru","-","-"},
            {"KOS BUK EMEN", "https://i1.wp.com/qosin.id/wp-content/uploads/2019/07/Kos-Buk-Emen.png?resize=1024%2C1024&ssl=1","Rp.5,5 Jt/ Tahun","3 X 3","Luar","Pasar Baru","-","-"},
    };

    static ArrayList<Kost> getListData(){
        ArrayList<Kost> list = new ArrayList<>();
        for (String [] aData : data){
            Kost kost = new Kost ();
            kost.setName(aData[0]);
            kost.setPhoto(aData[1]);
            kost.setHarga(aData[2]);
            kost.setUkuran(aData[3]);
            kost.setKamarmandi(aData[4]);
            kost.setAlamat(aData[5]);
            kost.setWifi(aData[6]);
            kost.setAc(aData[7]);

            list.add(kost);
        }
        return list;
    }
}
