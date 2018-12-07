import java.util.Scanner;

public class HashRunner {
    
    Scanner sc = new Scanner(System.in);
    Hash hash;
    
    public static void main (String[] args){
       HashRunner hr = new HashRunner();
    }
    
    public HashRunner(){
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
                    if(isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        printData();
                    break;
                case 3:
                    if(isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        searchData();
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
        System.out.println("\t\t---MENU UTAMA HASH--");
        System.out.println();
        System.out.println("1)Input Data");
        System.out.println("2)Tampilkan Semua Data");
        System.out.println("3)Cari berdasarkan keyword");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void inputData(){
        System.out.println("\t\t---Input Data Hash---");
        System.out.println();
        System.out.print("Masukan banyak data yang akan anda masukan : ");
        int n = sc.nextInt();
        hash = new Hash(n);
        for(int i=0;i<n;i++){
            System.out.print("Masukan Data Ke-"+(i+1)+" : ");
            String input = sc.next();
            hash.add(input);
        }
        System.out.println("Semua Data Berhasil Terinput");
    } 
    public void printData(){
        System.out.println("\t\t\t---Daftar Data Hash---");
        System.out.println();
        System.out.println("Index   Data            Kode Hash");
        hash.print();
    }
    public void searchData(){
        System.out.println("\t\t\t---Cari Keyword Data Hash---");
        System.out.println();
        System.out.print("Masukan Keyword : ");
        String key = sc.next();
        System.out.println();
        System.out.println("\t\t\t---Data Yang Ditemukan---");
        System.out.println("Index   Data            Kode Hash");
        hash.search(key);
    }
    private boolean isEmpty(){
        return hash == null;
    }
    
}