package UpgradeSystem;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class UpgradeSystem {
    private FailStack fs = null;

    public UpgradeSystem(){
        this.fs = FailStack.getFailStack();
    }

    /**
     * @param upgradeLevel Current upgrade level from item (PRI, DUO, TRI, TET, PEN)
     * @return False if item failed on upgrade, True if item succeeded on upgrade.
     */
    public abstract boolean upgradeItem(int upgradeLevel);

    protected boolean enchantItem(float itemMinPercentage, float itemIncreasePerFs, int itemLimitFs){
        double percentage = 100 * Math.random();
        float fsBonus;

        if(fs.getStacks() >= itemLimitFs){
            fsBonus = itemIncreasePerFs * itemLimitFs;
        } else {
            fsBonus = itemIncreasePerFs * fs.getStacks();
        }

        showMessage(itemMinPercentage, fsBonus);

        if(percentage < itemMinPercentage + fsBonus){
            fs.setStacks(0);
            return true;
        } else {
            fs.addStacks(1);
            return false;
        }
    }

    private void showMessage(float itemMinPercentage, float fsBonus){
        System.out.println("Você tem " + fs.getStacks() + " fail stacks.");

        NumberFormat formatter = new DecimalFormat("#.##");
        String totalPercentageChance = formatter.format(itemMinPercentage + fsBonus);

        System.out.println("Chance de Upgrade: " + totalPercentageChance + "%");
    }
}
