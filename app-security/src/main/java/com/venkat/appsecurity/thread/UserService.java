package com.venkat.appsecurity.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {


    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            int id = 1;
            threadPool.submit(() -> {
                String birthDate = new UserService().birthDate(id);
                System.out.println(birthDate);
            });
        }
    }

    public String birthDate(int userId){
        Date birthDate = null;//getting date from db
        final SimpleDateFormat df = ThreadSafeFormatter.df.get();
        return df.format(birthDate);
    }
}


class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> df =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}

class ThreadSafeFormatter2 {
    public static ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}
