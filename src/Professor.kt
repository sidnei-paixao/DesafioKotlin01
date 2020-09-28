import java.time.Duration
import java.time.LocalDateTime

open class Professor()
{
  var nCodigo = 0
  var cNome = ""
  var cSobrenome = ""
  private var dDataContratacao = LocalDateTime.now()

  constructor(nCodigo: Int, cNome: String, cSobrenome: String, dDataContratacao: LocalDateTime) : this()
  {
    this.nCodigo = nCodigo
    this.cNome = cNome
    this.cSobrenome = cSobrenome
    this.dDataContratacao = dDataContratacao
  }

  fun fnTempoCasa(): Int
  {
    return Duration.between(dDataContratacao, LocalDateTime.now()).toDays().toInt()
  }

}