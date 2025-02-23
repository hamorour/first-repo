package com.tankegame;

import com.file.FileWriter_;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyTankNum = 0;

    private static FileWriter fw =null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "D:\\A_Java_\\myRecord.txt" ;

    //定义一个Vector，指向MyPanel对象的敌人坦克
    private static Vector<EnemyTank> enemyTanks = null;

    private static Vector<Node> nodes = new Vector<>();

    public static String getRecordFile() {
        return recordFile;
    }

    //用于读取文件恢复相关的信息
    public static Vector<Node> getNodesAndEnemyTankRec(){
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            String line = "";
            while ((line= br.readLine())!=null){
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return nodes;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //增加一个方法，当游戏退出时，将allEnemyTankNum保存到recordFile中
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum+"\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){
                    String record = enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                    //写入到文件
                    bw.write(record+"\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;
    }
}
