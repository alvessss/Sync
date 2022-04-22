package com.alvessss.sync;

@SuppressWarnings("unused")
public class Goal {
   public boolean reached = false;

   public void doAfter(Callback callback) {
      doAfter(callback, 0);
   }
   
   public void doAfter(Callback callback, int checkInterval){
      final Runnable checkCondition = new Runnable() {
         @Override
         public void run(){
            if (!reached){
               try {
                  Thread.sleep(checkInterval);
               } catch (InterruptedException e){
                  e.printStackTrace();
               }
               new Thread(this).start();
               return;
            }
            callback.run();
         }
      };
      new Thread(checkCondition).start();
   }

   public interface Callback {
      void run();
   }
}