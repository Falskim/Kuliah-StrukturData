import java.util.*;

public class Graph {
    
    Scanner sc = new Scanner(System.in);
    private Stack<Integer> stack = new Stack<>();
    int[][] matriksNode;
    int jumlahNode, awal;
        
    public static void main(String[] args){
        Graph graph = new Graph();
    }
    
    public Graph(){
        boolean ulang;
        do{
            System.out.println("\t\t---PROGRAM DFS PADA GRAF--");
            System.out.println();
            graphInput();
            System.out.print("Depth First Search nya adalah\t: ");
            depthFirstSearch(awal);     
            System.out.println();
            garis(2);
            ulang = konfirmasiUlang();
            if(ulang)
                garis(1);
        }while(ulang);
    }
    
    public void graphInput(){
        try{
            System.out.print("Masukan Jumlah Node Pada Graf\t: ");
            jumlahNode = sc.nextInt();
            matriksNode = new int[jumlahNode+1][jumlahNode+1];
            garis(2);
            System.out.println("Masukan Matriks Node ("+jumlahNode+"x"+jumlahNode+")\t:");
            for (int i = 1; i <= jumlahNode; i++)
                for (int j = 1; j <= jumlahNode; j++)
                    matriksNode[i][j] = sc.nextInt();
            garis(2);
            System.out.print("Masukan Node Awal\t\t: ");
            awal = sc.nextInt();
        }catch(InputMismatchException inputMismatch){
            System.out.println("Format Input Salah");
        }    
    }
    
    public void depthFirstSearch(int awal){
        int jumlahNode = matriksNode[awal].length - 1;
        int[] jumlahNodeTerlewat = new int[jumlahNode+1];  
        int element = awal;  
        int i = awal;  
        System.out.print(element + "\t");  
        jumlahNodeTerlewat[awal] = 1;  
        stack.push(awal);
        while (!stack.isEmpty()){
            element = stack.peek();
            i = element; 
            while (i <= jumlahNode){
                if (matriksNode[element][i] == 1 && jumlahNodeTerlewat[i] == 0){
                    stack.push(i);
                    jumlahNodeTerlewat[i] = 1;
                    element = i;
                    i = 1;
                    System.out.print(element + "\t");
                    continue;
                }
                i++;
            }
            stack.pop(); 
        } 
    }
    
    public boolean konfirmasiUlang(){
        int ulang;
        for(;;){
            System.out.println("Apakah anda ingin mengulang ?");
            System.out.println("1)Ya");
            System.out.println("2)Tidak");
            ulang = sc.nextInt();
            switch (ulang) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Input Salah");
                    break;
            }
        }
    }
    
    public void garis(int tipe){
        for(int i=0;i<70;i++)
            if(tipe==1)
                System.out.print("=");
            else
                System.out.print("-");
        System.out.println();
    }
}