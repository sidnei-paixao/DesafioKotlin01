class ProfessorTitular(val cEspecialidade: String): Professor()
{
  constructor(oProfessor: Professor, cEspecialidade: String): this(cEspecialidade)
  {
    this.nCodigo = oProfessor.nCodigo
    this.cNome = oProfessor.cNome
    this.cSobrenome = oProfessor.cSobrenome
  }
}