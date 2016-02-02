package schala.nebenläufigkeit

package object bearbeitungsdauer {

  implicit class RichInt(underlying: Int) {
    import scala.concurrent.duration._
    def millisekunden: Bearbeitungsdauer = underlying.milliseconds
  }

}
