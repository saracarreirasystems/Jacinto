package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Para que sua média seja calculada, insira os valores solicitados.");
        System.out.println("Insira a sua nota da E1: ");
        double E1 = scan.nextDouble();

        System.out.println("Insira a sua nota da P1: ");
        double P1 = scan.nextDouble();

        System.out.println("Insira a sua nota da E2: ");
        double E2 = scan.nextDouble();

        System.out.println("Insira a sua nota da API: ");
        double API = scan.nextDouble();

        System.out.println("Insira a nota dos seus pontos extras: ");
        double X = scan.nextDouble();

        System.out.println("Insira a sua nota da SUB: ");
        double SUB = scan.nextDouble();

        // Computa a média ponderada e aplica a contribuição da API

        double SOMA = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);
        double MEDI = SOMA * 0.5;

        double NUM = Math.max(SOMA - 5.9, 0);
        double DEN = SOMA - 5.9;
        double IAPI = 0;
        if (DEN != 0) {
            IAPI = (NUM / DEN) * API * 0.5;
        }

        double MED = MEDI + IAPI;

        System.out.println("Sua média é: " + MED);
    }
}