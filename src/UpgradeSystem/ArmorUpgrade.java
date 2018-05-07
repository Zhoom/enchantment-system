package UpgradeSystem;

public class ArmorUpgrade extends UpgradeSystem{
    private static float ARMOR_PRI_MIN_PERCENTAGE = 15.0f;
    private static float ARMOR_DUO_MIN_PERCENTAGE = 7.5f;
    private static float ARMOR_TRI_MIN_PERCENTAGE = 5.0f;
    private static float ARMOR_TET_MIN_PERCENTAGE = 2.0f;
    private static float ARMOR_PEN_MIN_PERCENTAGE = 1.5f;

    private static float ARMOR_INCREASE_PER_FS_PRI = 1.5f;
    private static float ARMOR_INCREASE_PER_FS_DUO = 0.75f;
    private static float ARMOR_INCREASE_PER_FS_TRI = 0.5f;
    private static float ARMOR_INCREASE_PER_FS_TET = 0.25f;
    private static float ARMOR_INCREASE_PER_FS_PEN = 0.25f;

    private static int ARMOR_LIMIT_FS_PRI = 25;
    private static int ARMOR_LIMIT_FS_DUO = 25;
    private static int ARMOR_LIMIT_FS_TRI = 44;
    private static int ARMOR_LIMIT_FS_TET = 90;
    private static int ARMOR_LIMIT_FS_PEN = 124;

    public ArmorUpgrade(){
        super();
    }

    @Override
    public boolean upgradeItem(int upgradeLevel){

        switch(upgradeLevel){
            case 1:
                return upgrade(ARMOR_PRI_MIN_PERCENTAGE,
                        getFailStackBonus(ARMOR_INCREASE_PER_FS_PRI, ARMOR_LIMIT_FS_PRI));
            case 2:
                return upgrade(ARMOR_DUO_MIN_PERCENTAGE,
                        getFailStackBonus(ARMOR_INCREASE_PER_FS_DUO, ARMOR_LIMIT_FS_DUO));
            case 3:
                return upgrade(ARMOR_TRI_MIN_PERCENTAGE,
                        getFailStackBonus(ARMOR_INCREASE_PER_FS_TRI, ARMOR_LIMIT_FS_TRI));
            case 4:
                return upgrade(ARMOR_TET_MIN_PERCENTAGE,
                        getFailStackBonus(ARMOR_INCREASE_PER_FS_TET, ARMOR_LIMIT_FS_TET));
            case 5:
                return upgrade(ARMOR_PEN_MIN_PERCENTAGE,
                        getFailStackBonus(ARMOR_INCREASE_PER_FS_PEN, ARMOR_LIMIT_FS_PEN));
            default:
                System.out.println("Invalid enchantment!");
                return false;
        }
    }
}
