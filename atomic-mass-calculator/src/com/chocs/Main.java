package com.chocs;

import java.util.Scanner;
import java.util.HashMap;

public class Main {

    private static final HashMap<String, Double> periodicTable = new HashMap<>();
    static {
        periodicTable.put("H", 1.008);
        periodicTable.put("He", 4.002602);
        periodicTable.put("Li", 6.94);
        periodicTable.put("Be", 9.0121831);
        periodicTable.put("B", 10.81);
        periodicTable.put("C", 12.011);
        periodicTable.put("N", 14.007);
        periodicTable.put("O", 15.999);
        periodicTable.put("F", 18.998403163);
        periodicTable.put("Ne", 20.1797);
        periodicTable.put("Na", 22.98976928);
        periodicTable.put("Mg", 24.305);
        periodicTable.put("Al", 26.9815385);
        periodicTable.put("Si", 28.085);
        periodicTable.put("P", 30.973761998);
        periodicTable.put("S", 32.06);
        periodicTable.put("Cl", 35.45);
        periodicTable.put("Ar", 39.948);
        periodicTable.put("K", 39.0983);
        periodicTable.put("Ca", 40.078);
        periodicTable.put("Sc", 44.955908);
        periodicTable.put("Ti", 47.867);
        periodicTable.put("V", 50.9415);
        periodicTable.put("Cr", 51.9961);
        periodicTable.put("Mn", 54.938044);
        periodicTable.put("Fe", 55.845);
        periodicTable.put("Co", 58.933194);
        periodicTable.put("Ni", 58.6934);
        periodicTable.put("Cu", 63.546);
        periodicTable.put("Zn", 65.38);
        periodicTable.put("Ga", 69.723);
        periodicTable.put("Ge", 72.63);
        periodicTable.put("As", 74.921595);
        periodicTable.put("Se", 78.971);
        periodicTable.put("Br", 79.904);
        periodicTable.put("Kr", 83.798);
        periodicTable.put("Rb", 85.4678);
        periodicTable.put("Sr", 87.62);
        periodicTable.put("Y", 88.90584);
        periodicTable.put("Zr", 91.224);
        periodicTable.put("Nb", 92.90637);
        periodicTable.put("Mo", 95.95);
        periodicTable.put("Tc", 98.);
        periodicTable.put("Ru", 101.07);
        periodicTable.put("Rh", 102.90550);
        periodicTable.put("Pd", 106.42);
        periodicTable.put("Ag", 107.8682);
        periodicTable.put("Cd", 112.414);
        periodicTable.put("In", 114.818);
        periodicTable.put("Sn", 118.710);
        periodicTable.put("Sb", 121.760);
        periodicTable.put("Te", 127.60);
        periodicTable.put("I", 126.90447);
        periodicTable.put("Xe", 131.293);
        periodicTable.put("Cs", 132.90545196);
        periodicTable.put("Ba", 137.327);
        periodicTable.put("La", 138.90547);
        periodicTable.put("Ce", 140.116);
        periodicTable.put("Pr", 140.90766);
        periodicTable.put("Nd", 144.242);
        periodicTable.put("Pm", 145.);
        periodicTable.put("Sm", 150.36);
        periodicTable.put("Eu", 151.964);
        periodicTable.put("Gd", 157.25);
        periodicTable.put("Tb", 158.92535);
        periodicTable.put("Dy", 162.500);
        periodicTable.put("Ho", 164.93033);
        periodicTable.put("Er", 167.259);
        periodicTable.put("Tm", 168.93422);
        periodicTable.put("Yb", 173.054);
        periodicTable.put("Lu", 174.9668);
        periodicTable.put("Hf", 178.49);
        periodicTable.put("Ta", 180.94788);
        periodicTable.put("W", 183.84);
        periodicTable.put("Re", 186.207);
        periodicTable.put("Os", 190.23);
        periodicTable.put("Ir", 192.217);
        periodicTable.put("Pt", 195.084);
        periodicTable.put("Au", 196.966569);
        periodicTable.put("Hg", 200.592);
        periodicTable.put("Tl", 204.38);
        periodicTable.put("Pb", 207.2);
        periodicTable.put("Bi", 208.98040);
        periodicTable.put("Po", 209.);
        periodicTable.put("At", 210.);
        periodicTable.put("Rn", 222.);
        periodicTable.put("Fr", 223.);
        periodicTable.put("Ra", 226.);
        periodicTable.put("Ac", 227.);
        periodicTable.put("Th", 232.0377);
        periodicTable.put("Pa", 231.03588);
        periodicTable.put("U", 238.02891);
        periodicTable.put("Np", 237.);
        periodicTable.put("Pu", 244.);
        periodicTable.put("Am", 243.);
        periodicTable.put("Cm", 247.);
        periodicTable.put("Bk", 247.);
        periodicTable.put("Cf", 251.);
        periodicTable.put("Es", 252.);
        periodicTable.put("Fm", 257.);
        periodicTable.put("Md", 258.);
        periodicTable.put("No", 259.);
        periodicTable.put("Lr", 266.);
        periodicTable.put("Rf", 267.);
        periodicTable.put("Db", 270.);
        periodicTable.put("Sg", 269.);
        periodicTable.put("Bh", 270.);
        periodicTable.put("Hs", 269.);
        periodicTable.put("Mt", 278.);
        periodicTable.put("Ds", 281.);
        periodicTable.put("Rg", 282.);
        periodicTable.put("Cn", 285.);
    }

    public static double calcAtomicMass(String molecule) {
        double mass = 0.0;

        String[] atomes = molecule.split("(?=[A-Z])");

        for (String atome : atomes) {
            StringBuilder element = new StringBuilder();
            int multiplier = 1;

            for (int j = 0; j < atome.length(); j++) {
                if (Character.isLetter(atome.charAt(j))) {
                    element.append(atome.charAt(j));
                }
                if (Character.isDigit(atome.charAt(j))) {
                    multiplier = Character.getNumericValue(atome.charAt(j));
                }
            }

            if (periodicTable.containsKey(element.toString())) {
                mass += periodicTable.get(element.toString()) * multiplier;
            } else {
                System.out.println("Unknown element: " + element);
                return -1;
            }
        }
        return mass;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a molécula: ");
        String molecule = scanner.nextLine();

        double mass = calcAtomicMass(molecule);

        if(mass == -1) {
            System.out.println("\nImpossible to calculate the mass of the molecule.");
        } else {
            System.out.printf("\nAtomic mass of the molecule: %f", mass);
        }
    }
}