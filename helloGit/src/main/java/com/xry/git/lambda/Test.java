package com.xry.git.lambda;

public class Test {
    public static void main(String[] args) {
        LambdaImpl lambda = new LambdaImpl() {

            @Override
            public void run(Integer a) {
                System.out.println("I like you1"+a);
            }
        };
        lambda.run(123);

        lambda = new LambdaImpl(){
           @Override
           public void run(Integer a) {
               System.out.println("I like lambda2"+a);
           }
       };
        lambda.run(1321);

        lambda = a->{
            System.out.println("I like lambda3"+a);
        };
        lambda.run(312);

    }

}
