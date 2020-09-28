class Curso(val nCodigo: Int, val cNome: String, val nQtdeMaxAluno: Int)
{
  var oTitular: ProfessorTitular? = null
  var oAdjunto: ProfessorAdjunto? = null
  private var vListaAlunos = arrayListOf<Aluno>()

  constructor(nCodigo: Int, cNome: String, oTitular: ProfessorTitular, oAdjunto: ProfessorAdjunto, nMaxAlunos: Int): this(nCodigo, cNome, nMaxAlunos)
  {
    this.oTitular = oTitular;
    this.oAdjunto = oAdjunto;
  }

  fun fnAdicionarAluno(oAluno: Aluno): Boolean
  {
    if (vListaAlunos.size >= nQtdeMaxAluno)
      return false

    vListaAlunos.add(oAluno)
    return true
  }

  fun fnExcluirAluno(oAluno: Aluno)
  {
    if(vListaAlunos.contains(oAluno))
      vListaAlunos.remove(oAluno)
  }
}