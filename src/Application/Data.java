/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.Timer;

/**
 *
 * @author Edho
 */
public class Data {
    static String nama;
    static String mapelipa[] = {"Bahasa Indonesia", "Bahasa Inggris", "Matematika", "Fisika", "Kimia", "Biologi"};
    static String mapelips[] = {"Bahasa Indonesia", "Bahasa Inggris", "Matematika", "Sosiologi", "Geografi", "Ekonomi"};
    static int idxmapel[] = {1, 2, 3, 4, 5, 6};
    static boolean jurusanips;
    static int nilai[][] = new int[6][5];
    static float nilairata[] = new float[6];
    static float rataraport;
    static int i, j;
    static String mapel[] = new String[6];
    
    static String ProdiSaintek[] = {"Agribisnis", "Teknik Informatika", "Sistem Informasi", "Matematika", "Biologi", "Kimia", "Fisika"};
    static double PGSaintek[] = {25.34, 40.75, 38.91, 24.73, 24.91, 27.82, 22.67};
    static double PeluangSaintek[] = new double[7];
    static int idxSaintek[] = {1, 2, 3, 4, 5, 6, 7};
    
    static String ProdiSoshum[] = {"Akuntansi", "Ilmu Hubungan Internasional", "Manajemen", "Kesejahteraan Sosial", "Psikologi", "Sosiologi", "Bahasa dan Sastra Inggris", };
    static double PGSoshum[] = {41.86, 40.10, 33.45, 19.76, 34.43, 21.74, 28.91};
    static double PeluangSoshum[] = new double[7];
    static int idxSoshum[] = {1, 2, 3, 4, 5, 6, 7};
    
