package GC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public class TestJConsole {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0;i<num;i++){
            Thread.sleep(50L);
            list.add(new OOMObject());
        }

    }

    public static void main(String[] args) {
        try {
            fillHeap(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }
}
