package Tries_Huffman;

import java.util.*;
public class huffman {
    /** 用来存放节点值 */
  private static LinkedList<HuffNode> huffList = new LinkedList<HuffNode>();
  
  public static void main(String[] args) {
    // 第一个输入元素个数
    // 然后换行输入 对应权值 元素
    /** 如 
     * 5
     * 10 a
     * 6 b
     * 4 c
     * 19 d
     * 1 e
     * **/
    System.out.println("Please input: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      huffList.add(new huffman().new HuffNode(sc.nextInt(), sc.next()));
    }
    huffmanCode();
    decode(huffList.get(0), "");
  }
  
  class HuffNode implements Comparable<HuffNode> {
    /** 权值 */
    int value;
    String name;
    /** 左孩子节点 */
    HuffNode lChild = null;
    /** 右孩子节点 */
    HuffNode rChild = null;
    
    public HuffNode(int value, String name) {
      this.value = value;
      this.name = name;
    }
    
    public HuffNode(HuffNode lChild, HuffNode rChild) {
      this.lChild = lChild;
      this.rChild = rChild;
      // 权值之和，即合并两个叶子节点
      this.value = lChild.value + rChild.value;
    }
    
    /**
     * 按照权值大小非递减序列
     * @param o
     * @return
     */
    @Override
      public int compareTo(HuffNode o) {
        if (this.value < o.value) {
          return -1;
        } else if (this.value == o.value) {
          return 0;
        } else {
          return 1;
        }
      }
  }
  
  /**
   * 哈夫曼编码
   */
  public static void huffmanCode() {
    if (huffList.size() == 1) {
      return ;
    }
    while (huffList.size() > 1) {
      // 排序
      Collections.sort(huffList);
      // 将前两个节点进行合并
      HuffNode node = new huffman().new HuffNode(huffList.get(0), huffList.get(1));
      // 删除前两个节点
      huffList.remove();
      huffList.remove();
      // 将新生成的节点添加到列表中
      huffList.add(node);
    }
    // 编码完成后，此时huffList中只剩一个根节点
  }
  

  /**
   * 解码
   * @param n
   * @param code
   */
  public static void decode(HuffNode n, String code) {
    if ((n.lChild == null) && (n.rChild == null)) {
      // 叶子节点， 此时输出其对应编码
      System.out.print(n.name + "--->" + code);
      System.out.println();
      return ;
    }
    // 遍历左子树
    decode(n.lChild, code + "0");
    // 遍历右子树
    decode(n.rChild, code + "1");
    return ;
  }

}
