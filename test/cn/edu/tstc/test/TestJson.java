package cn.edu.tstc.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.beanutils.PropertyUtils;

import cn.edu.tstc.entity.User;

public class TestJson {

    /*
     *  普通类型、List、Collection等都是用JSONArray解析
     *  
     *  Map、自定义类型是用JSONObject解析
     *  可以将Map理解成一个对象，里面的key/value对可以理解成对象的属性/属性值
     *  即{key1:value1,key2,value2......}
     * 
     * 1.JSONObject是一个name:values集合，通过它的get(key)方法取得的是key后对应的value部分(字符串)
     *         通过它的getJSONObject(key)可以取到一个JSONObject，--> 转换成map,
     *         通过它的getJSONArray(key) 可以取到一个JSONArray ，
     * 
     * 
     */
    
    //一般数组转换成JSON
    
    public void testArrayToJSON(){
        boolean[] boolArray = new boolean[]{true,false,true};  
        JSONArray jsonArray = JSONArray.fromObject( boolArray );  
        System.out.println( jsonArray );  
        // prints [true,false,true]  
    }
    
    
    //Collection对象转换成JSON
    
    public void testListToJSON(){
        List list = new ArrayList();  
        list.add( "first" );  
        list.add( "second" );  
        JSONArray jsonArray = JSONArray.fromObject( list );  
        System.out.println( jsonArray );  
        // prints ["first","second"]  
    }
    
    
    //字符串json转换成json， 根据情况是用JSONArray或JSONObject
    
    public void testJsonStrToJSON(){
        JSONArray jsonArray = JSONArray.fromObject( "['json','is','easy']" );  
        System.out.println( jsonArray );  
        // prints ["json","is","easy"]  
    }
    
    
    //Map转换成json， 是用jsonObject
    
    public void testMapToJSON(){
        Map map = new HashMap();  
        map.put( "name", "json" );  
        map.put( "bool", Boolean.TRUE );  
        map.put( "int", new Integer(1) );  
        map.put( "arr", new String[]{"a","b"} );  
        map.put( "func", "function(i){ return this.arr[i]; }" );  
          
        JSONObject jsonObject = JSONObject.fromObject( map );  
        System.out.println( jsonObject );  
    }
    
    
    public static void testBeanToJson(){
    	User user = new User();
    	JSONObject jsonObject = JSONObject.fromObject(user);
    	 System.out.println(jsonObject);
    }
    public static void main(String[] args) {
//    	TestJson tj = new TestJson();
//    	tj.testArrayToJSON();
//    	tj.testListToJSON();
//    	tj.testJsonStrToJSON();
//    	tj.testMapToJSON();
    	testBeanToJson();
	}
 }