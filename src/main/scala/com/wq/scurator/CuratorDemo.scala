package com.wq.scurator

/**
 * Created by wq on 15/11/23.
 */

import org.apache.curator.framework.{CuratorFramework, CuratorFrameworkFactory}
import org.apache.curator.retry.{RetryNTimes, RetryOneTime}
import org.apache.zookeeper.{WatchedEvent, Watcher, CreateMode}

object CuratorDemo extends App{
  val path = "/test_path";
  val client = CuratorFrameworkFactory
    .builder()
    .connectString("localhost:2181")
    .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
    .namespace("test2")
    .connectionTimeoutMs(5000).build();
  // 启动 上面的namespace会作为一个最根的节点在使用时自动创建
  client.start();

  // 异步地删除一个节点
  client.delete().inBackground().forPath("/head");

  // 创建一个节点
  client.create().forPath("/head", "kkk".getBytes());
  val kk = client.getData.forPath("/head")
  println(new String(kk))


  // 创建一个临时节点
  client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/head/child", "zzz".getBytes());
  //val zz = client.getChildren.forPath("/head/child")
  //println(zz)


  // 取数据
  client.getData().watched().inBackground().forPath("/head");

  // 检查路径是否存在
  client.checkExists().forPath(path);

  // 异步删除
  //client.delete().inBackground().forPath("/head");

  // 注册观察者，当节点变动时触发
  /*client.getData().usingWatcher(new Watcher() {
    @Override
    public void process(WatchedEvent event) {
      System.out.println("node is changed");
    }
  }).inBackground().forPath("/test");
  */
  println("kkkk")
  client.getData.usingWatcher{
    new Watcher(){
      override def process(event: WatchedEvent): Unit ={
        println("node is changed!!");
      }
    }

  }
  // 结束使用
  client.close();
}
