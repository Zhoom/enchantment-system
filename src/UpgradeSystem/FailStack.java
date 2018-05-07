package UpgradeSystem;

public class FailStack {
    private static FailStack failStack = null;
    private int stacks;

    private FailStack(){
        this.stacks = 0;
    }

    public static FailStack getFailStack() {
        if(failStack == null){
            failStack = new FailStack();
        }

        return failStack;
    }

    public int getStacks() {
        return stacks;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }

    public void addStacks(int stacks){
        this.stacks += stacks;
    }
}
