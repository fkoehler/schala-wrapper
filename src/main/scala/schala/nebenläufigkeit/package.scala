package schala

import scala.concurrent._
import scala.concurrent.duration.Duration

package object nebenläufigkeit {

  type Zukunft[+GenerischerTyp] = Future[GenerischerTyp]
  type AusführenderKontext = ExecutionContextExecutor
  type GanzeZahl = Int
  type Zeichenkette = String
  type Erwartbar[+GenerischerTyp] = Awaitable[GenerischerTyp]
  type Bearbeitungsdauer = Duration

  object Zukunft {
    def erfolgreich[GenerischerTyp](ergebnis: GenerischerTyp): Zukunft[GenerischerTyp] = Future.successful(ergebnis)
  }

  object Erwarte {
    def ergebnisAuf[GenerischerTyp](erwartbar: Erwartbar[GenerischerTyp], höchstensBis: Bearbeitungsdauer): GenerischerTyp = Await.result(erwartbar, höchstensBis)
  }

  implicit class RichFuture[GenerischerTyp](underlying: Future[GenerischerTyp]) {
    def bildeAbAuf[WeitererGenerischerTyp](f: GenerischerTyp => WeitererGenerischerTyp)(implicit ausführenderKontext: AusführenderKontext): Zukunft[WeitererGenerischerTyp] =
      underlying.map(f)(ausführenderKontext)
  }

  implicit class RichString(underlying: String) {
    def zuGanzerZahl: GanzeZahl = underlying.toInt
  }

}
