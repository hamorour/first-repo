package com.tankegame;

public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 2;

    boolean isLive = true;//子弹是否存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击行为
        while (true){
            //让线程休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }
            //测试
            //System.out.println(x+"/t"+y);

            //当子弹移动到面板的边界时，就应该销毁
            //当子弹碰到敌人的坦克时，也应该结束线程
            if(!(x >= 0 && x <= 1000 && y >=0 && y <=750 && isLive)){
                isLive = false;
                break;
            }
        }

    }
}
