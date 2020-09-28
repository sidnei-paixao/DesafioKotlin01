class ProfessorAdjunto(var nHorasMonitoria: Int): Professor()
{
  constructor(oProfessor: Professor, nHoras: Int): this(nHoras)
  {
    this.nCodigo = oProfessor.nCodigo
    this.cNome = oProfessor.cNome
    this.cSobrenome = oProfessor.cSobrenome
  }

}