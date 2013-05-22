package thinkingInJava.container;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;




public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
	static final int SIZE=997;
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	
	public V put(K key ,V value){
		V oldValue = null;
		int index = Math.abs(key.hashCode())%SIZE;
		if(buckets[index]==null)
			buckets[index]= new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K,V> pair = new MapEntry<K,V>(key,value);
		boolean found = false; 
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		while(it.hasNext()){
			MapEntry<K,V> iPair = it.next();
			if(iPair.getKey().equals(key)){
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;     
			}
		}
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}
	
	public V get(Object key){
		int index = Math.abs(key.hashCode())%SIZE;
		if(buckets[index] == null) return null; 
		for(MapEntry<K,V> iPair:buckets[index]){
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		}
		return null;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets){
			if(bucket==null) continue;
			for(MapEntry<K,V> mpair:bucket)
				set.add(mpair);
		}
		return set;
	}
}
