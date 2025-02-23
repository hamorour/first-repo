package com.tankegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */

//为了让Panel不停的重绘子弹，需要将MyPanel实现Runable接口，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable{
    //定义我的坦克
    Hero hero = null;

    //定义敌人坦克，放入Vector中
    Vector<EnemyTank> enemyTanks = new Vector<>();

    Vector<Node> nodes =new Vector<>();

    //定义一个Vector，用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，用于显示爆炸效果
    //当子弹击中坦克时，加入Bomb对象
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    int enemyTankSize = 3;
    public MyPanel(String key) throws HeadlessException {
        File file = new File(Recorder.getRecordFile());
        if(file.exists()) {
            nodes = Recorder.getNodesAndEnemyTankRec();
        }else {
            System.out.println("文件不存在，只能开启新游戏");
            key = "1";
        }
        Recorder.setEnemyTanks(enemyTanks);
        this.hero = new Hero(500,100);

        switch (key){
            case "1":
                //初始化敌人坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    //将enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);

                    enemyTank.setDirect(2);

                    //启动坦克线程
                    new Thread(enemyTank).start();

                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());

                    //加入到enemyTank的Vector成员
                    enemyTank.shots.add(shot);

                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                //初始化敌人坦克
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //将enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);

                    enemyTank.setDirect(node.getDirect());

                    //启动坦克线程
                    new Thread(enemyTank).start();

                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());

                    //加入到enemyTank的Vector成员
                    enemyTank.shots.add(shot);

                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("你的输入有误");
        }



        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb3.gif"));
    }

    //编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g){
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);//画出一个敌方坦克
        g.setColor(Color.BLACK);//如果不重置就是青色
        g.drawString(Recorder.getAllEnemyTankNum()+"",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        showInfo(g);
        if (hero!=null && hero.isLive) {
            //编写方法画坦克
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出Hero射出的子弹
//        if(hero.shot!=null && hero.shot.isLive ){
//            g.draw3DRect(hero.shot.x,hero.shot.y,1,1,false);
//        }

        //将hero的子弹集合shots取出，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive ){
                g.draw3DRect(shot.x,shot.y,1,1,false);
            }else {//如果该shot对象已经无效
                hero.shots.remove(shot);
            }
        }

        //如果bombs中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            } else if (bomb.life > 3) {
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb的生命值为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }

        for (EnemyTank enemyTank : enemyTanks) {
            //取出坦克

            //判断当前坦克是否还存活
            if(enemyTank.isLive) {
                drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);

                //画出 enemyTank所有子弹
                for (int i = 0; i < enemyTank.shots.size(); i++) {
                    Shot shot = enemyTank.shots.get(i);
                    if (shot.isLive) {//isLive 为true的时候
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        //从Vector里移出
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }


    }

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克的方向
     * @param type 坦克类型
     */
    public void drawTank (int x,int y,Graphics g,int direct,int type) {
        //根据不同类型的坦克，设置不同的颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向，来绘制坦克
        //direct 表示方向 （0：向上 1：向右 2：向下 3：向左）
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);///画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出坦克的圆盖
                g.drawLine(x+20,y+30,x+20,y); //画出炮筒
                break;
            case 1: //向右
                g.fill3DRect(x,y,60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);///画出坦克的盖子
                g.fillOval(x+20,y+10,20,20);//画出坦克的圆盖
                g.drawLine(x+30,y+20,x+60,y+20); //画出炮筒
                break;
            case 2: //向下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);///画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出坦克的圆盖
                g.drawLine(x+20,y+30,x+20,y+60); //画出炮筒
                break;
            case 3: //向左
                g.fill3DRect(x,y,60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);///画出坦克的盖子
                g.fillOval(x+20,y+10,20,20);//画出坦克的圆盖
                g.drawLine(x+30,y+20,x,y+20); //画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //如果坦克可以发射多颗子弹
    //在判断我方坦克是否击中敌人坦克时，就需要把我们子弹集合中
    //所有子弹，都取出和敌人所有坦克，进行判断
    public void hitEnemyTank() {
        //遍历我们的子弹
        for (int j = 0;j<hero.shots.size();j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive) {//当前我的子弹还存活
                //遍历敌人所有坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }
        }
    }

    //编写方法，判断我方的子弹是否击中敌人坦克
    //什么时候判断子弹击中坦克，重绘的时候判断
    public void hitTank (Shot s,Tank tank){
        //判断s击中坦克
        switch (tank.getDirect()){
            case 0://坦克向上
            case 2://坦克向下
                if (s.x > tank.getX() && s.x <tank.getX()+40
                   && s.y > tank.getY() && s.y < tank.getY()+60){
                    s.isLive=false;
                    tank.isLive=false;
                    //当我的子弹击中敌人坦克后，将enemyTank从Vector中移除
                    enemyTanks.remove(tank);

                    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
                    if(tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }

                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.x > tank.getX() && s.x <tank.getX()+60
                        && s.y > tank.getY() && s.y < tank.getY()+40){
                    s.isLive=false;
                    tank.isLive=false;
                    enemyTanks.remove(tank);
                    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
                    if(tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //编写方法，判断敌人坦克是否击中我方坦克
    public void hitHero () {
        //遍历敌人所有坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank的所有子弹对象
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我方坦克
                if(hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当按下某个键时，该方法被触发
    @Override
    public void keyPressed(KeyEvent e) {
        //下
        if( e.getKeyCode() == KeyEvent.VK_W){
            //改变坦克方向
            hero.setDirect(0);
            if (hero.getY()>0) {
                hero.moveUp();
            }
        } else if ( e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX()+60<1000) {
                hero.moveRight();
            }
        } else if ( e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if(hero.getY()+60<750) {
                hero.moveDown();
            }
        } else if ( e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX()>0) {
                hero.moveLeft();
            }
        }

        //如果用户按下的是J，就发射
        if(e.getKeyCode() == KeyEvent.VK_J){
            //用户按下了J
            //System.out.println("用户按下了J");

            //判断hero的子弹是否销毁
//            if (hero.shot == null){
//                hero.shotEnermyTank();
//            }
            hero.shotEnermyTank();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔一百毫秒，重绘区域，刷新绘图区域，子弹就移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }
}
