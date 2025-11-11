public class DoubleLockingSingleton{

    private static DoubleLockingSingleton instance = null;

    private DoubleLockingSingleton(){
        System.out.println("Singleton constructor called");
    }

    public static DoubleLockingSingleton getInstance(){
        if(instance == null){ // checking first if null then only proving lock (no lock fisrt time check)
            synchronized (DoubleLockingSingleton.class){
                if(instance == null){   // second check after acquiring lock
                    instance = new DoubleLockingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        DoubleLockingSingleton s1 = DoubleLockingSingleton.getInstance();
        DoubleLockingSingleton s2 = DoubleLockingSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}