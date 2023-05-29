import java.util.spi.ResourceBundleControlProvider;

public class towerofHanoi {
    public static void printhanoi(int n,String src,String helper,String dest){
        if(n==1){
            System.out.println("Transfer "+n +" disk from "+src +" to "+ dest);
            return;
        }

        printhanoi(n-1, src, dest, helper);
        System.out.println("Transfer "+n +" disks from "+src +" to "+ dest);
        printhanoi(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        int n=3;
        printhanoi(n, "Source", "helper", "destination");
    }
}
