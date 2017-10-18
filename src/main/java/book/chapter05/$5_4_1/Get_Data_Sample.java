package book.chapter05.$5_4_1;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

//ZkClient获取节点数据
public class Get_Data_Sample {
    public static void main(String[] args) throws Exception {
    	
    	String path = "/zk-book";
        ZkClient zkClient = new ZkClient("10.11.130.240:2181,10.11.79.217:2181,10.11.79.218:2181", 5000);
        zkClient.createEphemeral(path, "123");
        
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node " + dataPath + " deleted.");
            }
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("Node " + dataPath + " changed, new data: " + data);
            }
        });
        
        System.out.println(zkClient.readData(path));
        zkClient.writeData(path,"456");
        Thread.sleep(1000);
        zkClient.delete(path);
        Thread.sleep( Integer.MAX_VALUE );
    }
}