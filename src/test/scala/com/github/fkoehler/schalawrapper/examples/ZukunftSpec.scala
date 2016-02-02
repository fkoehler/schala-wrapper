package com.github.fkoehler.schalawrapper.examples

import org.specs2.mutable.Specification
import schala.nebenläufigkeit._
import schala.nebenläufigkeit.bearbeitungsdauer._

class ZukunftSpec extends Specification {

  "Einen zukünftigen Wert erwarten" in {
    import schala.nebenläufigkeit.ausführenderkontext.implizitewerte.allgemeinGültigerAusführungskontext

    val zukünftigesErgebnis: Zukunft[Zeichenkette] = Zukunft.erfolgreich("1")
    val zukünftigeGanzeZahl: Zukunft[GanzeZahl] = zukünftigesErgebnis.bildeAbAuf(zeichenkette => zeichenkette.zuGanzerZahl)

    Erwarte.ergebnisAuf(zukünftigeGanzeZahl, 1000.millisekunden) ==== 1
  }

}
