package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class RedisTemplateTesta {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testOpsForValueSet1(){
        String key = "username";
        String value = "Rose";
        // 获取操作器，只要在redis中处理的数据的值(String类型)，需要以下操作器
        ValueOperations<String, Serializable> opsForValue
                = redisTemplate.opsForValue();
        opsForValue.set(key,value);
        log.debug("已经向redis中写入简单的String数据");
    }

    //可视化工具:TTL表示过期时间:-1永久有效 -2过期
    @Test
    public void testOpsForValueSet2(){
        String key = "email";
        String value = "wangyi@163.com";
        long timeout = 1L; //设置有效期
        // 获取操作器，只要在redis中处理的数据的值(String类型)，需要以下操作器
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value,timeout, TimeUnit.MINUTES);
        log.debug("已经向redis中写入简单的String数据,有效期为{}分钟",timeout);
    }

    @Test
    public void testOpsForValueSet3(){ // 存储品牌对象
        String key = "brand:item:2";

        BrandDetailVO brandDetailVO = new BrandDetailVO();
        brandDetailVO.setId(2L);
        brandDetailVO.setName("华为");
        brandDetailVO.setPinyin("huawei");

        // 获取操作器，只要在redis中处理的数据的值(对象之也会转换成json字符串类型)，需要以下操作器
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();

        opsForValue.set(key,brandDetailVO);
        log.debug("已经向redis中写入简单的品牌数据,写入的对象为:{}",brandDetailVO);
    }

    @Test
    public void testOpsForValueGet(){
        String key = "brand01";
        // 获取操作器，只要在redis中处理的数据的值(String类型)，需要以下操作器
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();
        Serializable value = opsForValue.get(key);
        log.debug("已经从redis中读取到key={}的数据: {}",key,value);
        log.debug("读取到的数据类型: {}",value.getClass().getName());
    }

    @Test
    public void testDelete(){
        String key = "username";
        Boolean delete = redisTemplate.delete(key);
        log.debug("删除redis中key={}的数据，结果:{}",key,delete);
    }

    @Test
    public void testKeys(){
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);
        log.debug("通过key的模式【{}】找到的key:",keyPattern);
        for(String key : keys){
            log.debug("key={}",key);
        }
    }

    @Test
    public void testOpsForListRightPush(){
        String key = "brands";
        // 准备列表数据
        List<BrandListItemVO> brands = new ArrayList<>();
        for(int i=0;i<10;i++){
            BrandListItemVO brand = new BrandListItemVO();
            brand.setId(i+1L);
            brand.setName("品牌"+i);
            brands.add(brand);
        }
        // 向redis写入列表，首先，需要获取列表对应操作器
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        // 写入列表
        for(BrandListItemVO brand : brands){
            opsForList.rightPush(key,brand);
        }
        log.debug("已经向redis中写入list类型数据");
    }

    @Test
    public void testOpsForListSize(){
        String key = "brands";
        // 需要获取列表对应操作器
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        Long size = opsForList.size(key); //key不存在，size为0
        log.debug("读取key={}的List类型数据的长度:{}",key,size);
    }

    @Test
    public void testOpsForListIndex(){
        String key = "brands";
        // 需要获取列表对应操作器
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        // 从0开始，以长度为10的list为例，有效索引值[0,9]和[-10,-1]
        // 如果正数或负数越界，则返回null
        Long index = 0L;

        Serializable serializable = opsForList.index(key, index);
        log.debug("读取key={}的List类型数据的索引为{}的数据:{}",key,index,serializable);
    }

    @Test
    public void testOpsForListRange(){
        String key = "brands";
        // 需要获取列表对应操作器
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        // start=0,end=9  >>> 全部
        // start=0,end=0  >>> 第一个
        // start=0,end=-1 >>> 全部【推荐】
        // start=0,end=10 >>> 全部
        // start=0,end=-7 >>> 第1个-第4个
        Long start = 0L;
        Long end = 9L;

        List<Serializable> list = opsForList.range(key, start, end);
        log.debug("读取key={}的List类型数据从{}到{}的数据集合:{}",key,start,end,list);


    }

    @Test
    public void testQueue(){
        // 数据结构: 队列
        Queue<Integer> queue = new LinkedList<>();
        // 入队
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        log.debug("队列: {}",queue);
        // 出队(获取队首的元素)
        Integer pollResult = queue.poll();
        log.debug("队首元素: {}",pollResult);
        log.debug("队列: {}",queue);
        // 查看队首元素(不移除)
        pollResult = queue.peek();
        log.debug("队首元素: {}",pollResult);
        log.debug("队列: {}",queue);
    }

    @Test
    public void testDeque(){
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        // 队尾入队
        deque.offerLast(1);
        deque.offer(2);
        // 队首入队
        deque.offerFirst(3);
        deque.offerFirst(4);
        log.debug("队列:{}",deque);

        // 队首出队
        Integer pollResult = deque.poll();
        log.debug("队首:{}",pollResult); //4
        log.debug("队列:{}",deque);
        pollResult = deque.pollFirst();
        log.debug("队首:{}",pollResult); //3
        log.debug("队列:{}",deque);
        // 队尾出队
        pollResult = deque.pollLast();
        log.debug("队尾:{}",pollResult); //2
        log.debug("队列:{}",deque);

        // 查看队首元素
        pollResult = deque.peek();
        log.debug("队首:{}",pollResult); //1
        log.debug("队列:{}",deque);
        pollResult = deque.peekFirst();
        log.debug("队首:{}",pollResult); //1
        log.debug("队列:{}",deque);
        // 查看队尾元素
        pollResult = deque.peekLast();
        log.debug("队首:{}",pollResult); //1
        log.debug("队列:{}",deque);
    }

    @Test
    public void testStack(){
        // 栈
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new LinkedList<>();
        // 入栈、压栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        log.debug("栈:{}",stack);
        // 出栈、弹栈
        int popResult = stack.pop();
        log.debug("出栈元素:{}",popResult);
        log.debug("栈:{}",stack);
        popResult = stack.pop();
        log.debug("出栈元素:{}",popResult);
        log.debug("栈:{}",stack);
        // 查看栈顶结果
        popResult = stack.peek();
        log.debug("栈顶元素:{}",popResult);
        log.debug("栈:{}",stack);

    }


}
