package com.wq.thrift

/**
 * Created by wq on 15/11/23.
 */
object TestCliect  extends App{

  val client = new DictServiceTestClient().stub
  client.put("1","kkkkkkkkk")
  val kankan = client.get("1").get
  println(s"-----------------$kankan")

}
