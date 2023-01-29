// import java.util.*;
public class GreaterCommonFactor{
    int dispGreaterCommonFactor(int x, int y){
        // int xDisp;
        for(int i=1; i<=x&&i<=y;i++){
            if(x%i==0&&y%i==0){
                int gCf = i;
                return gCf;
            }
        }
        return 0;
    }
    
    public static void main(String args[]){
        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
        int b = num.nextInt();
        GreaterCommonFactor obj = new GreaterCommonFactor();
        int disp = obj.dispGreaterCommonFactor(a, b);
        System.out.println("Heighest common factor :" +disp);
        
    }
} 