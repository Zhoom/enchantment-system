package UpgradeSystem;

import java.util.Scanner;

public class UpgradeConsole {
    public static void main(String[] args){
        var upgrade = new ArmorUpgrade();
        var read = new Scanner(System.in);
        int upgradeLevel = 1;
        int num;

        do{
            var enchantmentResult = upgrade.upgradeItem(upgradeLevel);

            if(enchantmentResult){
                System.out.println("Upgrade com Sucesso!");
                upgradeLevel += 1;

            } else {
                System.out.println("Upgrade Falhou!");
                if(upgradeLevel >= 2){
                    upgradeLevel -= 1;
                }
            }

            switch(upgradeLevel){
                case 1:
                    System.out.println("Seu item está PRI");
                    break;
                case 2:
                    System.out.println("Seu item está DUO");
                    break;
                case 3:
                    System.out.println("Seu item está TRI");
                    break;
                case 4:
                    System.out.println("Seu item está TET");
                    break;
                case 5:
                    System.out.println("Seu item está PEN");
                    break;
                default:
                    System.out.println("Unknown Error");
                    break;
            }

            num = read.nextInt();
        }while(num != 0);

    }
}
