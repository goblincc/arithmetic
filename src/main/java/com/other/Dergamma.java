package com.other;


import org.apache.commons.math3.distribution.BetaDistribution;

public class Dergamma {
    public static void main(String[] args) {
        //采样1000次
        for (int i = 0; i < 10000; i++) {
            System.out.println(betasampler(81,219));
        }
    }
    //beta分布采样
    public static double betasampler(double alpha, double beta){
        BetaDistribution betaDistribution = new BetaDistribution(alpha, beta);
        return betaDistribution.sample();
    }
}
