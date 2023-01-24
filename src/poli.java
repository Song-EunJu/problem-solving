interface Fightable {
    public abstract int fire();
}

interface Transformable {
    public abstract void changeShape(boolean isHeroMode);
}

interface Heroable extends Transformable, Fightable {
    void upgrade();
}

public class poli implements Heroable{

    @Override
    public int fire() {
        return 0;
    }

    @Override
    public void changeShape(boolean isHeroMode) {
        System.out.println("모양 변경");
    }

    @Override
    public void upgrade() {
        System.out.println("버전 업");
    }
}
