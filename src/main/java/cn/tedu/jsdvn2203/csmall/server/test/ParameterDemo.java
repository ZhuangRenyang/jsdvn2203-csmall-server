package cn.tedu.jsdvn2203.csmall.server.test;

public class ParameterDemo {
    public static void main(String[] args) {
        ParameterDemo p = new ParameterDemo();
        p.sum(1,2,3);

    }
    public int sum(int... arr){
        int sum = 0;
        for (int i = 0; i <arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
