import java.util.Scanner;
/*
        Program Utama Tugas Besar Struktur Data

    Kelompok 4 :
    1)Adjie Wafi        (1177050006)
    2)Dadan             (1177050026)
    3)Fawwaz Syiham M   (1177050044)
    4)M Aldy Bakhtiar   (1177050065)
    5)Puja Naufal       (1177050090)
    
 */
/*
               Penjelasan Singkat Code

    Program ini merupakan program utama yang digunakan/dirun.
    Dengan menu yang menggunakan switch-case untuk memilih pilihan
    Seperti Sorting, Searching, dll
*/
public class TugasBesarStrukdat {
    
    /*  
        Inisialisasi variabel object awal, agar dapat
        menggunakan method/fungsi yang berada pada beda file
    */
    Scanner sc = new Scanner(System.in);
    SortSearch sortSearch;
    CollectionArrayList arrayList;
    LinkedListRunner linkedList;
    TreeRunner tree;
    HashRunner hash;
    Graph graph;
    
    public static void main(String[] args) {
        TugasBesarStrukdat utama = new TugasBesarStrukdat();
    }
    //Constructor Program Utama
    public TugasBesarStrukdat(){
        int opsiMenu; //Inisialisasi awal opsi
        do{
            mainMenu();
            opsiMenu = sc.nextInt();
            switch(opsiMenu){
                case 1:
                    garis(1);
                    sortSearch = new SortSearch();
                    break;
                case 2:
                    garis(1);
                    arrayList = new CollectionArrayList();
                    break;
                case 3:
                    garis(1);
                    linkedList = new LinkedListRunner();
                    break;
                case 4:
                    garis(1);
                    tree = new TreeRunner();
                    break;
                case 5:
                    garis(1);
                    hash = new HashRunner();
                    break;
                case 6:
                    garis(1);
                    graph = new Graph();
                    break;
                case 9:
                    garis(1);
                    groupInfo();
                    break;
                case 0:
                    break;
                default:
                    garis(2);
                    System.out.println("Input Salah");
            }
        }while(opsiMenu!=0);
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
        garis(1);
        System.out.println("\t\t<---MENU UTAMA PROGRAM-->");
        System.out.println();
        System.out.println("1)Sorting & Searching");
        System.out.println("2)Array List");
        System.out.println("3)Linked List");
        System.out.println("4)Tree");
        System.out.println("5)Hash");
        System.out.println("6)Graf");
        System.out.println();
        System.out.println("9)Informasi Kelompok");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void groupInfo(){
        System.out.println("\t\t<---INFORMASI KELOMPOK-->");
        System.out.println();
        System.out.println("1)Adjie Wafi\t\t(1177050006)");
        System.out.println("2)Dadan\t\t\t(1177050026)");
        System.out.println("3)Fawwaz Syiham M\t(1177050044)");
        System.out.println("4)M Aldy Bakhtiar\t(1177050065)");
        System.out.println("5)Puja Naufal\t\t(1177050090)");
    }
}
