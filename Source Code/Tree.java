public class Tree {
    
    private Node root = null;
    
    //Add Wrapper
    public void add(int data){
        add(data,root);
    }
    private void add(int data, Node node){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else{
            if(data>node.data){
                if(node.right == null){
                    node.right = newNode;
                }else{
                    add(data, node.right);
                }
            }else{
                if(node.left == null){
                    node.left = newNode;
                }else{
                    add(data, node.left);
                }
            }
        }
    }
    //Menghapus tree
    public void clear(){
        root.left = null;
        root.right = null;
        root = null;
    }
    //Mengecek apabila tree kosong
    public boolean isEmpty(){
        return root==null;
    }
    //Search Wrapper
    public Node search(int key){
        return search(root, key);
    }
    private Node search(Node root, int key){
        if(root == null) return null;
        if(root.data == key) return root;
        else{
            if(key > root.data)
                return search(root.right, key);
            else
                return search(root.left, key);
        }
    }
    //Remove Wrapper
    public void remove(int key){
        remove(root, key);
    }
    private void remove(Node root, int key){
        Node found = search(key);
        Node parrentNode;
        if(found != null){
            if(found.left != null && found.right != null){ //Multi Subtree
                Node succ = findSuccesor(found);
                parrentNode = findParrentNode(root, succ.data);
                found.data = succ.data;
                if(key > parrentNode.data)
                    parrentNode.right = null;
                else
                    parrentNode.left = null;
            }
            else{
                parrentNode = findParrentNode(root, key);
                //System.out.println("Pre Node : "+parrentNode.data);
                if(found.left == null && found.right == null){
                    if(key > parrentNode.data)
                        parrentNode.right = null;
                    else
                        parrentNode.left = null;
                }else if(found.left == null ^ found.right == null){ // ^ = XOR
                    if(found.left != null)
                        parrentNode.left = found.left;
                    else
                        parrentNode.right = found.right;
                }
            }
        }
    }
    //Untuk mencari parrent node
    private Node findParrentNode(Node root, int key){
        //System.out.println("PreNode Data : "+root.data);
        if(root.right != null && key == root.right.data){
            return root;
        }else if(root.left != null && key == root.left.data){
            return root;
        }else{
            if(key > root.data)
                return findParrentNode(root.right, key);
            return findParrentNode(root.left, key);
        }
    }
    //Untuk mencari penerus (successor) dari node yang dihapus sebelumnya
    private Node findSuccesor(Node root){
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    //Inorder Printer Wrapper
    public void printInorder(){
        printInorder(root);
    }
    private void printInorder(Node node){
        if(node == null)
            return;
        else{
            printInorder(node.left);
            System.out.print(node.data+" ");
            printInorder(node.right);
        }
    }
    
    //Preorder Printer Wrapper
    public void printPreorder(){
        printPreorder(root);
    }
    private void printPreorder(Node node){
        if(node == null)
            return;
        else{
            System.out.print(node.data+" ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }
    
    //Postorder Printer Wrapper
    public void printPostorder(){
        printPostorder(root);
    }
    private void printPostorder(Node node){
        if(node == null)
            return;
        else{
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.data+" ");
        }
    }
    
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
}
