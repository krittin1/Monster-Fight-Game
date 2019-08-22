//package sample;
//
//public class test {
//    private Monster m1, m2;
//    private int turn; // -1 , 1
//    private int round;
//
//
//    public test(Monster m1, Monster m2){
//        this.m1 = m1;
//        this.m2 = m2;
//        this.turn = 1;
//        this.round = 1;
//
//    }
//    public void attackState(){
//        if(this.turn == 1){
//            m2.getDamage(m1.getAtk());
//            changeTurn();
//        }
//        else{
//            m1.getDamage(m2.getAtk());
//            changeTurn();
//            this.round++;
//        }
//
//
//
//
//    }
//    public void healState(int blood){
//        if(this.turn == 1){
//            m1.getHealing(blood);
//            changeTurn();
//            this.round++;
//        }
//        else{
//            m2.getHealing(blood);
//            changeTurn();
//            this.round++;
//        }
//
//    }
//    public boolean isWin(){
//        if (m1.isDead() || m2.isDead()){
//            return true;
//        }
//        return false;
//    }
//    public Monster getWinMonster(){
//        if (m1.getHealth() >= m2.getHealth()){
//            return m1;
//        }
//        return m2;
//    }
//    private void changeTurn(){
//        this.turn *= -1;
//    }
//
//    public int getTurn() {
//        return turn;
//    }
//
//    public int getRound() {
//        return round;
//    }
//    public Monster getM1(){
//        return m1;
//    }
//    public Monster getM2(){
//        return m2;
//    }
//    public void setM1(){
//        this.m1.setHeal();
//    }
//    public void setM2(){
//        this.m2.setHeal();
//    }
//}
