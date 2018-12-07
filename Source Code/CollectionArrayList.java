import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionArrayList {
    
    ArrayList<String> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public static void main (String[] args){
       CollectionArrayList cal = new CollectionArrayList();
    }
    public CollectionArrayList(){
        int opsiMenu;
        do{
            mainMenu();
            opsiMenu = sc.nextInt();
            if(opsiMenu!=0) //Agar jika 0 tidak mengoutputkan garis
                garis(2);
            switch(opsiMenu){
                case 1:
                    inputData();
                    break;
                case 2:
                    if(list.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        printData();
                    break;
                case 3:
                    if(list.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        sortData();
                    break;
                case 4:
                    if(list.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        shuffleData();
                    break;
                case 5:
                    if(list.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        clearData();
                    break;    
                case 0:
                    return;
                default:
                    System.out.println("Input Salah");
            }
            garis(1);
        }while(opsiMenu != 0);
    }
    public void garis(int tipe){
        for(int i=0;i<70;i++)
            if(tipe==1)
                System.out.print("=");
            else
                System.out.print("-");
        System.out.println();
    }
    public void mainMenu(){
        System.out.println("\t\t---MENU UTAMA COLLECTIONS ARRAY LIST--");
        System.out.println();
        System.out.println("1)Input Data");
        System.out.println("2)Tampilkan Semua Data");
        System.out.println("3)Sort Data");
        System.out.println("4)Acak Urutan Data");
        System.out.println("5)Hapus Semua Data");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void inputData(){
        System.out.println("\t\t---Input Data Collections Array List---");
        System.out.println();
        System.out.print("Masukan Data : ");
        String input = sc.next();
        list.add(input);
        System.out.println("Data Berhasil Terinput");
    }
    public void printData(){
        System.out.println("\t\t---Daftar Data Collections Array List---");
        System.out.println();
        for(int i=0;i<list.size();i++){
            System.out.println((i+1)+")"+list.get(i));
        }
    }
    public void sortData(){
        Collections.sort(list);
        System.out.println("Data Berhasil Tersorting");
    }
    public void shuffleData(){
        Collections.shuffle(list);
        System.out.println("Urutan Data Berhasil Teracak");
    }
    public void clearData(){
        list.clear();
        System.out.println("Data Berhasil Terhapus");
    }
}
