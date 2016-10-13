package com.wq.thrift

import com.twitter.util.Future
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by wq on 15/11/23.
 */
class DictServiceImpl extends DictService.FutureIface {

  private val map = new ConcurrentHashMap[String, String]

  def get(key: String): Future[String] = Option(map.get(key)) match {
    case Some(value) => Future.value(value)
    case _ => Future.exception(new DictServiceException("no such key"))
  }

  /*def get(key: String): String = Option(map.get(key)) match {
    case Some(value) =>value
    case _ => "no such key"
  }*/

  def put(key: String, value: String)={
    map.put(key, value)
    Future.Done
  }

}
