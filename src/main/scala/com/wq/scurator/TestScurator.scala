package com.wq.scurator

/**
 * Created by wq on 15/11/23.
 */
object TestScurator extends App{

  import org.apache.curator.framework.CuratorFrameworkFactory
  import org.apache.curator.retry.RetryOneTime
  import org.scurator.SCuratorClient
  import org.scurator.components._
  import scala.util.{Failure, Success}
  import scala.concurrent.ExecutionContext.Implicits.global

  println("kankan")

  // Create and start a curator client
  val curator = CuratorFrameworkFactory.newClient("honest:2181", new RetryOneTime(1000))
  curator.start()

  // Wrap the instance with SCuratorClient
  val client = SCuratorClient(curator)
  println("kkkk")
  // Call create on the SCuratorClient
  val create = client.create(CreateRequest(path = "/foo"))

  client.exists(ExistsRequest(path = "/foo"))

  println("mmmm")
  // Handle the future response
  create.onComplete {
    case Success(response) => println(s"Created node: ${response.path}")
    case Failure(ex) => println(s"Failed: ${ex.getMessage}")
  }
  println("vvvvv")
}
