class Memory {
    public static void main(String[] args) {
        int n = 10;
        String name = "amy";
        int[] A = {7,8,9,0};
        int z = A[0];
        fn1(n);
        n = fn2(n);
        fn3(name);
        fn4(A);
        fn5(A);
    }
    
    static public void fn1(int x) {
       x = 20;
    }
    static public int fn2(int x) {
       return x+20;
    }
    static public void fn3(String x) {
       x = "larson";
    }
    static public void fn4(int[] x) {
       x = new int[4];
       x[0] = 20;
    }
    static public void fn5(int[] x) {
       x[0] = 20;
    }
    
}