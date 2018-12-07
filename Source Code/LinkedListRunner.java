import java.util.Scanner;

public class LinkedListRunner {
    
    Scanner sc = new Scanner(System.in);
    LinkedList<String> list = new LinkedList<>();
    
    public static void main(String[] args){
        LinkedListRunner llr = new LinkedListRunner();
    }
    
    public LinkedListRunner(){
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
                        removeData();
                    break;
                case 4:
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
        System.out.println("\t\t---MENU UTAMA LINKED LIST--");
        System.out.println();
        System.out.println("1)Input Data");
        System.out.println("2)Tampilkan Semua Data");
        System.out.println("3)Hapus Data");
        System.out.println("4)Hapus Semua Data");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void inputData(){
        System.out.println("\t\t---Input Data Linked List---");
        System.out.println();
        System.out.print("Masukan Data : ");
        String input = sc.next();
        list.add(input);
        System.out.println("Data Berhasil Terinput");
    } 
    public void printData(){
        System.out.println("\t\t---Print Data Linked List---");
        System.out.println();
        System.out.print("Data Linked List : ");
        list.printAll();
    }
    public void removeData(){
        System.out.println("\t\t---Hapus Data Linked List---");
        System.out.println();
        System.out.print("Masukan Urutan Data Yang Akan Dihapus : ");
        int index = sc.nextInt();
        list.remove(index);
        System.out.println("Data Berhasil Dihapus");
    }  
    public void clearData(){
        list.clear();
        System.out.println("Semua Data Berhasil Terhapus");
    }
    
}
