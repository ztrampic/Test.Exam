package helper;

import java.util.concurrent.*;

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(4000);
        return "";
    }
}
public class MyTimeOut {
    public MyTimeOut(int timeoutValue) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Task());
        try {
            System.err.println("Povratak na meni.............."+"za"+" "+ timeoutValue + " "+"sekunde.");
            System.out.println(future.get(timeoutValue, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            future.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
