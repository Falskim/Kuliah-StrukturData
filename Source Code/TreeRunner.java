import java.util.Scanner;

/*          Catatan
 
 Tipe data input harus integer
 
*/
public class TreeRunner {
    
    static Scanner sc = new Scanner(System.in);
    static Tree tree = new Tree();
    
    public static void main (String[] args){
       TreeRunner tr = new TreeRunner();
    }
    
    public TreeRunner(){
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
                    if(tree.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        printPreorder();
                    break;
                case 3:
                    if(tree.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        printInorder();
                    break;
                case 4:
                    if(tree.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        printPostorder();
                    break;
                case 5:
                    if(tree.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        removeData();
                    break;
                case 6:
                    if(tree.isEmpty())
                        System.out.println("Data kosong, inputkan terlebih dahulu");
                    else
                        clearTree();
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
        System.out.println("\t\t---MENU UTAMA TREE--");
        System.out.println();
        System.out.println("1)Input Data");
        System.out.println("2)Print Data Secara Preorder");
        System.out.println("3)Print Data Secara Inorder");
        System.out.println("4)Print Data Secara Postorder");
        System.out.println("5)Hapus Data");
        System.out.println("6)Hapus Semua Data");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void inputData(){
        System.out.println("\t\t---Input Data Tree---");
        System.out.println();
        System.out.print("Masukan Data : ");
        int input = sc.nextInt();
        tree.add(input);
        System.out.println("Data Berhasil Terinput");
    } 
    public void printPreorder(){
        System.out.print("Tree secara preorder : ");
        tree.printPreorder();
        System.out.println();
    }
    public void printInorder(){
        System.out.print("Tree secara inorder : ");
        tree.printInorder();
        System.out.println();
    } 
    public void printPostorder(){
        System.out.print("Tree secara Postorder : ");
        tree.printPostorder();
        System.out.println();
    }
    public void clearTree(){
        tree.clear();
        System.out.println("Tree Berhasil Terhapus");
    }
    public void removeData(){
        System.out.println("\t\t---Hapus Data Tree---");
        System.out.println();
        System.out.print("Masukan Data Yang Akan Dihapus : ");
        int key = sc.nextInt();
        boolean isPresent = (tree.search(key)!=null); //Apabila data ditemukan dalam tree
        if(isPresent){
            tree.remove(key);
            System.out.println("Data '"+key+"' berhasil dihapus");
        }else
            System.out.println("Data '"+key+"' tidak ditemukan pada tree");
    }    
}
