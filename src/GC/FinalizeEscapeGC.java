package GC;

/**
 * Created by Administrator on 2016/10/12.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("i am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        SAVE_HOOK = this;
        System.out.println("finalize method excuted.");
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        try {
            Thread.sleep(500);
            if(SAVE_HOOK != null){
                SAVE_HOOK.isAlive();
            }else {
                System.out.print("i am dead.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        SAVE_HOOK = null;
        System.gc();
        try {
            Thread.sleep(500);
            if(SAVE_HOOK != null){
                SAVE_HOOK.isAlive();
            }else {
                System.out.print("i am dead.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
