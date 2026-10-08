import java.util.HashMap;
import java.util.Map;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        // 初始化，10W次赋值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= 100000; i++)
            map.put(i, i);

        /** 增强for循环，keySet迭代 */
        long start = System.currentTimeMillis();
        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));

            map.get(key);

        }
        long end = System.currentTimeMillis();
        System.out.println("增强for循环，keySet迭代 -> " + (end - start) + " ms");
    }
}