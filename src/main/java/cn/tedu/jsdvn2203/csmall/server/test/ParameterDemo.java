package cn.tedu.jsdvn2203.csmall.server.test;

public class ParameterDemo {
    public static void main(String[] args) {
        ParameterDemo p = new ParameterDemo();
        //调用方法时可以给出任意多个参数(规定类型)
        p.sum(1);
        p.sum(1,2);
        p.sum(1,2,3);
        //调用方法时可以不给参数
        p.sum();
    }

    // 计算两个数的和
    public int sum(int a,int b){
        return a+b;
    }

    public int sum(int... arr){
        // 计算N个数的和
        int sum = 0;
        for (int i = 0; i <arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
