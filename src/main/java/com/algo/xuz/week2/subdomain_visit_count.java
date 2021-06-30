package com.algo.xuz.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * subdomain_visit_count
 * <p>
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * <p>
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * <p>
 * 示例 2
 * 输入:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 18736
 * @version 1.0
 * 2021/6/29 20:41
 **/
public class subdomain_visit_count {

//     错解: [121 com, 1 wiki, 110 leetcode, 10 intel]
//    public List<String> subdomainVisits(String[] cpdomains) {
//
//
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (String each : cpdomains) {
//            String[] cp_domain = each.split(" ");
//            for (String e : cp_domain[1].split("\\.")) {
//                Integer cp = map.get(e);
//                if (cp != null) {
//                    map.put(e, cp + Integer.valueOf(cp_domain[0]));
//                } else {
//                    map.put(e, Integer.valueOf(cp_domain[0]));
//                }
//            }
//        }
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String, Integer> each : map.entrySet()) {
//            result.add(each.getValue() + " " + each.getKey());
//        }
//        return result;
//    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            // 如一项是 10 a.b.c length 3
            //      index        --                    --   index<0 即结束
            // 遍历putkey c | 下一级 b.c 再下一级 a.b.c 共三个key
            // 从后往前追加, 判断条件即:
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom : counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"100 leetcode.com", "10 com", "10 intel.leetcode.com", "1 wiki.com"};
        List<String> list = new subdomain_visit_count().subdomainVisits(strings);
        System.out.println(list);
    }


}
