package sample;
public class MonsterFight {


    private int set1;


    public MonsterFight(int set1) {
        this.set1 = set1;

    }

    public boolean checkSet1() {

        if ( set1 == 0 ) {
            return true;
        }
        else {
            return false;
        }
    }






    public int getSet1() {
        return set1;
    }




    public void addSet1(int add) {

        set1 = add;
    }







}