package schala.nebenläufigkeit.ausführenderkontext

import scala.concurrent.ExecutionContextExecutor

package object implizitewerte {

  implicit val allgemeinGültigerAusführungskontext: ExecutionContextExecutor = scala.concurrent.ExecutionContext.Implicits.global

}
