package com.wq.thrift

/**
 * Created by wq on 15/11/23.
 */
import com.twitter.finagle.Thrift

class DictServiceTestClient {
  val stub = Thrift.newIface[DictService.FutureIface]("honest:9999")
}
