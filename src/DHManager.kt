import java.time.LocalDateTime

class DHManager
{
  val vAlunos = arrayListOf<Aluno>()
  val vProfessores = arrayListOf<Professor>()
  val vCursos = arrayListOf<Curso>()
  val vMatriculas = arrayListOf<Matricula>()


  fun fnRegistrarCurso(nCodigo: Int, cNome:String, nQtdeAlunos: Int)
  {
    vCursos.add(Curso(nCodigo, cNome, nQtdeAlunos))
  }

  fun fnExcluirCurso(nCodigo: Int)
  {
    vCursos.forEach{if (it.nCodigo == nCodigo) vCursos.remove(it)}
  }

  fun fnRegistrarProfTitular(nCodigo: Int, cNome: String, cSobrenome: String, cEspecialidade: String)
  {
    val oProfessor = Professor(nCodigo, cNome, cSobrenome, LocalDateTime.now())
    vProfessores.add(ProfessorTitular(oProfessor, cEspecialidade))
  }

  fun fnRegistrarProfAdjunto(nCodigo: Int, cNome: String, cSobrenome: String, nHoras: Int)
  {
    val oProfessor = Professor(nCodigo, cNome, cSobrenome, LocalDateTime.now())
    vProfessores.add(ProfessorAdjunto(oProfessor, nHoras))
  }

  fun fnExcluirProfessor(nCodigo: Int)
  {
    vProfessores.forEach{if (it.nCodigo == nCodigo) vProfessores.remove(it)}
  }

  fun fnRegistrarAluno(nCodigo: Int, cNome: String, cSobrenome: String)
  {
    vAlunos.add(Aluno(nCodigo,cNome,cSobrenome))
  }

  fun fnMatricularAluno(nAluno: Int, nCurso: Int)
  {
    var oAluno: Aluno? = null
    var oCurso: Curso? = null

    vAlunos.forEach{if (it.nCodigo==nAluno) oAluno=it}
    vCursos.forEach{if (it.nCodigo==nCurso) oCurso=it}

    if(oAluno==null || oCurso==null)
    {
      println("Código do curso ou matrícula do aluno inválidas, verifique")
      return
    }

    if (oCurso!!.fnAdicionarAluno(oAluno!!))
    {
      vMatriculas.add(Matricula(oAluno!!, oCurso!!))
      println("Matrícula de ${oAluno!!.cNome} realizada no curso ${oCurso!!.cNome}")
    }
    else
      println("Infelizmente, não há mais vagas disponíveis no curso ${oCurso!!.cNome}")

  }

  fun fnAlocarProfessores(nCurso: Int, nTitular: Int, nAdjunto: Int)
  {
    var oCurso: Curso? = null
    var oTitular: Professor? = null
    var oAdjunto: Professor? = null

    vCursos.forEach{if (it.nCodigo==nCurso) oCurso=it}
    vProfessores.forEach{if (it.nCodigo==nTitular) oTitular=it}
    vProfessores.forEach{if (it.nCodigo==nAdjunto) oAdjunto=it}

    if(oCurso==null)
    {
      println("Código do curso inválido, verifique e tente novamente")
      return
    }

    if(oTitular !is ProfessorTitular || oTitular == null)
    {
      println("Professor com código $nTitular não existe, ou não é um professor titular")
      return
    }

    if(oAdjunto !is ProfessorAdjunto || oAdjunto == null)
    {
      println("Professor com código $nTitular não existe, ou não é um professor adjunto")
      return
    }

    oCurso!!.oTitular = oTitular as ProfessorTitular
    oCurso!!.oAdjunto = oAdjunto as ProfessorAdjunto
  }
}