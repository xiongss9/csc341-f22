class MemoryArrays {
    public static void main(String[] args) {
        String[] pets = new String[5];
        PetsString petsString = new PetsString();
        PetsPet petsPet = new PetsPet();
    }
    public static class PetsString {
        private int count = 0;
        private String[] pets = new String[5];
        public PetsString(String[] p, int c) {
            count = c;
            for (int i = 0; i < c; i++) {
                pets[i] = p[i];
            }
        }
        public void set(int index, String p) {
            pets[index] = p;
        }
        public String get(int index) {
            return pets[index];
        }
    }
    public static class PetsPet {
        private Pet[] pets = new Pet[5];
        public PetsPet(Pet[] p, int c) {
            for (int i = 0; i < c; i++) {
                pets[i] = p[i];
            }
        }
        public void set(int idx, Pet p) {
            pets[idx] = p;
        }
        public Pet get(int idx) { return pets[idx]; }
    }
    public class Pet {
        private String name;
        private String animal;
        public Pet(String n, String a) {
            name = n;
            animal = a;
        }
        public String name() { return name; }
        public void name(String n) { name = n; }
        public String animal() { return animal; }
        public void animal(String a) { animal = a; }
    }
}