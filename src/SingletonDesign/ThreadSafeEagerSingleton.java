public class ThreadSafeEagerSingleton{
    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();
    

    private ThreadSafeEagerSingleton(){
        System.out.println("ThreadSafeEagerSingleton constructor is called "+ instance);
    }

    public static ThreadSafeEagerSingleton getInstance(){
        System.out.println("instance value "+ instance);
        return instance;
    }

    public static void main(String[] args){
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();
        
        System.out.println(s1==s2);
    }
}