class MemoryPets {
    public static void main(String[] args) {
        int count = 3;
        String[] pets = new String[5];
        pets[0] = "jojo";
        pets[2] = "lemon";
        pets[1] = "bubble";

        String[] copyA = null;
        String[] copyB = null;
        String[] copyC = null;
        String[] copyD = null;

        String[] copyMain = pets;
        funcA(pets);
        copyB = funcB(pets);

        copyC = funcC(pets);
        funcD(pets,copyD);     
    }

    static public void funcA(String[] A) {
        String[] copyA = A;
    }

    static public String[] funcB(String[] A) {
        String[] copyB = A;
        return copyB;
    }

    static public String[] funcC(String[] A) {
        String[] copyC = new String[A.length];
         for (int i=0; i<A.length; i++) {
             copyC[i] = A[i];
         }
         return copyC;
      }
      static public void funcD(String[] A, String[] copyD) {
         for (int i=0; i<A.length; i++) {
             copyD[i] = A[i];
         }
      }  
}