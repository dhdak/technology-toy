package com.weizihe.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取某个key，出现的最深的位置，就是层数
 *
 * @author weizihe
 * @date 2021-05-20 16:40
 */
public class MapKeyDeep {
    public static void main(String[] args) {
        Map<String,Object> map  =new HashMap<>();

        Map<String,Object> map2  =new HashMap<>();
        Map<String,Object> map3  =new HashMap<>();
        map3.put("key1",null);
        map2.put("key2",map3);
        map2.put("key5",null);
        map.put("key1",null);
        map.put("key2",map2);

        int deep = recursion(0, 1, "key1", map);
        System.out.println(deep);


    }

    public static int recursion(Integer maxDepth, Integer depth, String key, Map<String,Object> map){
        if (map.containsKey(key)) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
        }
        for (String keys : map.keySet()) {
            if (map.get(keys) instanceof Map) {
                return recursion(maxDepth,depth+1, key,(HashMap)map.get(keys));
            }
        }
        return maxDepth;
    }
}
