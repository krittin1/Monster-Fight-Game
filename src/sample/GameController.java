package sample;

public class GameController {
    private Monster m1, m2;
    private int turn; // -1 , 1
    private int round;

    MonsterFight s1 = new MonsterFight(0);
    MonsterFight s2 = new MonsterFight(0);

    public GameController(Monster m1, Monster m2){
        this.m1 = m1;
        this.m2 = m2;
        this.turn = 1;
        this.round = 1;

    }
    public void attackState(){



         if (this.turn == 1) {

             if (s1.checkSet1()) {

                 m2.attack(m1, m2);

             }
             else{
                 s1.addSet1(0);
             }

             changeTurn();


         } else {

             if ( s2.checkSet1()) {

                 m1.attack(m2, m1);

             }
             else{
                 s2.addSet1(0);
             }

             changeTurn();
             this.round++;
         }
     }




    public void healState( int healer){



            if (this.turn == 1) {

                if ( s1.checkSet1()) {
                    m1.heal(healer);
                    s1.addSet1(1);
                }
                else{
                    s1.addSet1(0);
                }


                changeTurn();
                this.round++;


            } else {

                if ( s2.checkSet1()) {
                    m2.heal(healer);
                    s2.addSet1(1);
                }
                else{
                    s2.addSet1(0);
                }



                changeTurn();
                this.round++;
            }

        }








    public boolean isWin(){
        if (m1.lose(m1) || m2.lose(m2)){
            return true;
        }
        return false;
    }
    public Monster getWinMonster(){
        if (m1.getHp() >= m2.getHp()){
            return m1;
        }
        return m2;
    }
    private void changeTurn(){
        this.turn *= -1;
    }

    public int getTurn() {
        return turn;
    }

    public int getRound() {
        return round;
    }

    public Monster getM1(){
        return m1;
    }
    public Monster getM2(){
        return m2;
    }

    public void setM1(){
        this.m1.setHeal();
    }
    public void setM2(){
        this.m2.setHeal();
    }
}
