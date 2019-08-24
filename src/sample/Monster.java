package sample;

public class Monster {

    private String name;
    private int hp;
    private int atk;
    private int def;
    private boolean heal;
    private int oldHp;
    private Monster attacker;
    private String imgPath;






    public Monster(String name, int hp, int atk, int def, String imgPath) {

        this.name = name;
        this.hp = hp;
        this.oldHp = hp;
        this.atk = atk;
        this.def = def;
        this.heal = false;
        this.imgPath = imgPath;

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name; }

    public int getHp() {


        return hp;
    }




    public int getAtk() { return atk; }

    public int getDef() { return def; }


    public int getOldHp() {
        return oldHp;
    }

    public int attack(Monster attacker, Monster defender) {

        if ( defender.getDef() < attacker.getAtk() ) {

            hp = defender.getHp() - (Math.abs(attacker.getAtk() - defender.getDef()));
            if (hp < 1) {
                hp = 0;
            }

        }
        return hp;

    }





    public void heal(int healer) {

        if ( healer > 0 )
            if (  healer <= getOldHp()    ) {
                this.hp = this.hp + healer;
            }
            else{
                this.hp = this.oldHp;

            }
        this.heal = true;

    }



    public boolean lose(Monster attacker) {

        if ( attacker.getHp() < 1  ) {
            return true;
        }
        else {
            return false;
        }
    }

    public void winner(Monster attacker, Monster defender, int oldhp) {
        if ( attacker.getHp() >= 1 && defender.getHp() < 1 ) {
            System.out.println();
            this.attacker = attacker;
            System.out.println("The Winner Is ..........\n" +
                    "Monster "+ attacker.getName()+" atk : "+atk+" def : "+def+" hp : "+hp+"/"+oldhp+"\n");
        }
    }







    @Override
    public String toString() {
        return "Monster"+getName()+"atk: "+getAtk()+" def: "+getDef()+" hp: "+getHp()+"/"+getOldHp();
    }

    public boolean getHeal()
    {

        return this.heal ;

    }

    public void setHeal()
    {

        this.heal = false ;

    }




}
