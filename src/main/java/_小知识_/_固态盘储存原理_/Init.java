package _小知识_._固态盘储存原理_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/31  12:42
 * @description :
 */
public class Init {

    /*
    * QLC
    * TLC
    * MLC
    * SLC
    * 四种颗粒
    *
    * 都是 3D NAND颗粒 （在物理上就是同一种东西）
    *
    * 可以理解为就是能储存电压大小的方块
    * 点压大小可以表示为 0 ， 1
    * 这样的小方块就是 SLC
    * 但是 表示位数 太小了，
    * 我们可以将点压无线划分
    * 我们可以将 00 01 10 11 这样的四个方块 放在一起就成了 MLC
    * 这样 就可以表示 更高位了
    * 就是 MLC = 2SLC
    *
    * 要是 这样 的话 无限细分？
    *
    * 问题：点压充电速度就会变慢
    *
    * SLC 最快 因为只有两种点压
    *
    * 盘越大，速度就会变慢
    * 解决 模拟 SLC方法
    * 比如 480G的 TLC
    * 分出 180G当作SLC使用（高速读写），空闲时再写入到TLC
    * 下次继续分出使用
    *
    * 问题：180G的TLC在SLC 只有60G
    *
    * 要是 不够呢？
    * 模拟SLC有一个极限大小 要是固态中 大小不够 ，就会 掉回TLC读写速度了，
    * 所以 保证固态盘 的大小是必要的！
    *
    *
    *
    *
    *
    *
    * */
}