    //  INPUT RAPOR
    /*  Di class InputNilai.java, ada dua jenis inputan, yang pertama input nilai 5 semester buat 6 mapel satu-satu
        Yang kedua input nilai rata-rata setiap mapel. Nah dua method dibawah buat ngambil inputan dari class InputNilai.java
        terus dimasukkin ke variabel nilai[][] di atas.
    */
    public static void InputRaporNormal(boolean ips, int n1[], int n2[], int n3[], int n4[], int n5[], int n6[]) {
        Data.nilai[0] = n1;
        Data.nilai[1] = n2;
        Data.nilai[2] = n3;
        Data.nilai[3] = n4;
        Data.nilai[4] = n5;
        Data.nilai[5] = n6;
        Data.jurusanips = ips;
        
        for (i = 0; i < 6; i++) {
            Data.nilairata[i] = 0;
            Data.rataraport = 0;
        }
        
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                Data.nilairata[i] = Data.nilairata[i] + Data.nilai[i][j];
            }
            Data.nilairata[i] = Data.nilairata[i] / 5;
        }
        
        for (i = 0; i < 6; i++) {
            Data.rataraport += Data.nilairata[i];
        }
        Data.rataraport = Data.rataraport / 6;
        
        if (jurusanips) {
            Data.mapel = Data.mapelips;
        }
        else {
            Data.mapel = Data.mapelipa;
        }
        
        
        Main.lblNilaiRataRaport.setText(formatfloat(rataraport));
        
    }
    
    public static void InputRaporSimple(boolean ips, float rata[]) {
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                Data.nilai[i][j] = (int) rata[i];
            }
        }
        Data.jurusanips = ips;
        Data.nilairata = rata;
        
        for (i = 0; i < 6; i++) {
            Data.rataraport += Data.nilairata[i];
        }
        Data.rataraport = Data.rataraport / 6;
        
        if (jurusanips) {
            Data.mapel = Data.mapelips;
        }
        else {
            Data.mapel = Data.mapelipa;
        }
        
        
        Main.lblNilaiRataRaport.setText(formatfloat(rataraport));
    }
    
    
    //  TAMPILKAN RAPOR
    /*  Method di bawah buat nampilin nilai raport setiap semester beserta graphnya di Panel Cek Raport di class Main.java.
    */
    public static void TampilRapor() {
        Main.lblMapel1.setText(mapel[0]);
        Main.lblMapel2.setText(mapel[1]);
        Main.lblMapel3.setText(mapel[2]);
        Main.lblMapel4.setText(mapel[3]);
        Main.lblMapel5.setText(mapel[4]);
        Main.lblMapel6.setText(mapel[5]);
        
        Main.lblRataMapel1.setText(Float.toString(nilairata[0]));
        Main.lblRataMapel2.setText(Float.toString(nilairata[1]));
        Main.lblRataMapel3.setText(Float.toString(nilairata[2]));
        Main.lblRataMapel4.setText(Float.toString(nilairata[3]));
        Main.lblRataMapel5.setText(Float.toString(nilairata[4]));
        Main.lblRataMapel6.setText(Float.toString(nilairata[5]));
        
        Main.grpMapel1S1.setText(Integer.toString(nilai[0][0]));
        Main.grpMapel1S2.setText(Integer.toString(nilai[0][1]));
        Main.grpMapel1S3.setText(Integer.toString(nilai[0][2]));
        Main.grpMapel1S4.setText(Integer.toString(nilai[0][3]));
        Main.grpMapel1S5.setText(Integer.toString(nilai[0][4]));
        
        Main.grpMapel2S1.setText(Integer.toString(nilai[1][0]));
        Main.grpMapel2S2.setText(Integer.toString(nilai[1][1]));
        Main.grpMapel2S3.setText(Integer.toString(nilai[1][2]));
        Main.grpMapel2S4.setText(Integer.toString(nilai[1][3]));
        Main.grpMapel2S5.setText(Integer.toString(nilai[1][4]));
        
        Main.grpMapel3S1.setText(Integer.toString(nilai[2][0]));
        Main.grpMapel3S2.setText(Integer.toString(nilai[2][1]));
        Main.grpMapel3S3.setText(Integer.toString(nilai[2][2]));
        Main.grpMapel3S4.setText(Integer.toString(nilai[2][3]));
        Main.grpMapel3S5.setText(Integer.toString(nilai[2][4]));
        
        Main.grpMapel4S1.setText(Integer.toString(nilai[3][0]));
        Main.grpMapel4S2.setText(Integer.toString(nilai[3][1]));
        Main.grpMapel4S3.setText(Integer.toString(nilai[3][2]));
        Main.grpMapel4S4.setText(Integer.toString(nilai[3][3]));
        Main.grpMapel4S5.setText(Integer.toString(nilai[3][4]));
        
        Main.grpMapel5S1.setText(Integer.toString(nilai[4][0]));
        Main.grpMapel5S2.setText(Integer.toString(nilai[4][1]));
        Main.grpMapel5S3.setText(Integer.toString(nilai[4][2]));
        Main.grpMapel5S4.setText(Integer.toString(nilai[4][3]));
        Main.grpMapel5S5.setText(Integer.toString(nilai[4][4]));
        
        Main.grpMapel6S1.setText(Integer.toString(nilai[5][0]));
        Main.grpMapel6S2.setText(Integer.toString(nilai[5][1]));
        Main.grpMapel6S3.setText(Integer.toString(nilai[5][2]));
        Main.grpMapel6S4.setText(Integer.toString(nilai[5][3]));
        Main.grpMapel6S5.setText(Integer.toString(nilai[5][4]));
        
        Main.grpMapel1S1.setBorder(Data.GraphBorder(nilai[0][0]));
        Main.grpMapel1S2.setBorder(Data.GraphBorder(nilai[0][1]));
        Main.grpMapel1S3.setBorder(Data.GraphBorder(nilai[0][2]));
        Main.grpMapel1S4.setBorder(Data.GraphBorder(nilai[0][3]));
        Main.grpMapel1S5.setBorder(Data.GraphBorder(nilai[0][4]));
        
        Main.grpMapel2S1.setBorder(Data.GraphBorder(nilai[1][0]));
        Main.grpMapel2S2.setBorder(Data.GraphBorder(nilai[1][1]));
        Main.grpMapel2S3.setBorder(Data.GraphBorder(nilai[1][2]));
        Main.grpMapel2S4.setBorder(Data.GraphBorder(nilai[1][3]));
        Main.grpMapel2S5.setBorder(Data.GraphBorder(nilai[1][4]));
        
        Main.grpMapel3S1.setBorder(Data.GraphBorder(nilai[2][0]));
        Main.grpMapel3S2.setBorder(Data.GraphBorder(nilai[2][1]));
        Main.grpMapel3S3.setBorder(Data.GraphBorder(nilai[2][2]));
        Main.grpMapel3S4.setBorder(Data.GraphBorder(nilai[2][3]));
        Main.grpMapel3S5.setBorder(Data.GraphBorder(nilai[2][4]));
        
        Main.grpMapel4S1.setBorder(Data.GraphBorder(nilai[3][0]));
        Main.grpMapel4S2.setBorder(Data.GraphBorder(nilai[3][1]));
        Main.grpMapel4S3.setBorder(Data.GraphBorder(nilai[3][2]));
        Main.grpMapel4S4.setBorder(Data.GraphBorder(nilai[3][3]));
        Main.grpMapel4S5.setBorder(Data.GraphBorder(nilai[3][4]));
        
        Main.grpMapel5S1.setBorder(Data.GraphBorder(nilai[4][0]));
        Main.grpMapel5S2.setBorder(Data.GraphBorder(nilai[4][1]));
        Main.grpMapel5S3.setBorder(Data.GraphBorder(nilai[4][2]));
        Main.grpMapel5S4.setBorder(Data.GraphBorder(nilai[4][3]));
        Main.grpMapel5S5.setBorder(Data.GraphBorder(nilai[4][4]));
        
        Main.grpMapel6S1.setBorder(Data.GraphBorder(nilai[5][0]));
        Main.grpMapel6S2.setBorder(Data.GraphBorder(nilai[5][1]));
        Main.grpMapel6S3.setBorder(Data.GraphBorder(nilai[5][2]));
        Main.grpMapel6S4.setBorder(Data.GraphBorder(nilai[5][3]));
        Main.grpMapel6S5.setBorder(Data.GraphBorder(nilai[5][4]));
    }
    
    
    //  UBAH RAPOR
    /*  Methode di bawah fungsinya hampir sama kayak methode input rapor di atas, yang bedain cuma ini nggak
        nge-assign tipe jurusan
    */
    public static void UbahRapor(int n1[], int n2[], int n3[], int n4[], int n5[], int n6[]) {
        Data.nilai[0] = n1;
        Data.nilai[1] = n2;
        Data.nilai[2] = n3;
        Data.nilai[3] = n4;
        Data.nilai[4] = n5;
        Data.nilai[5] = n6;
        
        for (i = 0; i < 6; i++) {
            Data.nilairata[i] = 0;
            Data.rataraport = 0;
        }
        
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                Data.nilairata[i] = Data.nilairata[i] + Data.nilai[i][j];
            }
            Data.nilairata[i] = Data.nilairata[i] / 5;
        }
        
        for (i = 0; i < 6; i++) {
            Data.rataraport += Data.nilairata[i];
        }
        Data.rataraport = Data.rataraport / 6;
        
        if (jurusanips) {
            Data.mapel = Data.mapelips;
        }
        else {
            Data.mapel = Data.mapelipa;
        }
        
        Main.lblNilaiRataRaport.setText(formatfloat(rataraport));
        
    }
    
    
    //  PANGGIL RAPOR
    /*  Methode ini gunanya buat nampilin data-data nilai rapor yang sebelumnya udah dimasukkin biar bisa di ubah.
        Methode ini harus dipake kalo pengen ubah nilai rapor.
    */
    public static void PanggilRapor() {
        SortRaporNormal();
        
        if (jurusanips) {
            Main.lblMinat1.setText(mapelips[3]);
            Main.lblMinat2.setText(mapelips[4]);
            Main.lblMinat3.setText(mapelips[5]);
        }
        else {
            Main.lblMinat1.setText(mapelipa[3]);
            Main.lblMinat2.setText(mapelipa[4]);
            Main.lblMinat3.setText(mapelipa[5]);
        }
        
        Main.txtBindo1.setText(Integer.toString(nilai[0][0]));
        Main.txtBindo2.setText(Integer.toString(nilai[0][1]));
        Main.txtBindo3.setText(Integer.toString(nilai[0][2]));
        Main.txtBindo4.setText(Integer.toString(nilai[0][3]));
        Main.txtBindo5.setText(Integer.toString(nilai[0][4]));
        
        Main.txtBing1.setText(Integer.toString(nilai[1][0]));
        Main.txtBing2.setText(Integer.toString(nilai[1][1]));
        Main.txtBing3.setText(Integer.toString(nilai[1][2]));
        Main.txtBing4.setText(Integer.toString(nilai[1][3]));
        Main.txtBing5.setText(Integer.toString(nilai[1][4]));
        
        Main.txtMTK1.setText(Integer.toString(nilai[2][0]));
        Main.txtMTK2.setText(Integer.toString(nilai[2][1]));
        Main.txtMTK3.setText(Integer.toString(nilai[2][2]));
        Main.txtMTK4.setText(Integer.toString(nilai[2][3]));
        Main.txtMTK5.setText(Integer.toString(nilai[2][4]));
        
        Main.txtMinat11.setText(Integer.toString(nilai[3][0]));
        Main.txtMinat12.setText(Integer.toString(nilai[3][1]));
        Main.txtMinat13.setText(Integer.toString(nilai[3][2]));
        Main.txtMinat14.setText(Integer.toString(nilai[3][3]));
        Main.txtMinat15.setText(Integer.toString(nilai[3][4]));
        
        Main.txtMinat21.setText(Integer.toString(nilai[4][0]));
        Main.txtMinat22.setText(Integer.toString(nilai[4][1]));
        Main.txtMinat23.setText(Integer.toString(nilai[4][2]));
        Main.txtMinat24.setText(Integer.toString(nilai[4][3]));
        Main.txtMinat25.setText(Integer.toString(nilai[4][4]));
        
        Main.txtMinat31.setText(Integer.toString(nilai[5][0]));
        Main.txtMinat32.setText(Integer.toString(nilai[5][1]));
        Main.txtMinat33.setText(Integer.toString(nilai[5][2]));
        Main.txtMinat34.setText(Integer.toString(nilai[5][3]));
        Main.txtMinat35.setText(Integer.toString(nilai[5][4]));
    }

    
    //  SORT RAPOR
    /*  3 Methode di bawah buat ngurutin nilai rapor berdasarkan nilai RATA-RATA MATA PELAJARAN,
        Methode SortRaportNormal() fungsinya buat balikin urutan ke semula.
    */
    public static void SortRaporAsc() {
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                if (nilairata[j+1] < nilairata[j]) {
                    
                    int tempind = idxmapel[j+1];
                    idxmapel[j+1] = idxmapel[j];
                    idxmapel[j] = tempind;
                    
                    String tempmapel = mapel[j+1];
                    mapel[j+1] = mapel[j];
                    mapel[j] = tempmapel;

                    for (int k = 0; k < 5; k++) {
                        int tempnilai = nilai[j+1][k];
                        nilai[j+1][k] = nilai[j][k];
                        nilai[j][k] = tempnilai;
                    }

                    float temprata = nilairata[j+1];
                    nilairata[j+1] = nilairata[j];
                    nilairata[j] = temprata;
                }
            }
        }
    }
    
    public static void SortRaporDesc() {
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                if (nilairata[j+1] > nilairata[j]) {
                    
                    int tempind = idxmapel[j+1];
                    idxmapel[j+1] = idxmapel[j];
                    idxmapel[j] = tempind;
                    
                    String tempmapel = mapel[j+1];
                    mapel[j+1] = mapel[j];
                    mapel[j] = tempmapel;

                    for (int k = 0; k < 5; k++) {
                        int tempnilai = nilai[j+1][k];
                        nilai[j+1][k] = nilai[j][k];
                        nilai[j][k] = tempnilai;
                    }

                    float temprata = nilairata[j+1];
                    nilairata[j+1] = nilairata[j];
                    nilairata[j] = temprata;
                }
            }
        }
    }
    
    public static void SortRaporNormal() {
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 5; j++) {
                if (idxmapel[j+1] < idxmapel[j]) {
                    
                    int tempind = idxmapel[j+1];
                    idxmapel[j+1] = idxmapel[j];
                    idxmapel[j] = tempind;
                    
                    String tempmapel = mapel[j+1];
                    mapel[j+1] = Data.mapel[j];
                    mapel[j] = tempmapel;

                    for (int k = 0; k < 5; k++) {
                        int tempnilai = nilai[j+1][k];
                        nilai[j+1][k] = Data.nilai[j][k];
                        nilai[j][k] = tempnilai;
                    }

                    float temprata = nilairata[j+1];
                    nilairata[j+1] = nilairata[j];
                    nilairata[j] = temprata;
                }
            }
        }
    }
    
    
    //  TAMPIL PRODI
    /*  2 Methode ini gunanya hampir sama kayak methode TampilRapor di atas, cuma ini nampilin nama-nama prodi
        beserta passing gradenya di panel ListProdi.
    */
    public static void TampilProdiSaintek() {
        Main.lblProdiSaintek1.setText(ProdiSaintek[0]);
        Main.lblProdiSaintek2.setText(ProdiSaintek[1]);
        Main.lblProdiSaintek3.setText(ProdiSaintek[2]);
        Main.lblProdiSaintek4.setText(ProdiSaintek[3]);
        Main.lblProdiSaintek5.setText(ProdiSaintek[4]);
        Main.lblProdiSaintek6.setText(ProdiSaintek[5]);
        Main.lblProdiSaintek7.setText(ProdiSaintek[6]);
        
        Main.lblPGSaintek1.setText(Double.toString(PGSaintek[0]) + "%");
        Main.lblPGSaintek2.setText(Double.toString(PGSaintek[1]) + "%");
        Main.lblPGSaintek3.setText(Double.toString(PGSaintek[2]) + "%");
        Main.lblPGSaintek4.setText(Double.toString(PGSaintek[3]) + "%");
        Main.lblPGSaintek5.setText(Double.toString(PGSaintek[4]) + "%");
        Main.lblPGSaintek6.setText(Double.toString(PGSaintek[5]) + "%");
        Main.lblPGSaintek7.setText(Double.toString(PGSaintek[6]) + "%");
    }
    
    public static void TampilProdiSoshum() {
        Main.lblProdiSoshum1.setText(ProdiSoshum[0]);
        Main.lblProdiSoshum2.setText(ProdiSoshum[1]);
        Main.lblProdiSoshum3.setText(ProdiSoshum[2]);
        Main.lblProdiSoshum4.setText(ProdiSoshum[3]);
        Main.lblProdiSoshum5.setText(ProdiSoshum[4]);
        Main.lblProdiSoshum6.setText(ProdiSoshum[5]);
        Main.lblProdiSoshum7.setText(ProdiSoshum[6]);
        
        Main.lblPGSoshum1.setText(Double.toString(PGSoshum[0]) + "%");
        Main.lblPGSoshum2.setText(Double.toString(PGSoshum[1]) + "%");
        Main.lblPGSoshum3.setText(Double.toString(PGSoshum[2]) + "%");
        Main.lblPGSoshum4.setText(Double.toString(PGSoshum[3]) + "%");
        Main.lblPGSoshum5.setText(Double.toString(PGSoshum[4]) + "%");
        Main.lblPGSoshum6.setText(Double.toString(PGSoshum[5]) + "%");
        Main.lblPGSoshum7.setText(Double.toString(PGSoshum[6]) + "%");
    }
    
    
    //  SORT PRODI
    /*  Gunanya buat ngurutin prodi-prodi yang ada berdasarkan Nama, atau persentase passing grade.
        Sort Normal buat balikin ke urutan semula.
    */
    public static void SortProdiSaintekNamaDesc(){
        for(i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if(ProdiSaintek[j+1].compareTo(ProdiSaintek[j])>0) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSaintekNamaAsc(){
        for(i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if(ProdiSaintek[j+1].compareTo(ProdiSaintek[j])<=0) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSaintekPGAsc() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PGSaintek[j+1] < PGSaintek[j]) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSaintekPGDesc() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PGSaintek[j+1] > PGSaintek[j]) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSaintekNormal() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (idxSaintek[j+1] < idxSaintek[j]) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSoshumNamaDesc(){
        for(i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if(ProdiSoshum[j+1].compareTo(ProdiSoshum[j])>0) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSoshum[j+1];
                    PGSoshum[j+1] = PGSoshum[j];
                    PGSoshum[j] = tempPG;

                    int tempidx = idxSoshum[j+1];
                    idxSoshum[j+1] = idxSoshum[j];
                    idxSoshum[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSoshumNamaAsc(){
        for(i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if(ProdiSoshum[j+1].compareTo(ProdiSoshum[j])<=0) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSoshum[j+1];
                    PGSoshum[j+1] = PGSoshum[j];
                    PGSoshum[j] = tempPG;

                    int tempidx = idxSoshum[j+1];
                    idxSoshum[j+1] = idxSoshum[j];
                    idxSoshum[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSoshumPGAsc() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PGSoshum[j+1] < PGSoshum[j]) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSoshum[j+1];
                    PGSoshum[j+1] = PGSoshum[j];
                    PGSoshum[j] = tempPG;

                    int tempidx = idxSoshum[j+1];
                    idxSoshum[j+1] = idxSoshum[j];
                    idxSoshum[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSoshumPGDesc() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PGSoshum[j+1] > PGSoshum[j]) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSoshum[j+1];
                    PGSoshum[j+1] = PGSoshum[j];
                    PGSoshum[j] = tempPG;

                    int tempidx = idxSoshum[j+1];
                    idxSoshum[j+1] = idxSoshum[j];
                    idxSoshum[j] = tempidx;
                }
            }
        }
    }
    
    public static void SortProdiSoshumNormal() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (idxSoshum[j+1] < idxSoshum[j]) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                }
            }
        }
    }
    
    
    //  TAMPIL PILIHAN PRODI
    /*  Ini fungsinya buat nampilin pilihan-pilihan prodi yang bisa dipilih berdasarkan jurusan yang dipilih dari awal
        Yang milih MIPA cuma dapet prodi saintek, yang pilih IPS cuma dapet prodi soshum.
        Ini listnya ditampilin di panel Prediksi.
    */
    public static void TampilPilihanProdi() {
        SortProdiSaintekNormal();
        SortProdiSoshumNormal();
        
        SortRaporDesc();
        
        Main.lblMapelUnggulan.setText(Data.mapel[0]);
        
        if(jurusanips) {
            Main.swtchProdi1.setText(ProdiSoshum[0]);
            Main.swtchProdi2.setText(ProdiSoshum[1]);
            Main.swtchProdi3.setText(ProdiSoshum[2]);
            Main.swtchProdi4.setText(ProdiSoshum[3]);
            Main.swtchProdi5.setText(ProdiSoshum[4]);
            Main.swtchProdi6.setText(ProdiSoshum[5]);
            Main.swtchProdi7.setText(ProdiSoshum[6]);
        }
        else {
            Main.swtchProdi1.setText(ProdiSaintek[0]);
            Main.swtchProdi2.setText(ProdiSaintek[1]);
            Main.swtchProdi3.setText(ProdiSaintek[2]);
            Main.swtchProdi4.setText(ProdiSaintek[3]);
            Main.swtchProdi5.setText(ProdiSaintek[4]);
            Main.swtchProdi6.setText(ProdiSaintek[5]);
            Main.swtchProdi7.setText(ProdiSaintek[6]);
        }
        
    }
    
    
    //  PREDICT
    /*  Ngitung peluang lolos SNMPTN di masing-masing prodi berdasar nilai rapor
        yang udah diinput sama pilihan kota (jakarta atau luar). Jadi bukan prodi yang dipilih doang yang dihitung,
        tapi semua prodi
    */
    public static void Predict(int Kota) {
        Data.SortRaporNormal();
        Data.SortProdiSaintekNormal();
        Data.SortProdiSoshumNormal();
        
        PeluangSaintek[0] = (0.8 * PGSaintek[0]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[0]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.16) + (nilairata[1] * 0.16) + (nilairata[2]) * 0.16) + (nilairata[3] * 0.16) + (nilairata[4] * 0.16) + (nilairata[5] * 0.20))));
        PeluangSaintek[1] = (0.8 * PGSaintek[1]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[1]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.15) + (nilairata[1] * 0.15) + (nilairata[2]) * 0.20) + (nilairata[3] * 0.20) + (nilairata[4] * 0.15) + (nilairata[5] * 0.15))));
        PeluangSaintek[2] = (0.8 * PGSaintek[2]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[2]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.16) + (nilairata[1] * 0.16) + (nilairata[2]) * 0.20) + (nilairata[3] * 0.16) + (nilairata[4] * 0.16) + (nilairata[5] * 0.15))));
        PeluangSaintek[3] = (0.8 * PGSaintek[3]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[3]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.30) + (nilairata[3] * 0.14) + (nilairata[4] * 0.14) + (nilairata[5] * 0.14))));
        PeluangSaintek[4] = (0.8 * PGSaintek[4]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[4]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.14) + (nilairata[4] * 0.14) + (nilairata[5] * 0.40))));
        PeluangSaintek[5] = (0.8 * PGSaintek[5]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[5]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.14) + (nilairata[4] * 0.30) + (nilairata[5] * 0.14))));
        PeluangSaintek[6] = (0.8 * PGSaintek[6]) + (10 * Kota) + (((100 - (0.8 * PGSaintek[6]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.30) + (nilairata[4] * 0.14) + (nilairata[5] * 0.14))));
        
        PeluangSoshum[0] = (0.8 * PGSoshum[0]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[0]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.13) + (nilairata[1] * 0.13) + (nilairata[2]) * 0.24) + (nilairata[3] * 0.13) + (nilairata[4] * 0.13) + (nilairata[5] * 0.24))));
        PeluangSoshum[1] = (0.8 * PGSoshum[1]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[1]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.30) + (nilairata[4] * 0.14) + (nilairata[5] * 0.14))));
        PeluangSoshum[2] = (0.8 * PGSoshum[2]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[2]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.15) + (nilairata[1] * 0.15) + (nilairata[2]) * 0.15) + (nilairata[3] * 0.15) + (nilairata[4] * 0.15) + (nilairata[5] * 0.25))));
        PeluangSoshum[3] = (0.8 * PGSoshum[3]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[3]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.30) + (nilairata[4] * 0.14) + (nilairata[5] * 0.14))));
        PeluangSoshum[4] = (0.8 * PGSoshum[4]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[4]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.15) + (nilairata[1] * 0.10) + (nilairata[2]) * 0.10) + (nilairata[3] * 0.25) + (nilairata[4] * 0.10) + (nilairata[5] * 0.10))));
        PeluangSoshum[5] = (0.8 * PGSoshum[5]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[5]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.14) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.30) + (nilairata[4] * 0.14) + (nilairata[5] * 0.10))));
        PeluangSoshum[6] = (0.8 * PGSoshum[6]) + (10 * Kota) + (((100 - (0.8 * PGSoshum[6]) - (10 * Kota)) * 0.01 * (((nilairata[0] * 0.14) + (nilairata[1] * 0.30) + (nilairata[2]) * 0.14) + (nilairata[3] * 0.14) + (nilairata[4] * 0.14) + (nilairata[5] * 0.14))));
    }
    
    //  SORT PELUANG
    /*  Ngurutin peluang lolos prodi-prodi dari besar ke kecil, buat ditampilin di 'Top 3 Prodi' di panel Hasil.
    */
    public static void SortPeluangSoshum() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PeluangSoshum[j+1] > PeluangSoshum[j]) {
                    String tempprodi = ProdiSoshum[j+1];
                    ProdiSoshum[j+1] = ProdiSoshum[j];
                    ProdiSoshum[j] = tempprodi;

                    double tempPG = PGSoshum[j+1];
                    PGSoshum[j+1] = PGSoshum[j];
                    PGSoshum[j] = tempPG;

                    int tempidx = idxSoshum[j+1];
                    idxSoshum[j+1] = idxSoshum[j];
                    idxSoshum[j] = tempidx;
                    
                    double temppeluang = PeluangSoshum[j+1];
                    PeluangSoshum[j+1] = PeluangSoshum[j];
                    PeluangSoshum[j] = temppeluang;
                }
            }
        }
    }
    
    public static void SortPeluangSaintek() {
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {
                if (PeluangSaintek[j+1] > PeluangSaintek[j]) {
                    String tempprodi = ProdiSaintek[j+1];
                    ProdiSaintek[j+1] = ProdiSaintek[j];
                    ProdiSaintek[j] = tempprodi;

                    double tempPG = PGSaintek[j+1];
                    PGSaintek[j+1] = PGSaintek[j];
                    PGSaintek[j] = tempPG;

                    int tempidx = idxSaintek[j+1];
                    idxSaintek[j+1] = idxSaintek[j];
                    idxSaintek[j] = tempidx;
                    
                    double temppeluang = PeluangSaintek[j+1];
                    PeluangSaintek[j+1] = PeluangSaintek[j];
                    PeluangSaintek[j] = temppeluang;
                }
            }
        }
    }
    
    
    //  TAMPIL PELUANG
    /*  Buat tampilin peluang dari prodi yang dipilih + 3 prodi yang peluangnya teratas
    */
    public static void TampilPeluang(int pilihan) {
        if (jurusanips) {
            Main.lblProdiTerpilih.setText(ProdiSoshum[pilihan]);
            Main.lblPeluang.setText(formatdouble(PeluangSoshum[pilihan]) + "%");
            SortPeluangSoshum();
            Main.lblProdiSaran1.setText(ProdiSoshum[0]);
            Main.lblProdiSaran2.setText(ProdiSoshum[1]);
            Main.lblProdiSaran3.setText(ProdiSoshum[2]);
            Main.lblPeluangSaran1.setText(formatdouble(PeluangSoshum[0]) + "%");
            Main.lblPeluangSaran2.setText(formatdouble(PeluangSoshum[1]) + "%");
            Main.lblPeluangSaran3.setText(formatdouble(PeluangSoshum[2]) + "%");
        }
        else {
            Main.lblProdiTerpilih.setText(ProdiSaintek[pilihan]);
            Main.lblPeluang.setText(formatdouble(PeluangSaintek[pilihan]) + "%");
            SortPeluangSaintek();
            Main.lblProdiSaran1.setText(ProdiSaintek[0]);
            Main.lblProdiSaran2.setText(ProdiSaintek[1]);
            Main.lblProdiSaran3.setText(ProdiSaintek[2]);
            Main.lblPeluangSaran1.setText(formatdouble(PeluangSaintek[0]) + "%");
            Main.lblPeluangSaran2.setText(formatdouble(PeluangSaintek[1]) + "%");
            Main.lblPeluangSaran3.setText(formatdouble(PeluangSaintek[2]) + "%");
        }
    }
    
    // =============UI/UX AREA ============
    
    //  GRAPH BORDER
    /*  Buat bikin grafik/diagram di panel CekRaport
    */
    public static Border GraphBorder(int n) {
        Border graph = BorderFactory.createMatteBorder(n, 0, 0, 0, Color.white);
        return graph;
    }
    
    
    //  SELECTED AND UNSELECTED STYLE
    /*  Method buat ngehasilin Border bawah + background dari tombol option, tombol biasa, sama jtextfield
        Ini yang bikin tombol berubah warna kalo di sorot/diklik
    */
    public static Border OptionSelected() {
        Border graph = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white);
        return graph;
    }

    public static Border OptionUnselected() {
        Border graph = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white);
        return graph;
    }
    
    public static Color OptionBgSelected() {
        return new Color(15,100,160);
    }
    
    public static Color OptionBgClicked() {
        return new Color(20,110,175);
    }
    
    public static Color OptionBgUnselected() {
        return new Color(10,90,150);
    }
    
    public static Color ButtonBgHovered() {
        return new Color(30,130,200);
    }
    
    public static Color ButtonBgUnhovered() {
        return new Color(20,110,175);
    }
    
    public static Color ButtonBgClicked() {
        return new Color(25,120,187);
    }
    
    public static Border TextFieldSelected() {
        Border graph = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white);
        return graph;
    }
    
    public static Border TextFieldUnselected() {
        Border graph = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
        return graph;
    }
    
    //  FORMAT NUMBER
    /*  Buat pendekkin angka double dan float jadi 3 angka di belakang koma
    */
    public static String formatdouble(double i) {
        DecimalFormat format = new DecimalFormat("#.###");
        return format.format(i);
    }
    
    public static String formatfloat(float i) {
        DecimalFormat format = new DecimalFormat("#.###");
        return format.format(i);
    }
    
    //  TIMER
    /*  Timer buat konfirmasi pembatalan pengubahan data rapor di panel UbahNilai rapor
    */
    static Timer confirmation = new Timer(3000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Main.swtchBackEdit.setSelected(false);
            Main.swtchBackEdit.setText("BATALKAN");
        }
    });
    
}