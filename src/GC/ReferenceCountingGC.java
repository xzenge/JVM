package GC;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ReferenceCountingGC {
    public Object instence = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instence = objB;
        objB.instence = objA;

        System.gc();
    }

}
