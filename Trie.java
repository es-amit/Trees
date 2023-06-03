public class Trie {
    static class Node{
        Node[] children;
        boolean eow;
        Node(){
            for(int i=0;i<26;i++){
                this.children[i] =null;
            }
            eow= false;
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(root.children[idx] == null){
                root.children[idx] = new Node();
            }
            if(i == word.length()-1){
                root.children[idx].eow= true;
            }
            root = root.children[idx];
        }
    }
    public static void main(String[] args) {
        String[] words= {"the","a","their","there","any"};
        for(int i =0;i<words.length;i++){
            insert(words[i]);
        }
    }
}
