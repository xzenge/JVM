package GC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInput;

/**
 * Created by Administrator on 2016/10/14.
 */
public class LockThread {
    public static void createBusyTredad(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyTredad();
        br.readLine();

        Object obj = new Object();
        createLockThread(obj);
    }


}
