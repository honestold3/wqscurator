package com.wq.thrift

/**
 * Created by wq on 15/11/23.
 */
import com.twitter.util.{Await, Future}
import com.twitter.finagle.Thrift

class DictServiceTestServer {

  def start = {
    val service = Thrift.serveIface("honest:9999", new DictServiceImpl)
    Await.ready(service)
  }

}
