package com.tankegame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    //增加成员，EnemyTank 可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //将MyPanel的成员 Vector<EnemyTank> enemyTanks = new Vector<>() 获取
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前这个敌人坦克是否和 enemyTanks 中的其他坦克发生重叠
    public boolean isTouchEnemyTank() {
        //判断当前坦克（this）的方向
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出敌人的一辆坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    & this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }

                            if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                if (this.getX() + 40 >= enemyTank.getX()
                                        && this.getX() + 40 <= enemyTank.getX() + 40
                                        && this.getY() >= enemyTank.getY()
                                        & this.getY() <= enemyTank.getY() + 60) {
                                    return true;
                                }
                            }
                            //如果敌人坦克是左右方向
                            if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                                if (this.getX() >= enemyTank.getX()
                                        && this.getX() <= enemyTank.getX() + 60
                                        && this.getY() >= enemyTank.getY()
                                        & this.getY() <= enemyTank.getY() + 40) {
                                    return true;
                                }

                                if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                    if (this.getX() + 40 >= enemyTank.getX()
                                            && this.getX() + 40 <= enemyTank.getX() + 60
                                            && this.getY() >= enemyTank.getY()
                                            & this.getY() <= enemyTank.getY() + 40) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出敌人的一辆坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() +60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    & this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }

                            if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                if (this.getX() + 60 >= enemyTank.getX()
                                        && this.getX() + 60 <= enemyTank.getX() + 40
                                        && this.getY() +40>= enemyTank.getY()
                                        & this.getY() +40 <= enemyTank.getY() + 60) {
                                    return true;
                                }
                            }
                            //如果敌人坦克是左右方向
                            if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                                if (this.getX() +60>= enemyTank.getX()
                                        && this.getX() +60<= enemyTank.getX() + 60
                                        && this.getY() >= enemyTank.getY()
                                        & this.getY() <= enemyTank.getY() + 40) {
                                    return true;
                                }

                                if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                    if (this.getX() + 60 >= enemyTank.getX()
                                            && this.getX() + 60 <= enemyTank.getX() + 60
                                            && this.getY() +40 >= enemyTank.getY()
                                            & this.getY() + 40 <= enemyTank.getY() + 40) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出敌人的一辆坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 40
                                    && this.getY()+60>= enemyTank.getY()
                                    & this.getY() +60<= enemyTank.getY() + 60) {
                                return true;
                            }

                            if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                if (this.getX() + 40 >= enemyTank.getX()
                                        && this.getX() + 40 <= enemyTank.getX() + 40
                                        && this.getY() +60>= enemyTank.getY()
                                        & this.getY() +60<= enemyTank.getY() + 60) {
                                    return true;
                                }
                            }
                            //如果敌人坦克是左右方向
                            if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                                if (this.getX() >= enemyTank.getX()
                                        && this.getX() <= enemyTank.getX() + 60
                                        && this.getY() +60>= enemyTank.getY()
                                        & this.getY() + 60<= enemyTank.getY() + 40) {
                                    return true;
                                }

                                if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                    if (this.getX() + 40 >= enemyTank.getX()
                                            && this.getX() + 40 <= enemyTank.getX() + 60
                                            && this.getY() +60>= enemyTank.getY()
                                            & this.getY() +60<= enemyTank.getY() + 40) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出敌人的一辆坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上下方向
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    & this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }

                            if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                if (this.getX()  >= enemyTank.getX()
                                        && this.getX()  <= enemyTank.getX() + 40
                                        && this.getY() + 40>= enemyTank.getY()
                                        & this.getY() + 40<= enemyTank.getY() + 60) {
                                    return true;
                                }
                            }
                            //如果敌人坦克是左右方向
                            if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                                if (this.getX() >= enemyTank.getX()
                                        && this.getX() <= enemyTank.getX() + 60
                                        && this.getY() >= enemyTank.getY()
                                        & this.getY() <= enemyTank.getY() + 40) {
                                    return true;
                                }

                                if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                                    if (this.getX()  >= enemyTank.getX()
                                            && this.getX() <= enemyTank.getX() + 60
                                            && this.getY() >= enemyTank.getY()
                                            & this.getY()+ 40 <= enemyTank.getY() + 40) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;

        }
        return false;
    }


    @Override
    public void run() {
        while (true) {
            //这里判断如果shots size() = 0,创建一颗子弹放入shots集合，放入到shots集合里
            if (isLive && shots.size() < 10) {
                //判断坦克的方向，创建对应的子弹
                Shot s = null;

                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0://向上
                    //让坦克保持一个方向走三十步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000 && !isTouchEnemyTank()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750 && !isTouchEnemyTank()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && !isTouchEnemyTank()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //然后随机改变坦克方向 0-3
            setDirect((int) (Math.random() * 4));

            //多线程，要考虑什么时候结束
            if (!isLive) {
                break;//退出线程
            }

        }
    }
}