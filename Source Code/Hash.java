public class Hash {
    
	Node[] nodeData;
    int arrSize;
    public Hash(int size){
        nodeData = new Node[size];
        arrSize = size;
    }
    public int getHashValue(String x){
        int temp = x.hashCode();
        if(temp<0)
            temp*=-1;
        return temp;
    }
    public void add(String data){
        Node newNode = new Node(data);
        int tempIndex = getHashValue(data)%arrSize+1;
        if(tempIndex>=arrSize) tempIndex=tempIndex-1;
        if(nodeData[tempIndex]==null){
            newNode.index = tempIndex;
            nodeData[tempIndex] = newNode;
            
        }else{
            addCollisionHandling(newNode, tempIndex);
        }
    }
    private void addCollisionHandling(Node newNode,int index){
        int tempIndex = index;
        boolean isLastArray = false;
        while(nodeData[tempIndex]!=null){               
            if(!isLastArray)
                tempIndex++;
            else
                tempIndex--;
            if(tempIndex==arrSize-1 || tempIndex==arrSize){
                isLastArray = true;
                tempIndex = index; //Mengulang index
            }
            if(nodeData[tempIndex]==null){
                newNode.index = tempIndex;
                nodeData[tempIndex] = newNode;
                return;
            }
        }
    }
    public void print(){
        for(int i=0;i<arrSize;i++){
            if(nodeData[i]!=null){
                String result = printStringFormat(nodeData[i]);
                System.out.println(result);
            }
        }
    }
    public void search(String key){
        for(int i=0 ; i<arrSize && nodeData[i].data!=null ; i++){
            if(isPresent(key, i)){
                System.out.println(printStringFormat(nodeData[i]));
            }
        }
    }
    private String printStringFormat(Node node){
        String result = "  "+node.index+"\t"+node.data;
        String whitespace = "";
        for(int i=20;i>result.length();i--){
            whitespace+=" ";
        }
        result+=whitespace+node.hashValue;
        return result;
    }
    private boolean isPresent(String key, int i){
        return  (nodeData[i].data.contains(key) || //Pengecekan bila data/hash/index mengandung yang dicari
            Integer.toString(nodeData[i].hashValue).contains(key)||
            Integer.toString(nodeData[i].index).contains(key));
    }
    class Node{
        public String data;
        public int hashValue;
        public int index;
        public Node(String data){
            this.data = data;
            hashValue = getHashValue(data);
        }
    }
}
