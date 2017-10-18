package book.chapter05.$5_4_1;

import org.I0Itec.zkclient.ZkClient;

//ZkClient更新节点数据
public class Set_Data_Sample {

    public static void main(String[] args) throws Exception {
    	String path = "/zk-book";
    	ZkClient zkClient = new ZkClient("10.11.130.240:2181,10.11.79.217:2181,10.11.79.218:2181", 2000);
        zkClient.createEphemeral(path, new Integer(1));
        zkClient.writeData(path, new Integer(1));
    }
}