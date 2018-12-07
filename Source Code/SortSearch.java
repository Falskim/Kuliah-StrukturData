import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortSearch {
    
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    
    public static void main (String[] args){
       SortSearch ss = new SortSearch();
    }
    
    public SortSearch(){
        int opsiMenu;
        do{
            mainMenu();
            opsiMenu = sc.nextInt();
            if(opsiMenu!=0) //Agar jika 0 tidak mengoutputkan garis
                garis(2);
            switch(opsiMenu){
                case 1:
                    setArraySize();
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
                        sortData();
                    break;
                case 4:
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
        System.out.println("\t\t---MENU UTAMA SORTING DAN SEARCHING--");
        System.out.println();
        System.out.println("1)Atur Banyak Data");
        System.out.println("2)Tampilkan Semua Data");
        System.out.println("3)Sort Data");
        System.out.println("4)Search Data");
        System.out.println();
        System.out.println("0)Keluar");
        System.out.println();
        System.out.print("Masukan pilihan\t: ");
    }
    public void setArraySize(){
        System.out.println("\t\t---Input Jumlah Data---");
        System.out.println();
        System.out.print("Masukan Banyak Data : ");
        int input = sc.nextInt();
        arr = new int[input];
        randomizer(arr);
        System.out.println("Sebuah Array Terdiri Dari "+input+" Angka Berhasil Dibuat");
    }
    //Merandom isi nilai array
    public void randomizer(int[] x){
        for(int i=0;i<x.length;i++){
            arr[i]=new Random().nextInt(100)+1;
        }
    }
    //Mencetak Array
    public void printData(){
        System.out.println("\t\t---Print Isi Array---");
        System.out.println();
        System.out.println("Isi Array : "+Arrays.toString(arr));
    }
    //Sorting Menggunakan Metode QuickSort
    public void sortData(){
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length-1);
        System.out.println("Data Berhasil Tersorting");
    }
    
    //Nyari di internet, bukan aku yang ngoding
    //https://www.geeksforgeeks.org/quick-sort/
    class QuickSort{
        int partition(int arr[], int low, int high){ 
            int pivot = arr[high];  
            int i = (low-1); // index of smaller element 
            for (int j=low; j<high; j++){ 
                // If current element is smaller than or 
                // equal to pivot 
                if (arr[j] <= pivot){ 
                    i++; 
                    // swap arr[i] and arr[j] 
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                } 
            } 
            // swap arr[i+1] and arr[high] (or pivot) 
            int temp = arr[i+1]; 
            arr[i+1] = arr[high]; 
            arr[high] = temp; 
            return i+1; 
        } 
        /* The main function that implements QuickSort() 
          arr[] --> Array to be sorted, 
          low  --> Starting index, 
          high  --> Ending index */
        void sort(int arr[], int low, int high){ 
            if (low < high){ 
                /* pi is partitioning index, arr[pi] is  
                  now at right place */
                int pi = partition(arr, low, high); 
                // Recursively sort elements before 
                // partition and after partition 
                sort(arr, low, pi-1); 
                sort(arr, pi+1, high); 
            } 
        } 
    }
    
    //Searching Menggunakan Metode BinarySearch
    public void searchData(){
        System.out.println("\t\t---Search Data---");
        System.out.println();
        System.out.print("Masukan Data Yang Dicari : ");
        int key = sc.nextInt();
        binarySearch(arr, key, arr.length-1, 0);
    }
    private void binarySearch(int[] data, int key, int high, int low){
        int mid = (high+low+1)/2;
        if(data[mid] == key)
            System.out.println("Data ditemukan pada indeks ke-"+mid);
        else if(mid == high || mid == low)
            System.out.println("Data tidak ditemukan");
        else{
            if(data[mid]>key)
                high = mid;
            else
                low = mid;
            binarySearch(data, key, high, low);
        }
    }
    public boolean isEmpty(){
        return arr == null;
    }
}
