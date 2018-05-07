package UpgradeSystem;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class UpgradeSystem {
    private FailStack failstack = null;

    public UpgradeSystem(){
        this.failstack = FailStack.getFailStack();
    }

    /**
     * @param upgradeLevel Current upgrade level from item (PRI, DUO, TRI, TET, PEN)
     * @return False if item failed on upgrade, True if item succeeded on upgrade.
     */
    public abstract boolean upgradeItem(int upgradeLevel);

    /**
     * @param itemMinPercentage Minimum percentage a item have to succeed on upgrade.
     * @param failStackBonus Total bonus percentage from fail stacks.
     * @return False if item failed on upgrade, True if item succeeded on upgrade.
     */
    protected boolean upgrade(float itemMinPercentage, float failStackBonus){
        double percentage = 100 * Math.random();

        if(percentage < itemMinPercentage + failStackBonus){
            failstack.setStacks(0);
            return true;
        } else {
            failstack.addStacks(1);
            return false;
        }
    }

    /**
     * @param itemIncreasePerFs How much percentage of success will increase per fail stack.
     * @param itemLimitFs Maximum fail stack a item accepts.
     *                    (It's possible to stack above the maximum limit, but extra fail stacks will not increase
     *                    bonus percentage on upgrade attempt).
     * @return Total bonus percentage from fail stacks.
     */
    protected float getFailStackBonus(float itemIncreasePerFs, int itemLimitFs){
        if(failstack.getStacks() >= itemLimitFs){
            return itemIncreasePerFs * itemLimitFs;
        } else {
            return itemIncreasePerFs * failstack.getStacks();
        }
    }

    private void showMessage(float itemMinPercentage, float failStackBonus){
        System.out.println("Você tem " + failstack.getStacks() + " fail stacks.");

        NumberFormat formatter = new DecimalFormat("#.##");
        String totalPercentageChance = formatter.format(itemMinPercentage + failStackBonus);

        System.out.println("Chance de Upgrade: " + totalPercentageChance + "%");
    }
}
