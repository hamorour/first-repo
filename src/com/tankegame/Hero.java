package com.tankegame;

import java.util.Vector;

/**
 *
 */
public class Hero extends Tank{
    Shot shot = null;

    Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y) { super(x, y); }

    //设计
    public void shotEnermyTank(){
        //发射多颗子弹怎么办，控制在面板上最多发射5颗
        if (shots.size() == 5){
            return;
        }
        //创建Shot对象，根据当前Hero的位置和方向来创建Shot
        switch (getDirect()){
            case 0:
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2:
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY()+20,3);
                break;
        }

        //把新创建的shot对象放入到shots中
        shots.add(shot);

        new Thread(shot).start();
    }
}
