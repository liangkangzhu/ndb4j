package org.pinae.ndb.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map对象工具集
 * 
 * @author Huiyugeng
 *
 */
public class MapHelper {
	/**
	 * Map对象拷贝
	 * 
	 * @param src 源Map对象
	 * @param propertyRef 键值映射
	 * 
	 * @return 拷贝后的Map对象
	 */
	public static Map<?, ?> copy(Map<?, ?> src, Map<Object, Object> propertyRef) {
		Map<Object, Object> dst = new HashMap<Object, Object>();
		
		Set<?> entrySet = src.entrySet();
		for (Object object : entrySet) {
			if (object != null && object instanceof Entry<?, ?>) {
				Entry<?, ?> entry = (Entry<?, ?>)object;
				Object key = entry.getKey();
				Object value = entry.getValue();
				
				if (key != null) {
					Object refKey = propertyRef.get(key);
					if (refKey != null) {
						dst.put(refKey, value);
					}
				}
			}
		}
		
		return dst;
		
	}
	
	/**
	 * 将数组输出为Map，其中键与值在位置上一一对应
	 * 
	 * @param keys 键集合
	 * @param values 值集合
	 * 
	 * @return 生成的Map对象
	 */
	public static Map<String, String> toMap(String keys[], String values[]) {
		Map<String, String> dst = new HashMap<String, String>();
		
		if (keys != null && values != null && keys.length <= values.length) {
			for (int i = 0; i < keys.length; i++ ) {
				String key = keys[i];
				String value = values[i];
				if (key != null) {
					dst.put(key, value);
				}
			}
		}
		
		return dst;
	}
	
	/**
	 * 将数组输出为Ma
	 * 
	 * @param valuePairs 键值集合，其中第一个元素为键，第二个元素为值
	 * 
	 * @return 生成的Map对象
	 */
	public static Map<String, String> toMap(String[][] valuePairs) {
		Map<String, String> dst = new HashMap<String, String>();
		if (valuePairs != null) {
			for (int i = 0; i < valuePairs.length; i++) {
				String[] valuePair = valuePairs[i];
				if (valuePair != null && valuePair.length == 2) {
					String key = valuePair[0];
					String value = valuePair[1];
					
					if (key != null) {
						dst.put(key, value);
					}
				}
			}
		}
		return dst;
	}
	
	public static Map<String, String> convertToStringMap(Map<?, ?> src) {
		Map<String, String> dst = new HashMap<String, String>();
		
		Set<?> entrySet = src.entrySet();
		for (Object object : entrySet) {
			if (object != null && object instanceof Entry<?, ?>) {
				Entry<?, ?> entry = (Entry<?, ?>)object;
				Object key = entry.getKey();
				Object value = entry.getValue();
				
				if (key != null) {
					if (value == null) {
						value = "";
					}
					dst.put(key.toString(), value.toString());
				}
			}
		}
		
		return dst;
	}
	
	public static Map<Object, Object> convertToObjectMap(Map<String, String> src) {
		Map<Object, Object> dst = new HashMap<Object, Object>();
		
		Set<?> entrySet = src.entrySet();
		for (Object object : entrySet) {
			if (object != null && object instanceof Entry<?, ?>) {
				Entry<Object, Object> entry = (Entry<Object, Object>)object;
				Object key = entry.getKey();
				Object value = entry.getValue();
				
				if (key != null) {
					dst.put(key, value);
				}
			}
		}
		
		return dst;
	}
	
}
